package com.yj.miaosha.redis;

public abstract class BasePrefix implements KeyPrefix{

    private String prefix;
    private int expireSeconds;

    public BasePrefix(int expireSeconds, String prefix){
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    public BasePrefix(String prefix){
        this.expireSeconds = 0;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return this.expireSeconds;
    }

    @Override
    public String getPrefix() {
        return getClass().getSimpleName() + prefix;
    }
}
