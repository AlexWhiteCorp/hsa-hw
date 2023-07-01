package com.alexcorp.hsa.repository.mongo;

import com.alexcorp.hsa.domain.mongo.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookMongoRepository extends MongoRepository<BookEntity, UUID> {

    List<BookEntity> findAllByIdIn(List<UUID> ids);

}
