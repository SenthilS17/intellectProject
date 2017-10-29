package com.intellect.user.mgmt.util;

public enum AppErrorCodeEnum {

	MANDATORY_FIELDS("601 - Cannot be Empty"),
	DATATYPE_MISMATCH("602 - Data type Mismatch" ),
	DATE_FORMAT_MISMATCH("603 - Format should be in dd/MMM/yyyy format"),
	FUTURE_DATE("604 - Cannot be Future date");
	
	
    
    private String code;

	AppErrorCodeEnum(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

	
	
}
