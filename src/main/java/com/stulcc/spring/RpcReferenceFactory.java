package com.stulcc.spring;

import com.stulcc.RpcApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class RpcReferenceFactory<T> implements FactoryBean<T> {

    private String id;
    private String interfaceName;

    static Logger log = LoggerFactory.getLogger(RpcReferenceFactory.class);

    public RpcReferenceFactory(String id, String interfaceName) {
        this.id = id;
        this.interfaceName = interfaceName;
    }

    @Override
    public T getObject() throws Exception {
        return RpcApp.getInstance().getReferer(id);
    }

    @Override
    public Class<?> getObjectType() {
        try {
            return Class.forName(interfaceName);
        } catch (Throwable e) {
            log.error("cannot found class: " + interfaceName);
            System.exit(-1);
            return null;
        }
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
