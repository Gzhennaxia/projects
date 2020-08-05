package com.gzhennaxia.ledger.open.waimai.meituan.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bo li
 * @date 2020-08-04 14:14
 */
@RestController
public class AuthController {

    @GetMapping("/meituan/waimai/callback/code")
    public String code(String code, String state) {
        System.out.println(code);
        System.out.println(state);
        return code;
    }
}
