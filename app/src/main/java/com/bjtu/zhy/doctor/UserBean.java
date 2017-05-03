package com.bjtu.zhy.doctor;

/**
 * Created by zhy on 2017/4/12.
 */

public class UserBean {
	String title;
	String detail;

	public UserBean(String title, String detail) {
		this.title = title;
		this.detail = detail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
