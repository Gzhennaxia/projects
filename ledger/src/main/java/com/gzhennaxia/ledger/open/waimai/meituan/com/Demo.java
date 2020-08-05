package com.gzhennaxia.ledger.open.waimai.meituan.com;

import org.springframework.boot.web.client.RestTemplateBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * @author bo li
 * @date 2020-08-04 13:56
 */
public class Demo {

    private static String APP_ID = "3715965202261699";
    private static String SECRET = "bea9acd83d6d4bb080df07e549088421";

    public static void main(String[] args) throws UnsupportedEncodingException {
        org.springframework.web.client.RestTemplate restTemplate = new RestTemplateBuilder().build();
        String redirectUri = "http://192.168.0.177:8080/meituan/waimai/callback/code";
        String url = "https://openapi.waimai.meituan.com/oauth/authorize?app_id=" + APP_ID +
                "&redirect_uri=" + URLEncoder.encode(redirectUri, "utf-8") +
                "&response_type=code&scope=&state=gzhennaxia";
        System.out.println(url);
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
    }
}
