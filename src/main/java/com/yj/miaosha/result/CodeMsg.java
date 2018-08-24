package com.yj.miaosha.result;

import java.io.Serializable;

public class CodeMsg{
    private int code;
    private String msg;

    public  static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public  static CodeMsg SERVER_ERROR = new CodeMsg(500, "server error");

    public CodeMsg(int i, String msg) {
        this.code = i;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
