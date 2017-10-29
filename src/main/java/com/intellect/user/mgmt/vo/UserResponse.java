package com.intellect.user.mgmt.vo;

import java.util.List;

public class UserResponse {

	String resMsg;
	String userId;
	List<String[]> valErrors;

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String[]> getValErrors() {
		return valErrors;
	}

	public void setValErrors(List<String[]> valErrors) {
		this.valErrors = valErrors;
	}

}
