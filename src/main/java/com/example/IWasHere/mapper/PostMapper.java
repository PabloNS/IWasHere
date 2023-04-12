package com.example.IWasHere.mapper;

import com.example.IWasHere.data.entity.Post;
import com.example.IWasHere.dto.PostDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDTO postToPostDto(Post post);

    Post postDTOToPost(PostDTO post);

    List<PostDTO> map(List<Post> posts);
}
