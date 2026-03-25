package com.journalApp.controller;

import com.journalApp.entity.JournalEntry;
import com.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAllJournalEntries();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry)
    {
       return journalEntryService.saveEntry(journalEntry)
               ;
    }

    @GetMapping("/id/{id}")
    public JournalEntry getEntryById(@PathVariable ObjectId id)
    {
        return journalEntryService.findById(id).orElse(null);
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId id)
    {
        journalEntryService.deleteById(id);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry)
    {
        JournalEntry oldEntry = journalEntryService.findById(id).orElse(null);

        if(null != oldEntry){

            oldEntry.setTitle( newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldEntry.getTitle() );
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : oldEntry.getContent());
        }

        return journalEntryService.saveEntry(oldEntry);
    }


}
