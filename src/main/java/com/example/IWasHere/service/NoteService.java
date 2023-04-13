package com.example.IWasHere.service;

import com.example.IWasHere.dto.PositionDTO;
import com.example.IWasHere.dto.NoteDTO;
import com.example.IWasHere.dto.NotesDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface NoteService {

    void createNote(NoteDTO note, HttpServletRequest request);

    NotesDTO getAllNotes();

    NotesDTO getNearMeNotes(PositionDTO positionDTO);
}
