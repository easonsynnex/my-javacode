package com.yin.springDI;

import com.yin.springDI.annotation.MyAutowired;
import com.yin.springDI.annotation.MyComponent;
import com.yin.springDI.annotation.MyValue;
import com.yin.springDI.service.UserService;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: eason
 * @Description: 模拟spring bean工厂,生成实例
 * @Date: 22:35 2018/5/8
 */
public class AnnotationConfigApplicationContext {

    //存储注解的类定义对象
    private Map<String, Class<?>> beanDefinationFactory =  new HashMap<String, Class<?>>();

    private Map<String, Object> singletonBeanFactory = new HashMap<String, Object>();

    /*
     * 构造函数中扫描指定的包名
     */
    public AnnotationConfigApplicationContext(String ... packageNames) {
        //循环扫描包
        for (String packageName : packageNames){
            scanPackage(packageName);
        }
        dependencyInjection();
    }

    /**
     * @Author: eason
     * @Description: 扫描包路径下所有的MyComponent注解放入beanDefinationFactory中去
     * @Date: 22:47 2018/5/8
     */
    private void scanPackage(String packageName) {
        String pkg = packageName.replaceAll("\\.", "/");
        //获取资源路径
        URL url = this.getClass().getClassLoader().getResource(pkg);
        //获取路径下所有的文件
        File file = new File(url.getFile());
        //过滤出class文件
        File[] fs = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()){
                    scanPackage(packageName);
                }else{
                    String fileName = pathname.getName();
                    if (fileName.endsWith(".class")){
                        return true;
                    }
                }
                return false;
            }
        });
        //遍历class文件，通过反射生成class放入beanDefinationFactory中
        for (File fc : fs){
            String fileName = fc.getName();
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            String beanId = String.valueOf(fileName.charAt(0)).toLowerCase() + fileName.substring(1);
            try {
                Class<?> cl = Class.forName(packageName + "." + fileName);
                if (cl.isAnnotationPresent(MyComponent.class))
                    beanDefinationFactory.put(beanId, cl);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void dependencyInjection(){
        Collection<Class<?>> classes = beanDefinationFactory.values();
        for (Class cls : classes){
            //获取类名
            String className = cls.getName();
            className = className.substring(className.lastIndexOf(".") + 1);
            String beanId = String.valueOf(className.charAt(0)).toLowerCase() + className.substring(1);
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields){
                //如果有MyAutowired注解则注入,并且放入singletonBeanFactory中去
                if (field.isAnnotationPresent(MyAutowired.class)){
                    //获取类对象名
                    String fieldName = field.getType().getName();
                    fieldName = fieldName.substring(fieldName.lastIndexOf(".") + 1);
                    fieldName = String.valueOf(fieldName.charAt(0)).toLowerCase() + fieldName.substring(1);
                    System.out.println("field name:" + fieldName);
                    Object fieldBean = getBean(fieldName);
                    System.out.println("beanId:" + beanId);
                    Object clsBean = getBean(beanId);
                    try {
                        field.setAccessible(true);
                        //这里是引用传递，将属性注入后在singletonBeanFactory中的对应的singleton实例中
                        field.set(clsBean, fieldBean);
                        System.out.println("注入成功");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("注入失败");
                    }
                }
            }
        }
    }

    public Object getBean(String beanId){
        Class<?> cls = beanDefinationFactory.get(beanId);
        MyComponent annotation = cls.getAnnotation(MyComponent.class);
        String scope = annotation.scope();

        try {
            if ("singleTon".equals(scope) || "".equals(scope)){
                if (singletonBeanFactory.get(beanId) == null){
                    Object obj = cls.newInstance();
                    singletonBeanFactory.put(beanId, obj);
                }
                return singletonBeanFactory.get(beanId);
            }else if ("prototype".equals(scope)){
                Object obj = cls.newInstance();
                return obj;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setFieldsValue(Object obj) throws NoSuchMethodException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(MyValue.class)){
                MyValue annotation = field.getAnnotation(MyValue.class);
                String value = annotation.value();
                String name = field.getName();
                String type = field.getType().getName();
                String setter = "set" + String.valueOf(name.charAt(0)).toUpperCase() + name.substring(1);
                Method setMethod = obj.getClass().getDeclaredMethod(setter);
                if ("java.lang.Integer".equals(type)){

                }

            }
        }
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.yin.springDI.service", "com.yin.springDI.Entity");
        UserService userService = (UserService)ctx.getBean("userService");
        userService.login();
    }
}
