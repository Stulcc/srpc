package com.stulcc;

import java.util.HashMap;

public class RpcApp {
    RpcApp rpcApp;


    HashMap<String, Object> referers = new HashMap<>();

    public static RpcApp getInstance() {
        return null;
    }

    public <T> T getReferer(String name) {
        return (T) referers.get(name);
    }

}
