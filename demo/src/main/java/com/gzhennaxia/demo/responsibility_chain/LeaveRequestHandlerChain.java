package com.gzhennaxia.demo.responsibility_chain;

/**
 * @author bo li
 * @date 2020-10-16 18:03
 */
public class LeaveRequestHandlerChain {

    LeaveRequestHandler head;
    LeaveRequestHandlerChain next;

    public LeaveRequestHandlerChain() {
    }

    public LeaveRequestHandlerChain(LeaveRequestHandler head) {
        this.head = head;
    }

    public void addHandler(LeaveRequestHandler handler) {
        if (this.head == null) {
            this.head = handler;
            return;
        }
        LeaveRequestHandlerChain h = this;
        while (h.next != null) h = h.next;
        h.next = new LeaveRequestHandlerChain(handler);
    }

    public Boolean process(LeaveRequest leaveRequest) {
        Boolean result = head.handle(leaveRequest);
        if (result != null) return result;
        return next.head.handle(leaveRequest);
    }
}
