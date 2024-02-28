package com.sudhanshu.rest.webservice.restfulwebservices.demo;

public class DemoRestBean {

	String msg;

	public DemoRestBean(String message) {
		this.msg = message;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "DemoRestBean [msg=" + msg + "]";
	}

}
