package com.ridvan.daily2.repository;

import com.ridvan.daily2.model.Likes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LikesRepository extends CrudRepository<Likes,Integer> {



}
