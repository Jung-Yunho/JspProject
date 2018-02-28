package com.jspprj.dao_;

import java.util.List;

import com.jspprj.entity.Answeris;
import com.jspprj.entity.AnswerisView;


//JdbcAnswerisDao / mybatisAnswerisDao/ springAnswerisDao구현하기
public interface AnswerisDao 
{
	 int insert(Answeris answeris);
	 int update(Answeris answeris);
	 int delete(String id);
	
	List<AnswerisView> getList(int page);
	 AnswerisView get(String id);
	 int getCount();

}
