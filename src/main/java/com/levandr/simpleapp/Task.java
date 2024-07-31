package com.levandr.simpleapp;

import lombok.Data;

@Data
public class Task {
    private Long id;
    private String title;
    private String description;
    private String priority;
}
