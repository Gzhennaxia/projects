package com.gzhennaxia.demo.responsibility_chain;

import java.util.Random;

/**
 * @author bo li
 * @date 2020-10-16 17:40
 */
public class GeneralManagerHandler extends LeaveRequestHandler {

    public GeneralManagerHandler(int threshold) {
        super(threshold);
    }

    @Override
    public Boolean handle(LeaveRequest leaveRequest) {
        if (leaveRequest.days <= threshold){
            return new Random().nextBoolean();
        }
        return null;
    }
}
