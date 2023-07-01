package com.alexcorp.hsa.domain.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "books")
public class BookEntity {

    @Id
    private UUID id;

    private String title;

    private String author;

}
