package com.yin.designUsage.mybatis.plugin;

public interface Interceptor {
    Object intercept();
    Object plugin();
}
