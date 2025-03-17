package com.example.IWasHere.controller;

import com.example.IWasHere.dto.PositionDTO;
import com.example.IWasHere.dto.NoteDTO;
import com.example.IWasHere.dto.NotesDTO;
import com.example.IWasHere.service.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notes")
@AllArgsConstructor
@CrossOrigin("*")
@Slf4j
public class NoteController {

    private NoteService noteService;

    @PostMapping
    public void createNote(@RequestBody NoteDTO note, HttpServletRequest request) {
        log.info("CreateNote invoked! From "  + request.getHeader("x-forwarded-for") + " Note: " + note);
        noteService.createNote(note, request);
    }

    @GetMapping
    public NotesDTO getAllNotes(HttpServletRequest request) {
        log.info("GetAllNotes invoked! " + "From " + request.getHeader("x-forwarded-for"));
        return noteService.getAllNotes();
    }

    @PostMapping("nearMe")
    public NotesDTO getNearMeNotes(@RequestBody PositionDTO positionDTO, HttpServletRequest request) {
        log.info("GetNearMeNotes invoked! " + "From " + request.getHeader("x-forwarded-for"));
        return noteService.getNearMeNotes(positionDTO);
    }
}
