package com.journalApp.controller;

import com.journalApp.entity.JournalEntry;
import com.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAllJournalEntries();
    }

    @PostMapping
    public void createEntry(@RequestBody JournalEntry journalEntry)
    {
        journalEntryService.saveEntry(journalEntry);
    }

    @GetMapping("/id/{id}")
    public JournalEntry getEntryById(@PathVariable long id)
    {
        return null;
    }

    @DeleteMapping("/id/{id}")
    public JournalEntry deleteJournalEntryById(@PathVariable long id)
    {
        return null;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable long id, @RequestBody JournalEntry journalEntry)
    {
        return null;
    }

}
