package com.khoi.dao;

import java.util.List;

import com.khoi.model.NewsModel;

public interface INewDAO extends IGenericDAO<NewsModel>{
	List<NewsModel> findByCategoryCode(String code);
	Long save(NewsModel newsModel);
}
