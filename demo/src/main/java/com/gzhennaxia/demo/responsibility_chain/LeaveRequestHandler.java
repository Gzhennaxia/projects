package com.gzhennaxia.demo.responsibility_chain;

/**
 * @author bo li
 * @date 2020-10-16 17:37
 */
public abstract class LeaveRequestHandler {

    public abstract void process(LeaveRequest leaveRequest);
}
