package com.gzhennaxia.demo.responsibility_chain;

/**
 * @author bo li
 * @date 2020-10-16 18:03
 */
public class LeaveRequestHandlerChain {

    LeaveRequestHandler head;
    LeaveRequestHandlerChain next;

    public LeaveRequestHandlerChain(LeaveRequestHandler head) {
        this.head = head;
    }

    public static Boolean process(LeaveRequest leaveRequest) {
        return null;
    }
}
