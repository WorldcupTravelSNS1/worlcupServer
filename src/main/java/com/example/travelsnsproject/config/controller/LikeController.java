package com.example.travelsnsproject.config.controller;

import com.example.travelsnsproject.config.entity.LikeCount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/like")
public class LikeController {
    @PostMapping("/{boardid}/{memberid}")
    public LikeCount LikeSave(@PathVariable("memberid") Long memberId,
                              @PathVariable("boardid") Long boardId){
        // likeInsert => 중복해서 Like할 수 없게 예외처리 필요

        // Like테이블에 저장하고, board의 Like값 +1해야함
        return null;
    }

    @DeleteMapping("/{boardid}/{memberid}")
    public void deleteLike(@PathVariable("boardid") Long boardId,
                           @PathVariable("memberid") Long memberId){
        // Like테이블에서 삭제하고, board의 Like값 -1해야함

    }
}
