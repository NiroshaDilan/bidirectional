package com.example.bidirectional.repository;

import com.example.bidirectional.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


}
