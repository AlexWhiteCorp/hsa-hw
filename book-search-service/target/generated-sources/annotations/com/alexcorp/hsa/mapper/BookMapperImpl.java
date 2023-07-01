package com.alexcorp.hsa.mapper;

import com.alexcorp.hsa.domain.es.BookIndex;
import com.alexcorp.hsa.domain.mongo.BookEntity;
import com.alexcorp.hsa.model.BookPayload;
import com.alexcorp.hsa.model.BookResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-01T15:59:13+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookIndex mapIndex(BookPayload payload) {
        if ( payload == null ) {
            return null;
        }

        BookIndex bookIndex = new BookIndex();

        bookIndex.setTitle( payload.getTitle() );
        bookIndex.setAuthor( payload.getAuthor() );

        return bookIndex;
    }

    @Override
    public BookEntity mapEntity(BookPayload payload) {
        if ( payload == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle( payload.getTitle() );
        bookEntity.setAuthor( payload.getAuthor() );

        return bookEntity;
    }

    @Override
    public BookResponse mapResponse(BookEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setId( entity.getId() );
        bookResponse.setTitle( entity.getTitle() );
        bookResponse.setAuthor( entity.getAuthor() );

        return bookResponse;
    }
}
