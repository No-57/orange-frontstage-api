package com.orange.main;

public class ResponseObj {
    private int code;
    private Object data;
    private String extra;
    private String message;

    public ResponseObj(){};
    
    public ResponseObj(int code, String extra, String message){
        this.code = code;
        this.extra = extra;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
