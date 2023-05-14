package com.khoi.paging;

import com.khoi.sort.Sorter;

public interface Pageble {
	Integer getPage();//lấy ra vị trí trang đang đứng
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
