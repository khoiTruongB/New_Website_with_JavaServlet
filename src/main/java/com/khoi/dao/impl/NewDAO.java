package com.khoi.dao.impl;

import java.util.List;

import com.khoi.dao.INewDAO;
import com.khoi.mapper.NewsMapper;
import com.khoi.model.NewsModel;

public class NewDAO extends AdstractDAO<NewsModel> implements INewDAO {

	@Override
	public List<NewsModel> findByCategoryCode(String code) {
		String sql = "SELECT n.* FROM news n, category c WHERE n.categoryid = c.id and c.code = ? ORDER BY n.id; ";
		return query(sql, new NewsMapper(), code);
	}

	@Override
	public Long save(NewsModel newsModel) {
		String sql = "INSERT INTO news (title, content, categoryid) VALUES (?, ?, ?)";

		return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId());

	}

	
	@Override
	public void put(NewsModel newsModel) {
		String sql = "UPDATE news SET title= ?, content= ?, categoryid= ? WHERE id = ?";

		this.update (sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId(), newsModel.getId());

	}

	@Override
	public void delele(NewsModel newsModel) {
		String sql = "DELETE FROM news WHERE id = ?";

		this.update (sql, newsModel.getId());
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}
	
	

}
