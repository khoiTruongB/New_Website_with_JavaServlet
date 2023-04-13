package com.khoi.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.khoi.dao.INewDAO;
import com.khoi.model.NewsModel;
import com.khoi.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDAO;

	@Override
	public List<NewsModel> findByCategoryCode(String code) {
		return newDAO.findByCategoryCode(code);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		//tạo ngày tạo và người tạo
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));	
		newsModel.setCreatedBy("");
		Long newId = newDAO.save(newsModel);
		return newDAO.findOne(newId);
	}

	@Override
	public NewsModel put(NewsModel updateNew) {
		NewsModel oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		//tạo ngày cập nhật và người cập nhật
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDAO.put(updateNew);
		return newDAO.findOne(updateNew.getId());

	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDAO.delele(id);
		}
	}

}
