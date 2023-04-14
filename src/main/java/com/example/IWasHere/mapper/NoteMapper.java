package com.example.IWasHere.mapper;

import com.example.IWasHere.data.entity.Note;
import com.example.IWasHere.dto.NoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    //@Mapping(target = "userNickname", source = "note.user.nickname")
    NoteDTO noteToNoteDto(Note note);

    Note noteDTOToNote(NoteDTO note);

    List<NoteDTO> map(List<Note> notes);
}
