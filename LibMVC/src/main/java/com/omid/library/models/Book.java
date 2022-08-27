package com.omid.library.models;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String title;
    private boolean status;
    private String author_name;
}
