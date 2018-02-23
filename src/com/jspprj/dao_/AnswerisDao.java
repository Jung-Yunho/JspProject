package com.jspprj.dao_;

import java.util.List;

import com.jspprj.entity.Answeris;
import com.jspprj.entity.AnswerisView;


//JdbcAnswerisDao / mybatisAnswerisDao/ springAnswerisDao구현하기
public interface AnswerisDao 
{
	public int insert(Answeris answeris);
	public int update(Answeris answeris);
	public int delete(String id);
	
	public List<AnswerisView> getList();
	public AnswerisView get(String id);

}
