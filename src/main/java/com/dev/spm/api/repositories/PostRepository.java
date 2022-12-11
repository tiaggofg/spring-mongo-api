package com.dev.spm.api.repositories;

import com.dev.spm.api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ body: { $regex: ?0 } }")
    List<Post> findByBody(String text);

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0 } }, { 'body': { $regex: ?0 } }, { 'comments.text': { $regex: ?0 } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

    List<Post> findByTitleContaining(String text);

}
