package com.alexcorp.hsa.mapper;

import com.alexcorp.hsa.domain.es.BookIndex;
import com.alexcorp.hsa.domain.mongo.BookEntity;
import com.alexcorp.hsa.model.BookPayload;
import com.alexcorp.hsa.model.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    BookIndex mapIndex(BookPayload payload);

    @Mapping(target = "id", ignore = true)
    BookEntity mapEntity(BookPayload payload);

    default List<BookResponse> mapResponse(List<BookEntity> entities) {
        return entities
                .stream()
                .map(this::mapResponse)
                .toList();
    }

    BookResponse mapResponse(BookEntity entity);

}
