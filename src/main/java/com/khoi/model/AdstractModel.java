package com.khoi.model;

import java.sql.Timestamp;
import java.util.List;

public class AdstractModel<T> {
	
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private long[] ids;//dùng cho trường hợp xóa nhìu bài viết
	private List<T> listRs;//tạo list chung cho các model
	private Integer page;
	private Integer maxPageItem;//tổng item tối đa trên một trang
	private Integer toltalPage;
	private Integer toltalItem;
	private String sortName;
	private String sortBy;
	
	public String getSortName() {
		return sortName;
	}


	public void setSortName(String sortName) {
		this.sortName = sortName;
	}


	public String getSortBy() {
		return sortBy;
	}


	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
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


	public long[] getIds() {
		return ids;
	}


	public void setIds(long[] ids) {
		this.ids = ids;
	}


	public List<T> getListRs() {
		return listRs;
	}


	public void setListRs(List<T> listRs) {
		this.listRs = listRs;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public Integer getMaxPageItem() {
		return maxPageItem;
	}


	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}


	public Integer getToltalPage() {
		return toltalPage;
	}


	public void setToltalPage(Integer toltalPage) {
		this.toltalPage = toltalPage;
	}


	public Integer getToltalItem() {
		return toltalItem;
	}


	public void setToltalItem(Integer toltalItem) {
		this.toltalItem = toltalItem;
	}


	public void setPage(Integer page) {
		this.page = page;
	}

	
}
