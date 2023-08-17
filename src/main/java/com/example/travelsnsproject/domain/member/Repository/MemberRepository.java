package com.example.travelsnsproject.domain.member.Repository;

import com.example.travelsnsproject.config.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query("select m FROM " +
            "Member m " +
            "where m.emailId = :emailId")
    Optional<Member>  findByEmailId(@Param("emailId") String emailId);
}
