package com.khoi.dao;

import java.util.List;

import com.khoi.mapper.IRowMapper;

public interface IGenericDAO<T> {
	//Object...parameter muốn truyền bao nhiêu thay số cx đc
	<T> List<T> query(String sql, IRowMapper<T> rowMapper, Object...parameter);
	void update (String sql, Object...parameter);
	Long insert (String sql, Object...parameter);
	int Count(String sql, Object...parameter);
}
