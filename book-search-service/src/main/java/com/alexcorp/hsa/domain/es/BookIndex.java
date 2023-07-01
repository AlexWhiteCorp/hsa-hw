package com.alexcorp.hsa.domain.es;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

@Getter
@Setter
@Document(indexName = "books")
public class BookIndex {

    @Id
    private UUID id;

    private String title;

    private String author;

}
