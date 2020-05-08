package com.gzhennaxia.ebook.controller;

import com.gzhennaxia.common.utils.Result;
import com.gzhennaxia.ebook.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bo li
 * @date 2020-05-08 12:14
 */
@RestController
@RequestMapping("/quote")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/sync/{assetId}")
    public Result sync(@PathVariable String assetId) {
        quoteService.sync(assetId);
        return Result.success();
    }
}
