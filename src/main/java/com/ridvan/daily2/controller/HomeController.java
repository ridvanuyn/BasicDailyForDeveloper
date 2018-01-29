package com.ridvan.daily2.controller;

import com.ridvan.daily2.model.Entry;
import com.ridvan.daily2.repository.EntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/blog")
public class HomeController {

    @Autowired
    EntryRepository entryRepository;

    @RequestMapping(value = "entries", method = RequestMethod.GET)
    public String getEntryForm(Model model) {
        Iterable<Entry> entries = entryRepository.findAll();
        model.addAttribute("entries", entries);
        return "entries/listEntries";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("entry", new Entry());
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getNewEnry(Model model) {
        // model.addAttribute("entry",new Entry());
        return "entries/newEntry";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String postEntryForm(@Valid @ModelAttribute Entry entry, BindingResult bindingResult) {
        //System.out.println(entry);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().get(0).toString());
            return "index";
        } else {
            entryRepository.save(entry);
            return "redirect:/blog";
        }

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showEntries(@PathVariable Integer id, Model model) {
        Optional<Entry> entryOptional =  entryRepository.findById(id);
            if(!entryOptional.isPresent()){
            log.warn("enrty {} hatalı", id);
            model.addAttribute("errorCase","Aradığınız "+id+" id numaralı yazı bulunamadı");
            return "error";
        } else {
            model.addAttribute("entry", entryOptional.get());
        }
        return "entries/showEntry";
    }

    @RequestMapping(value = "/{id}/update" ,method = RequestMethod.GET)
    public String updateEntry(@PathVariable("id")Integer id, Model model){
        Optional<Entry> entryOptional =  entryRepository.findById(id);
        if(!entryOptional.isPresent()){
            log.warn("enrty {} hatalı", id);
            model.addAttribute("errorCase","Can not find a post id = "+id);
            return "error";
        } else {
            model.addAttribute("entry", entryOptional.get());
        }
        return "entries/updateEntry";
    }


    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateEntry(@Valid @ModelAttribute Entry entry, BindingResult bindingResult) {
        //System.out.println(entry);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().get(0).toString());
            return "entries/updateEntry";
        } else {
            entryRepository.save(entry);
            return "redirect:/blog";
        }
    }


    @RequestMapping(value = "/{id}/delete" ,method = RequestMethod.POST)
    public String deleteEntry(@PathVariable("id")Integer id){
        Optional<Entry> entryOptional =  entryRepository.findById(id);
        if(!entryOptional.isPresent()){
            log.warn("enrty {} hatalı", id);
            return "error";
        } else {
            entryRepository.delete(entryOptional.get());
            return "redirect:/blog/entries/";
        }
    }

}
