package com.khoi.model;

import java.sql.Timestamp;

public class NewsModel {
	private long id;
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private long categoryId;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createBby;
	private String modifieBby;

	public NewsModel() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreateBby() {
		return createBby;
	}

	public void setCreateBby(String createBby) {
		this.createBby = createBby;
	}

	public String getModifieBby() {
		return modifieBby;
	}

	public void setModifieBby(String modifieBby) {
		this.modifieBby = modifieBby;
	}

}
