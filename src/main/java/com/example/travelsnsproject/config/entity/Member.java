package com.example.travelsnsproject.config.entity;

import com.example.travelsnsproject.config.entity.LikeCount;
import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.Comment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailId;
    private String name;
    @OneToMany(mappedBy = "member")
    private List<Board> boards;
    @OneToMany(mappedBy = "member")
    private List<Comment> comments;

    @OneToMany(mappedBy = "member")
    private List<LikeCount> likes;

    public Member(Map userInfo){
        this.emailId = (String)userInfo.get("id");
        this.name = (String) userInfo.get("name");
        this.boards = null;
    }


}
