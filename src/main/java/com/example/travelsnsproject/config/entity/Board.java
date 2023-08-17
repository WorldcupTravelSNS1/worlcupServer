package com.example.travelsnsproject.config.entity;


import com.example.travelsnsproject.domain.board.request.SaveBoardRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private String tema;
    private Integer likeCount;


    @ManyToOne
    private Member member;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments;

    @OneToMany(mappedBy = "board")
    private List<LikeCount> likes;

    public Board(SaveBoardRequest saveBoardRequest){
        this.id = null;
        this.title = saveBoardRequest.getTitle();
        this.content = saveBoardRequest.getContent();
        this.createAt = LocalDateTime.now();
        this.tema = saveBoardRequest.getTema();
        this.likeCount = 0;
        this.member = Member.builder().id(saveBoardRequest.getMemberId()).build();
    }

}
