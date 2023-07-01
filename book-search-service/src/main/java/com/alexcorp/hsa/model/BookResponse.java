package com.alexcorp.hsa.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookResponse {

    private UUID id;
    private String title;
    private String author;

}
