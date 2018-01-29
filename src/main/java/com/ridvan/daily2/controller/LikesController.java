package com.ridvan.daily2.controller;

import com.ridvan.daily2.model.Likes;
import com.ridvan.daily2.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesRepository likesRepository;

    @GetMapping("")
    public ResponseEntity<List<Likes>> getAllLikes() {
        List<Likes> likes = likesRepository.findAllLikes();
        return ResponseEntity.ok(likes);
    }

}
