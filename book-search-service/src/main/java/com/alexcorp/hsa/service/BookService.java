package com.alexcorp.hsa.service;

import com.alexcorp.hsa.domain.es.BookIndex;
import com.alexcorp.hsa.mapper.BookMapper;
import com.alexcorp.hsa.model.BookPayload;
import com.alexcorp.hsa.model.BookResponse;
import com.alexcorp.hsa.model.BooksPage;
import com.alexcorp.hsa.repository.es.BookESRepository;
import com.alexcorp.hsa.repository.mongo.BookMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookESRepository esRepository;
    private final BookMongoRepository mongoRepository;
    private final BookMapper mapper;

    @Transactional(readOnly = true)
    public BooksPage search(String query, int pageNumber, int pageSize) {
        var booksIndex = esRepository.search(query, PageRequest.of(pageNumber - 1, pageSize));

        var booksId = booksIndex.getContent()
                .stream()
                .map(BookIndex::getId)
                .toList();

        var booksEntity = mongoRepository.findAllByIdIn(booksId);

        return new BooksPage(
                mapper.mapResponse(booksEntity),
                pageNumber,
                booksIndex.getTotalElements()
        );
    }

    @Transactional
    public BookResponse createBook(BookPayload payload) {
        var index = mapper.mapIndex(payload);
        index.setId(UUID.randomUUID());
        esRepository.save(index);

        var entity = mapper.mapEntity(payload);
        entity.setId(index.getId());
        mongoRepository.save(entity);

        return mapper.mapResponse(entity);
    }

    @Transactional
    public void deleteBook(UUID id) {
        mongoRepository.deleteById(id);

        esRepository.deleteById(id);
    }
}
