package com.yin.designUsage.mybatis.plugin.annotation;

import java.lang.annotation.*;

/**
 * @Author: eason
 * @Description:
 * @Date: 21:03 2019/10/17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Intercepts {
    Signature[] value();
}
