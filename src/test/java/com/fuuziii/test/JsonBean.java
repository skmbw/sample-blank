package com.fuuziii.test;

/**
 * Json通用格式。
 *
 * @author yinlei
 * @since 2017/10/9 14:11
 */
public class JsonBean<T> {
    /**
     * 错误代码，1表示正确
     */
    private int code = 1;

    /**
     * 错误信息，当code=1时，message一般为空。当出现错误时，描述错误信息。
     */
    private String message;

    /**
     * 业务数据
     */
    private T data;

    public JsonBean() {
    }

    public JsonBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonBean(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
