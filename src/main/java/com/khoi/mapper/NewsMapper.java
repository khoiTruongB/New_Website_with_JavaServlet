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
			newsModel.setCategoryId(rs.getLong("categoryid"));
			return newsModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
