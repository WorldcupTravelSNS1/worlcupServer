package com.example.travelsnsproject.config.repository;

import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.LikeCount;
import com.example.travelsnsproject.config.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeCount,Long> {

    @Query("select l " +
            "from LikeCount l " +
            "where l.member =:member " +
            "and l.board =:board ")
    Optional<LikeCount> findByMemberIdAndBodarId(@Param("member")Member member, @Param("board")Board board);

}
