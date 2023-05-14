package com.khoi.model;

public class CommentModel extends AdstractModel<CommentModel> {
	private long id;
	private long content;
	private long user_id;
	private long new_id;

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

}
