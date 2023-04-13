package com.example.IWasHere.service;

import com.example.IWasHere.data.entity.Note;
import com.example.IWasHere.data.repository.NoteRepository;
import com.example.IWasHere.dto.PositionDTO;
import com.example.IWasHere.dto.NoteDTO;
import com.example.IWasHere.dto.NotesDTO;
import com.example.IWasHere.mapper.NoteMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private NoteMapper noteMapper;

    private NoteRepository noteRepository;

    @Override
    public void createNote(NoteDTO note, HttpServletRequest request) {
        Note noteDB = noteMapper.noteDTOToNote(note);
        noteDB.setCreationDate(LocalDateTime.now());
        noteDB.setIp(request.getRemoteAddr());
        noteRepository.save(noteDB);
    }

    @Override
    public NotesDTO getAllNotes() {
        return NotesDTO.builder().data(noteMapper.map(noteRepository.findAll())).build();
    }

    @Override
    public NotesDTO getNearMeNotes(PositionDTO positionDTO) {
        return NotesDTO.builder().data(getAllNotes().getData().stream()
                .filter(p -> positionDTO.getLatitude() <= p.getLatitude() + 1d/111d
                        && positionDTO.getLatitude() >= p.getLatitude() - 1d/111d
                        && positionDTO.getLongitude() <= p.getLongitude() + 1d/86d
                        && positionDTO.getLongitude() <= p.getLongitude() + 1d/86d)
                .toList()).build();
    }
}
