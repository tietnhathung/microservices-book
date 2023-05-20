package com.example.commonslibrary.model;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private UUID id;

    private String name;

    private String author;
}
