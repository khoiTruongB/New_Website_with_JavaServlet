package com.khoi.dao;

import java.util.List;

import com.khoi.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
}
