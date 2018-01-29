package com.ridvan.daily2.controller;

import com.ridvan.daily2.model.Entry;
import com.ridvan.daily2.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/entries")
public class RestController {

    @Autowired
    private EntryRepository entryRepository;

    @RequestMapping("")
    public ResponseEntity<List<Entry>> listAllEntries() {
        List<Entry> entries = entryRepository.findAllEntries();
        return ResponseEntity.ok(entries);
    }

    @PostMapping("")
    public ResponseEntity<Entry> createNewEntry(@RequestBody Entry entry) {
        Entry savedEntry = entryRepository.save(entry);
        return ResponseEntity.ok(savedEntry);
    }

    @PutMapping("")
    public ResponseEntity<Entry> updateNewEntry(@RequestBody Entry entry) {
        Entry savedEntry = entryRepository.save(entry);
        return ResponseEntity.ok(savedEntry);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> getEntryById(@PathVariable Integer id) {
        Entry entry = entryRepository.findEntryByById(id);
        return ResponseEntity.ok(entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entry> deleteEntryById(@PathVariable Integer id) {
        Entry entry = entryRepository.findEntryByById(id);
        entryRepository.delete(entry);
        return ResponseEntity.ok(entry);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Entry>> getSearch(@NotEmpty @RequestParam("keyword") String keyword) {

        List<Entry> entries = entryRepository.filterTitleByKeyword(keyword);
        return ResponseEntity.ok(entries);
    }
}
