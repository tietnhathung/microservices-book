package com.example.commonslibrary.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private UUID id;

    private UUID bookId;

    private Integer quantity;
}
