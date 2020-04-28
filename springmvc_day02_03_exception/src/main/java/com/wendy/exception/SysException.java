package com.wendy.exception;

/**
 * Author : wendy_wan
 * Created : 2020/4/28 11:02
 */
/*
* 自定义异常类
* */
public class SysException extends Exception{
    //存储提示信息
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
