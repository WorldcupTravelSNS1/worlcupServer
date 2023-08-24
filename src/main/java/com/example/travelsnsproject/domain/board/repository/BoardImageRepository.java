package com.example.travelsnsproject.domain.board.repository;

import com.example.travelsnsproject.config.entity.BoardImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardImageRepository extends JpaRepository<BoardImage,Long> {
    @Modifying
    @Query("delete from " +
            "BoardImage " +
            "where board.id=:boardId")
    void deleteBoardImageByBoardId(@Param("boardId") Long boardId);

}
