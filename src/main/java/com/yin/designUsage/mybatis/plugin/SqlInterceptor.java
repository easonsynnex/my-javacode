package com.yin.designUsage.mybatis.plugin;

import com.yin.designUsage.mybatis.mapper.BlogMapper;
import com.yin.designUsage.mybatis.plugin.annotation.Intercepts;
import com.yin.designUsage.mybatis.plugin.annotation.Signature;

@Intercepts({@Signature(type = BlogMapper.class, method = "selectBlogById", args = {Integer.class})})
public class SqlInterceptor implements Interceptor {
    @Override
    public Object intercept() {
        return null;
    }

    @Override
    public Object plugin() {
        return null;
    }
}
