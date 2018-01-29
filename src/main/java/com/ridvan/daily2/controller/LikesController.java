package com.ridvan.daily2.controller;

import com.ridvan.daily2.model.Entry;
import com.ridvan.daily2.model.Likes;
import com.ridvan.daily2.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesRepository likesRepository;

    @RequestMapping("")
    public ResponseEntity<List<Likes>> getAllLikes() {

        final Iterable<Likes> likes = likesRepository.findAll();
        return ResponseEntity.ok((List<Likes>) likes);
    }



    @PostMapping("")
    public ResponseEntity<Likes> createNewEntry( @RequestBody Likes likes) {
        Likes savedLikes = likesRepository.save(likes);
        return ResponseEntity.ok(savedLikes);
    }

}
