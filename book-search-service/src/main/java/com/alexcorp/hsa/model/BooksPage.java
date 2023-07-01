package com.alexcorp.hsa.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class BooksPage {

    private final List<BookResponse> books;
    private final int currPage;
    private final long totalResults;

}
