package com.khoi.dao.impl;

import java.util.List;

import com.khoi.dao.ICategoryDAO;
import com.khoi.mapper.CategoryMapper;
import com.khoi.model.CategoryModel;

public class CategoryDAO extends AdstractDAO<CategoryModel> implements ICategoryDAO {

	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category;";
		return query(sql, new CategoryMapper());
	}

}
