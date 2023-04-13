package com.example.IWasHere.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDTO {

    private Double latitude;

    private Double longitude;

    private String comment;

    private LocalDateTime creationDate;
}
