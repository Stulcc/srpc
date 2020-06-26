package com.stulcc.core;

import java.util.concurrent.*;

public class RpcFutureResponse extends CompletableFuture<RpcResponse> {

    // net data
    private RpcRequest request;
    private RpcResponse response;

    public RpcFutureResponse(RpcRequest request) {
        this.request = request;
    }

    @Override
    public boolean complete(RpcResponse value) {
        return super.complete(value);
    }
}
