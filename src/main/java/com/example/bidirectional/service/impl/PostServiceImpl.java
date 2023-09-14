package com.example.bidirectional.service.impl;

import com.example.bidirectional.dao.BaseDaoImpl;
import com.example.bidirectional.entity.Post;
import com.example.bidirectional.entity.Tag;
import com.example.bidirectional.repository.PostRepository;
import com.example.bidirectional.repository.PostRepositoryImpl;
import com.example.bidirectional.repository.TagRepository;
import com.example.bidirectional.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl extends BaseDaoImpl<Post, Long> implements PostService {

    private PostRepository postRepository;
    private TagRepository tagRepository;
    private PostRepositoryImpl repository;

    public PostServiceImpl(PostRepository postRepository,
                           TagRepository tagRepository,
                           PostRepositoryImpl repository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
        this.repository = repository;
    }

    @Override
    public Post createPost(Post post) {
//        Optional<Tag> activeTag = tagRepository.findById(1L);
//        Optional<Tag> startTag = tagRepository.findById(2L);
        Tag activeTag = repository.getTag(1L);
        Tag startTag = repository.getTag(2L);

        Post obj = new Post(151L, post.getTitle());
        obj.addTag(activeTag);
        obj.addTag(startTag);

        Post _post = super.create(obj);
//        Post _post = postRepository.save(obj);
        return _post;
    }

    @Override
    protected Class<Post> getEntityClass() {
        return null;
    }
}
