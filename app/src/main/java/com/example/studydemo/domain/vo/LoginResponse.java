package com.example.studydemo.domain.vo;

public class LoginResponse {
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
