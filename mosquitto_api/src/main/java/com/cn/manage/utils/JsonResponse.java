package com.cn.manage.utils;

public class JsonResponse<T> {

    String message;

    Integer status;

    String errorCode;

    boolean success;

    T result;

    public JsonResponse() {
        this.status = 0;
        this.errorCode = "";
        this.success = false;
    }

    public JsonResponse(boolean success,int status,String msg) {
        this.errorCode = msg;
        this.success = success;
    }


    public void setResult(T result) {
        this.result = result;
    }

    public T getResult(){
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
