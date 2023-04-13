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

		StringBuilder sql = new StringBuilder("INSERT INTO news(title, thumbnail, shortdescription, content, categoryid, createddate, createdby) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newsModel.getTitle(), newsModel.getThumbnail(), 
						   newsModel.getShortDescription(), newsModel.getContent(), 
						   newsModel.getCategoryId(), newsModel.getCreatedDate(), newsModel.getCreatedBy());

	}

	
	@Override
	public void put(NewsModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET ");
		sql.append("title= ?, thumbnail= ?, shortdescription= ?, ");
		sql.append("content= ?, categoryid= ?, createddate= ?, createdby= ?, ");
		sql.append("modifieddate= ?, modifiedby= ? ");
		sql.append("WHERE id = ?");
		update (sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
					updateNew.getContent(), updateNew.getCategoryId(),
					updateNew.getCreatedDate(), updateNew.getCreatedBy(), updateNew.getModifiedDate(), updateNew.getModifiedBy(),
					updateNew.getId());

	}

	@Override
	public void delele(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		
		update (sql, id);
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}
	
	

}
