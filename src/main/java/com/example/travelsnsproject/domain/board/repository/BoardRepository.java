package com.example.travelsnsproject.domain.board.repository;

import com.example.travelsnsproject.config.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, CustomBoardRepository {

}
