package com.khoi.service;

import java.util.List;

import com.khoi.model.NewsModel;
import com.khoi.paging.Pageble;

public interface INewService {
	List<NewsModel> findByCategoryCode(String code);
	NewsModel save(NewsModel newsModel);
	NewsModel put(NewsModel newsModel);
	void delete(long[] ids);
	List<NewsModel> findAll(Pageble pageble);
	int getToltalItem();
}
