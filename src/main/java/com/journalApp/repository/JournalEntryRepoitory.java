package com.journalApp.repository;

import com.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepoitory extends MongoRepository<JournalEntry, String> {

}
