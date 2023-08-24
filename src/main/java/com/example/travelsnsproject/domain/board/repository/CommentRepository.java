package com.example.travelsnsproject.domain.board.repository;

import com.example.travelsnsproject.config.entity.Comment;
import com.example.travelsnsproject.domain.board.response.CommentGetResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("select c " +
            "from Comment c " +
            "where c.board.id = :boardId")
    List<Comment> commentGetByBoardId(@Param("boardId") Long boardId);
}
