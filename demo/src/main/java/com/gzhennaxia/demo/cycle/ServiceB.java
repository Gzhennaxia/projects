package com.gzhennaxia.demo.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author bo li
 * @date 2020-10-27 16:18
 */
@Service
public class ServiceB {

    @Autowired
    @Lazy
    private ServiceA serviceA;

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
