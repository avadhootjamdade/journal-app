package com.journalApp.service;

import com.journalApp.entity.JournalEntry;
import com.journalApp.repository.JournalEntryRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepoitory journalEntryRepoitory;


    public void saveEntry(JournalEntry journalEntry)
    {
        journalEntryRepoitory.save(journalEntry);
    }

    public List<JournalEntry> getAllJournalEntries()
    {
        return journalEntryRepoitory.findAll();
    }


}
