package com.example.travelsnsproject.domain.board.repository;

import com.example.travelsnsproject.config.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
