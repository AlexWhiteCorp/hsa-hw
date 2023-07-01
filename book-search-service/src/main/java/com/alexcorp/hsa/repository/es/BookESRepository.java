package com.alexcorp.hsa.repository.es;

import com.alexcorp.hsa.domain.es.BookIndex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookESRepository extends ElasticsearchRepository<BookIndex, UUID> {

    @Query("""
            {
               "query_string": {
                  "query": "?0"
               }
            }
              """)
    Page<BookIndex> search(String query, Pageable pageable);

}
