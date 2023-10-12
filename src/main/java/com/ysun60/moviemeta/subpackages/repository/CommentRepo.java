package com.ysun60.moviemeta.subpackages.repository;

import com.ysun60.moviemeta.subpackages.entity.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepo extends MongoRepository<Comment, ObjectId>
{

}
