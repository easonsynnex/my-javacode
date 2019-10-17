package com.yin.designUsage.mybatis.mapper;

import com.yin.designUsage.mybatis.beans.Blog;

/**
 * @Author: eason
 * @Description: 接口
 * @Date: 20:43 2019/10/17
 */
public interface BlogMapper {
    Blog selectBolgById(Integer id);
}
