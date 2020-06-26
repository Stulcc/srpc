package com.stulcc.core.rpc;

import com.stulcc.util.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RpcInvokerFactory {


    NamedThreadFactory threadFactory = new NamedThreadFactory("srpc_async_notifier");

    private static Logger logger = LoggerFactory.getLogger(RpcInvokerFactory.class);
    private ThreadPoolExecutor responseCallbackThreadPool = new ThreadPoolExecutor(10, 100,
            60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000), threadFactory);

    {
        responseCallbackThreadPool.prestartAllCoreThreads();
    }


}
