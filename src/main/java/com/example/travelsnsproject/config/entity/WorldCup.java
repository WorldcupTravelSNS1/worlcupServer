package com.example.travelsnsproject.config.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class WorldCup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String worldcupName;
    private Long likeCount;
    @OneToMany(mappedBy = "worldcup")
    private List<WorldCupData> worldcupData;
}
