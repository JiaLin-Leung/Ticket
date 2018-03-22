package com.TrictSystem.Beans;

import java.io.Serializable;

/**
 * Created by smile_raccoon on 2018/1/16.
 */

public class Login_Error implements Serializable {

    /**
     * 数据库返回信息
     */
    private String message;
    /**
     * 是否有下一页
     */
    private String next;
    /**
     * 响应值
     */
    private String response;
    /**
     * 错误响应信息
     */
    private String error;
    /**
     * 错误对象
     */
    private Error_data data;
    private class Error_data implements Serializable{}

    @Override
    /**
     * toString方法
     */
    public String toString() {
        return "Login_Error{" +
                "message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 获得数据库返回信息
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置数据库返回信息
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * 获得下一页标记
     * @return
     */
    public String getNext() {
        return next;
    }

    /**
     * 设置下一页标记
     * @param next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * 获取返回状态值
     * @return
     */
    public String getResponse() {
        return response;
    }

    /**
     * 设置返回状态值
     * @param response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * 获取错误信息
     * @return
     */
    public String getError() {
        return error;
    }

    /**
     * 设置错误信息
     * @param error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 获得返回数据
     * @return
     */
    public Error_data getData() {
        return data;
    }

    /**
     * 设置返回数据
     * @param data
     */
    public void setData(Error_data data) {
        this.data = data;
    }
}
