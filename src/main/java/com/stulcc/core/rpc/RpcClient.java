package com.stulcc.core.rpc;

import com.stulcc.core.RpcRequest;
import com.stulcc.core.RpcResponse;

import java.util.concurrent.CompletableFuture;

public interface RpcClient {

    RpcResponse call(RpcRequest rpcRequest);

    CompletableFuture<RpcResponse> callAsync(RpcRequest rpcRequest);
}
