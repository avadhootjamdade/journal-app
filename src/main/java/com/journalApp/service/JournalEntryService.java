package com.journalApp.service;

import com.journalApp.entity.JournalEntry;
import com.journalApp.repository.JournalEntryRepoitory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepoitory journalEntryRepoitory;


    public JournalEntry saveEntry(JournalEntry journalEntry)
    {
        journalEntry.setDate(LocalDateTime.now());
        return journalEntryRepoitory.save(journalEntry);
    }

    public List<JournalEntry> getAllJournalEntries()
    {
        return journalEntryRepoitory.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id)
    {
        return journalEntryRepoitory.findById(id);
    }

    public void deleteById(ObjectId id)
    {
        journalEntryRepoitory.deleteById(id);
    }

}
