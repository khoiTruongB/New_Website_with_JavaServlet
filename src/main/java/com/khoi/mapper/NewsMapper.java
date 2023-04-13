package com.khoi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.khoi.model.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet rs) {
		NewsModel newsModel = new NewsModel();
		try {
			newsModel.setId(rs.getLong("id"));
			newsModel.setTitle(rs.getString("title"));
			newsModel.setContent(rs.getString("thumbnail"));
			newsModel.setShortDescription(rs.getString("shortdescription"));
			newsModel.setContent(rs.getString("content"));
			newsModel.setCategoryId(rs.getLong("categoryid"));
			newsModel.setCreatedDate(rs.getTimestamp("createddate"));
			newsModel.setCreatedBy(rs.getString("createdby"));
			if (rs.getTimestamp("modifieddate") != null) {
				newsModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			if (rs.getString("modifiedby") != null) {
				newsModel.setModifiedBy(rs.getString("modifiedby"));
			}
			return newsModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
