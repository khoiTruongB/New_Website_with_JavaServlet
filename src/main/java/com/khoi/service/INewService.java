package com.khoi.service;

import java.util.List;

import com.khoi.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryCode(String code);
	NewsModel save(NewsModel newsModel);
	void put(NewsModel newsModel);
	void delete(NewsModel newsModel);
}
