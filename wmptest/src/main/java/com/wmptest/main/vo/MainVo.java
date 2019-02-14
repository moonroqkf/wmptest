package com.wmptest.main.vo;

public class MainVo {
	
	String url;
	String html;
	String type;
	int printGroupSize;
	
	String[] result;
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
