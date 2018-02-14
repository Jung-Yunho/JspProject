package com.newlecture.jspweb.dao;

import java.util.List;

import com.newlecture.jspweb.entity.Notice;
import com.newlecture.jspweb.entity.NoticeView;

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

	/*int insert(Notice notice);			//좋아요 테이블에 대한 데이터 축적하기
	int update(Notice notice);		//좋아요 컬럼에 대한 데이터를 get 하고 난 뒤 update
	int delete(String id);*/
	
/*------------------------------view 의 데이터 사용------------------------------*/	
	/*List<NoticeView> getList();
	
	NoticeView get(String id);
	
	//이전글, 다음글
	NoticeView getPrev(String id);
	NoticeView getNext(String id);

	int insert(Notice notice);			//좋아요 테이블에 대한 데이터 축적하기
	int update(Notice notice);		//좋아요 컬럼에 대한 데이터를 get 하고 난 뒤 update
	int delete(String id);*/
}