package com.ridvan.daily2.repository;

import com.ridvan.daily2.model.Likes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikesRepository extends CrudRepository<Likes,Integer> {

    @Query("SELECT l from LIKES l")
    List<Likes> findAllLikes();

}
