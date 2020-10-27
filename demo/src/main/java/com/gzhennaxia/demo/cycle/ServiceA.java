package com.gzhennaxia.demo.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author bo li
 * @date 2020-10-27 16:18
 */
@Service
public class ServiceA {

    private ServiceB serviceB;

    @PostConstruct
    public void init() {
        this.serviceB.setServiceA(this);
    }
}
