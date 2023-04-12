package com.example.IWasHere.controller;

import com.example.IWasHere.dto.PositionDTO;
import com.example.IWasHere.dto.PostDTO;
import com.example.IWasHere.dto.PostsDTO;
import com.example.IWasHere.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("posts")
@AllArgsConstructor
@CrossOrigin("*")
public class PostController {

    private PostService postService;

    @PostMapping
    public void createPost(@RequestBody PostDTO post, HttpServletRequest request) {
        postService.createPost(post, request);
    }

    @GetMapping
    public PostsDTO getAllPosts(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
        return postService.getAllPosts();
    }

    @PostMapping("nearMe")
    public PostsDTO getNearMePosts(@RequestBody PositionDTO positionDTO) {
        return postService.getNearMePosts(positionDTO);
    }
}
