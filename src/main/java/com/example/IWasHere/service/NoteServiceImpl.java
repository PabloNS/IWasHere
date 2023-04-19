package com.example.IWasHere.service;

import com.example.IWasHere.data.entity.Note;
import com.example.IWasHere.data.entity.User;
import com.example.IWasHere.data.repository.NoteRepository;
import com.example.IWasHere.data.repository.UserRepository;
import com.example.IWasHere.dto.PositionDTO;
import com.example.IWasHere.dto.NoteDTO;
import com.example.IWasHere.dto.NotesDTO;
import com.example.IWasHere.mapper.NoteMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class NoteServiceImpl implements NoteService {

    private NoteMapper noteMapper;

    private NoteRepository noteRepository;

    private UserRepository userRepository;

    @Override
    public void createNote(NoteDTO note, HttpServletRequest request) {
        Note noteDB = noteMapper.noteDTOToNote(note);

        //to generate a note close to me
        //randomizeLocationNote(noteDB);

        //User user = new User();
        //user.setNickname(note.getUserNickname());
        //userRepository.save(user);
        //noteDB.setUser(user);

        noteDB.setCreationDate(LocalDateTime.now());
        noteDB.setIp(request.getRemoteAddr());
        noteRepository.save(noteDB);
    }

    @Override
    public NotesDTO getAllNotes() {
        List<NoteDTO> notes = noteMapper.map(noteRepository.findAll());
        log.info("Notes found: " + notes);
        return NotesDTO.builder().data(notes).build();
    }

    @Override
    public NotesDTO getNearMeNotes(PositionDTO positionDTO) {
        /*return NotesDTO.builder().data(getAllNotes().getData().stream()
                .filter(p -> positionDTO.getLatitude() <= p.getLatitude() + 0.03d/111d
                        && positionDTO.getLatitude() >= p.getLatitude() - 0.03d/111d
                        && positionDTO.getLongitude() <= p.getLongitude() + 0.03d/55d
                        && positionDTO.getLongitude() <= p.getLongitude() + 0.03d/55d)
                .toList()).build();*/
        return NotesDTO.builder().data(getAllNotes().getData()).build();
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
