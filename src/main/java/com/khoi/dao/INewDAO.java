package com.khoi.dao;

import java.util.List;

import com.khoi.model.NewsModel;
import com.khoi.paging.Pageble;

public interface INewDAO extends IGenericDAO<NewsModel>{
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryCode(String code);
	Long save(NewsModel newsModel);
	void put (NewsModel newsModel);
	void delele (long id);
	//List<NewsModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
	List<NewsModel> findAll(Pageble pageble);
	int getToltalItem();
}
