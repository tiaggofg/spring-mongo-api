package com.dev.spm.api.repository;

import com.dev.spm.api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
