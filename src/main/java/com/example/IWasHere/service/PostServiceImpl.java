package com.example.IWasHere.service;

import com.example.IWasHere.data.entity.Post;
import com.example.IWasHere.data.repository.PostRepository;
import com.example.IWasHere.dto.PositionDTO;
import com.example.IWasHere.dto.PostDTO;
import com.example.IWasHere.dto.PostsDTO;
import com.example.IWasHere.mapper.PostMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostMapper postMapper;

    private PostRepository postRepository;

    @Override
    public void createPost(PostDTO post, HttpServletRequest request) {
        Post postDB = postMapper.postDTOToPost(post);
        postDB.setCreationDate(LocalDateTime.now());
        postDB.setIp(request.getRemoteAddr());
        postRepository.save(postDB);
    }

    @Override
    public PostsDTO getAllPosts() {
        return PostsDTO.builder().data(postMapper.map(postRepository.findAll())).build();
    }

    @Override
    public PostsDTO getNearMePosts(PositionDTO positionDTO) {
        return PostsDTO.builder().data(getAllPosts().getData().stream()
                .filter(p -> positionDTO.getLatitude() <= p.getLatitude() + 1d/111d
                        && positionDTO.getLatitude() >= p.getLatitude() - 1d/111d
                        && positionDTO.getLongitude() <= p.getLongitude() + 1d/86d
                        && positionDTO.getLongitude() <= p.getLongitude() + 1d/86d)
                .toList()).build();
    }
}
