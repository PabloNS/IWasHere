package com.example.IWasHere.mapper;

import com.example.IWasHere.data.entity.Note;
import com.example.IWasHere.dto.NoteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteDTO noteToNoteDto(Note note);

    Note noteDTOToNote(NoteDTO note);

    List<NoteDTO> map(List<Note> notes);
}
