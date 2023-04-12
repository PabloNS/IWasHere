package com.example.IWasHere.data.repository;

import com.example.IWasHere.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
