package com.example.travelsnsproject.config.controller;

import com.example.travelsnsproject.config.entity.LikeCount;
import com.example.travelsnsproject.config.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/like")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LikeController {
    private LikeService likeService;

    @PostMapping("/{boardid}/{memberid}")
    public void LikeSaveOrDelete(@PathVariable("memberid") Long memberId,
                              @PathVariable("boardid") Long boardId){
        likeService.saveOrDeleteLike(memberId, boardId);
    }

}
