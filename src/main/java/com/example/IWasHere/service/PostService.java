package com.example.IWasHere.service;

import com.example.IWasHere.dto.PositionDTO;
import com.example.IWasHere.data.entity.Post;
import com.example.IWasHere.dto.PostDTO;
import com.example.IWasHere.dto.PostsDTO;

import java.util.List;

public interface PostService {

    void createPost(PostDTO post);

    PostsDTO getAllPosts();

    PostsDTO getNearMePosts(PositionDTO positionDTO);
}
