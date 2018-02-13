package com.newlecture.jspweb.dao;

import java.util.List;

import com.newlecture.jspweb.entity.Notice;


public interface NoticeDao{ 
	
	//오버로드
	List<Notice> getList();
	List<Notice> getList(String query);
	List<Notice> getList(int page);
	List<Notice> getList(int page, String field, String query);

	//공지사항 Notice getNotice(String id)
	Notice get(String id);
	
	//이전글, 다음글
	Notice getPrev(String id);
	Notice getNext(String id);
	
}