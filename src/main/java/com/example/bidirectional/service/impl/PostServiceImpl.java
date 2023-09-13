package com.example.bidirectional.service.impl;

import com.example.bidirectional.entity.Post;
import com.example.bidirectional.entity.Tag;
import com.example.bidirectional.repository.PostRepository;
import com.example.bidirectional.repository.TagRepository;
import com.example.bidirectional.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private TagRepository tagRepository;

    public PostServiceImpl(PostRepository postRepository,
                           TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public Post createPost(Post post) {
        Optional<Tag> tag = tagRepository.findById(2L);
        Post obj = new Post(post.getTitle());
        obj.addTag(tag.get());
        Post _post = postRepository.save(obj);
        return _post;
    }
}
