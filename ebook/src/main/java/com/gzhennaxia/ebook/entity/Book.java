package com.gzhennaxia.ebook.entity;

import lombok.Data;

/**
 * @author bo li
 * @date 2020-04-28 09:22
 */
@Data
public class Book {

    private Integer id;

    private String assetId;

    private String title;

    private String author;

    private String fileLink;

}
