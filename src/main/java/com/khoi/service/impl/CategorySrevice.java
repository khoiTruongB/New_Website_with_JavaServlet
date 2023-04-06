package com.khoi.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.khoi.dao.ICategoryDAO;
import com.khoi.model.CategoryModel;
import com.khoi.service.ICategoryService;

public class CategorySrevice implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> findAll() {

		return categoryDAO.findAll();
	}

}
