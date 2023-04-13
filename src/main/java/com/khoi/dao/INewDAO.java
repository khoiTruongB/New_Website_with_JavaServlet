package com.khoi.dao;

import java.util.List;

import com.khoi.model.NewsModel;

public interface INewDAO extends IGenericDAO<NewsModel>{
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryCode(String code);
	Long save(NewsModel newsModel);
	void put (NewsModel newsModel);
	void delele (long id);
}
