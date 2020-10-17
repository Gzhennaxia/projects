package com.gzhennaxia.demo.responsibility_chain;

/**
 * @author bo li
 * @date 2020-10-16 17:37
 */
public abstract class LeaveRequestHandler {
    int threshold;

    public LeaveRequestHandler(int threshold) {
        this.threshold = threshold;
    }

    public abstract Boolean handle(LeaveRequest leaveRequest);
}
