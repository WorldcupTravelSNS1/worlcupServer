package com.example.travelsnsproject.config.Dto;

import com.example.travelsnsproject.config.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;

    public MemberDto(Member member){
        this.id= member.getId();
        this.name = member.getName();
    }
}
