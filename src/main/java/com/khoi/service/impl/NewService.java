package com.khoi.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.khoi.dao.INewDAO;
import com.khoi.model.NewsModel;
import com.khoi.service.INewService;

public class NewService implements INewService{

	@Inject
	private INewDAO newDAO;
	
	@Override
	public List<NewsModel> findByCategoryCode(String code) {
		return newDAO.findByCategoryCode(code);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		Long newId = newDAO.save(newsModel);
		
		return newDAO.findOne(newId);
	}

	@Override
	public void put(NewsModel newsModel) {
		newDAO.put(newsModel);
		
	}

	@Override
	public void delete(NewsModel newsModel) {
		newDAO.delele(newsModel);
	}

}
