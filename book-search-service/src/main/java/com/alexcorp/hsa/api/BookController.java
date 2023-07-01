package com.alexcorp.hsa.api;

import com.alexcorp.hsa.model.BookPayload;
import com.alexcorp.hsa.model.BookResponse;
import com.alexcorp.hsa.model.BooksPage;
import com.alexcorp.hsa.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("search")
    public ResponseEntity<BooksPage> search(@RequestParam String query,
                                            @RequestParam(defaultValue = "1") Integer pageNumber,
                                            @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseEntity
                .ok(bookService.search(query, pageNumber, pageSize));
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookPayload payload) {
        return ResponseEntity
                .ok(bookService.createBook(payload));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity
                .accepted()
                .build();
    }

}
