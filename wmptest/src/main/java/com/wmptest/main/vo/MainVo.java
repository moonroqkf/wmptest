package com.wmptest.main.vo;

public class MainVo {
	
	/** 읽어들일 웹페이지 url */
	String url;
	
	/** 가공한 html 텍스트 */
	String html;
	
	/** 출력타입 구분 */
	String type;
	
	/** 출력묶음 단위 */
	int printGroupSize;
	
	/** 출력결과값(몫) */
	String[] result;
	
	/** 출력결과값(나머지) */
	String remainStr;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrintGroupSize() {
		return printGroupSize;
	}
	public void setPrintGroupSize(int printGroupSize) {
		this.printGroupSize = printGroupSize;
	}
	public String[] getResult() {
		return result;
	}
	public void setResult(String[] result) {
		this.result = result;
	}
	public String getRemainStr() {
		return remainStr;
	}
	public void setRemainStr(String remainStr) {
		this.remainStr = remainStr;
	}

	
}
