package com.khoi.model;

import java.sql.Timestamp;

public class CommentModel {
	private long id;
	private long content;
	private long user_id;
	private long new_id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;

	public CommentModel() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getContent() {
		return content;
	}

	public void setContent(long content) {
		this.content = content;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getNew_id() {
		return new_id;
	}

	public void setNew_id(long new_id) {
		this.new_id = new_id;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
