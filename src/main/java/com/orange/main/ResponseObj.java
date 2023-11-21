package com.orange.main;


public class ResponseObj {
    private String code;
    private Object data;
    private String errors;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrors() {
        return errors;
    }
    
    public void setErrors(String errors) {
        this.errors = errors;
    }
}
