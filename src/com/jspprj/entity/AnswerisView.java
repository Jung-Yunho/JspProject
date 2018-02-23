package com.jspprj.entity;

import java.util.Date;

public class AnswerisView extends Answeris 
{
	private int commentCount;
	
	public AnswerisView() 
	{
		
	}
	
	

	public AnswerisView(
							String id, 
							String title, 
							String language, 
							String platform, 
							String runtime, 
							String errorCode,
							String errorMessage, 
							String situation, 
							String triedToFix, 
							String reason, 
							String writerId, 
							String howToFix,
							Date regDate, 
							int hit, 
							int commentCount) 
	{
		super(id,  title, language, platform, runtime, errorCode, errorMessage, situation, triedToFix, reason, writerId,
				howToFix, regDate, hit);
		
		this.commentCount = commentCount;
		
	}



	public int getCommentCount() 
	{
		return commentCount;
	}

	public void setCommentCount(int commentCount) 
	{
		this.commentCount = commentCount;
	}
	

}
