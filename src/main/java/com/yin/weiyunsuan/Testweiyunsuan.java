package com.yin.weiyunsuan;

import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by easony on 06/19/18.
 */
public class Testweiyunsuan {
    public static void main(String[] args) {
        System.out.println(3029737 & 15);
        String a = "abcdefg";
        System.out.println(a.substring(0,2));
    }

    @Test
    public void mapIterator(){
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"as");
        map.put(2,"ff");
        for (Integer str : map.keySet()){
            System.out.println(map.get(str));
        }

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey()+" " +entry.getValue());
        }

    }
}
