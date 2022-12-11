package com.dev.spm.api.repositories;

import com.dev.spm.api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ body: { $regex: ?0 } }")
    List<Post> findByBody(String search);
    List<Post> findByTitleContaining(String text);

}
