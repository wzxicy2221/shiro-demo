package com.zexinwang.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author Zexin.Wang
 * @Date 2017/7/31.
 * @Description
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
