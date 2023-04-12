package com.example.IWasHere.service;

import com.example.IWasHere.dto.PositionDTO;
import com.example.IWasHere.dto.PostDTO;
import com.example.IWasHere.dto.PostsDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface PostService {

    void createPost(PostDTO post, HttpServletRequest request);

    PostsDTO getAllPosts();

    PostsDTO getNearMePosts(PositionDTO positionDTO);
}
