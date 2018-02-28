package com.jspprj.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForTag extends TagSupport {
	
	private int index =0;
	
	@Override
	public int doStartTag() throws JspException {

		return EVAL_BODY_INCLUDE;
		//EVAL_BODY_INCLUDE  :  바디를 포함
	}
	
	@Override
	public int doAfterBody() throws JspException {
		
		if(++index < 5)
			return EVAL_BODY_AGAIN;
		else
			return SKIP_BODY;
		//EVAL_BODY_AGAIN : 바디 재시작
		//SKIP_BODY : 바디 스킵
	}
	
	@Override
	public int doEndTag() throws JspException {
		 
		return EVAL_PAGE;
		//EVAL_PAGE : 페이지 이어가기
	}
}