package com.yj.miaosha.result;

public class Result<T>{
    private int code;
    private String msg;
    private T t;


    private Result(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    private Result(CodeMsg msg, T t) {
        if(msg == null){
            return;
        }
        this.code = msg.getCode();
        this.msg = msg.getMsg();
        this.t = t;
    }

    public static <T> Result<T> success(T t){
        return new Result<T>(CodeMsg.SUCCESS, t);
    }

    public static <T> Result<T> error(CodeMsg msg){
        return new Result<T>(msg, null);
    }
}
