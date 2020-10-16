package com.gzhennaxia.demo.responsibility_chain;

/**
 * @author bo li
 * @date 2020-10-16 17:42
 */
public class Worker {
    public static void main(String[] args) {
        int days = 3;
        Boolean response = requestLeave(days);
        System.out.println("申请" + days + "天," + (response ? "申请成功！" : "申请失败！"));
    }

    private static Boolean requestLeave(int days) {
        LeaveRequest leaveRequest = new LeaveRequest(days);
        return LeaveRequestHandlerChain.process(leaveRequest);
    }
}
