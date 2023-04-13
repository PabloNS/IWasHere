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

        //to generate a note close to me
        randomizeLocationNote(noteDB);

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
                .filter(p -> positionDTO.getLatitude() <= p.getLatitude() + 0.03d/111d
                        && positionDTO.getLatitude() >= p.getLatitude() - 0.03d/111d
                        && positionDTO.getLongitude() <= p.getLongitude() + 0.03d/55d
                        && positionDTO.getLongitude() <= p.getLongitude() + 0.03d/55d)
                .toList()).build();
    }

    private void randomizeLocationNote(Note noteDB) {
        double random = Math.random();
        if(random<=0.5) {
            noteDB.setLatitude(noteDB.getLatitude() - (Math.random() <0.5 ? 0.01d : 0.02d) / 111d);
        } else {
            noteDB.setLatitude(noteDB.getLatitude() + (Math.random() <0.5 ? 0.01d : 0.02d) / 111d);
        }
        random = Math.random();
        if(random<=0.5) {
            noteDB.setLongitude(noteDB.getLongitude() - (Math.random() <0.5 ? 0.01d : 0.02d) / 55d);
        } else {
            noteDB.setLongitude(noteDB.getLongitude() + (Math.random() <0.5 ? 0.01d : 0.02d) / 55d);
        }
    }
}
