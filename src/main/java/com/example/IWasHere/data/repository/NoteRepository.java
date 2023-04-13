package com.example.IWasHere.data.repository;

import com.example.IWasHere.data.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
