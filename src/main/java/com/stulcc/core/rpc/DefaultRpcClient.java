package com.stulcc.core.rpc;

import com.stulcc.core.RpcFutureResponse;
import com.stulcc.core.RpcRequest;
import com.stulcc.core.RpcResponse;
import com.stulcc.core.transport.NettyClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DefaultRpcClient implements RpcClient {


    private NettyClient transportClient;

    private long timeout = 1000;

    @Override
    public RpcResponse call(RpcRequest rpcRequest) {
        RpcFutureResponse rpcFutureResponse = new RpcFutureResponse(rpcRequest);
        String address = null;
        transportClient.send(address, rpcRequest);
        RpcResponse rpcResponse;
        try {
            rpcResponse = rpcFutureResponse.get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            rpcResponse = new RpcResponse(-603, "USER_CANCEL");
        } catch (TimeoutException e) {
            rpcResponse = new RpcResponse(-602, "RPC_TIMEOUT");
        } catch (Exception e) {
            rpcResponse = new RpcResponse(-620, "EXEC_EXCEPTION");
        }
        return rpcResponse;
    }

    @Override
    public CompletableFuture<RpcResponse> callAsync(RpcRequest rpcRequest) {
        return null;
    }
}
