package com.example.bidirectional.repository;

import com.example.bidirectional.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {


}
