package com.example.travelsnsproject.config.controller;

import com.example.travelsnsproject.config.entity.LikeCount;
import com.example.travelsnsproject.config.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/like")
@RequiredArgsConstructor
public class LikeController {
    private LikeService likeService;

    @PostMapping("/{boardid}/{memberid}")
    public void LikeSaveOrDelete(@PathVariable("memberid") Long memberId,
                              @PathVariable("boardid") Long boardId){
        likeService.saveOrDeleteLike(memberId, boardId);
    }

}
