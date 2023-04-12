package com.example.IWasHere.dto;

import com.example.IWasHere.data.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsDTO {

    private List<PostDTO> data;
}
