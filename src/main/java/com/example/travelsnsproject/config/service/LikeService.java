package com.example.travelsnsproject.config.service;

import com.example.travelsnsproject.config.Dto.LikeDto;
import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.LikeCount;
import com.example.travelsnsproject.config.entity.Member;
import com.example.travelsnsproject.config.repository.LikeRepository;
import com.example.travelsnsproject.domain.board.service.BoardService;
import com.example.travelsnsproject.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {
    private final LikeRepository likeRepository;
    private final BoardService boardService;

    public LikeDto saveOrDeleteLike(Long memberId, Long boardId){
        Member member = Member.builder().id(memberId).build();
        Board board = Board.builder().id(boardId).build();
        Optional<LikeCount> likeCount= likeRepository.findByMemberIdAndBodarId(member,board);
        LikeCount check = likeCount.orElse(null);
        if (check == null){
            LikePlus(check);
        }
        else {
            likeRepository.delete(check);
        }
        return null;
    }

    public void LikePlus(LikeCount likeCount){
        LikeCount likeCount1=likeRepository.save(likeCount);
        Board board=likeCount1.getBoard();
        board.setLikeCount(board.getLikeCount()+1);
        boardService.saveBoard(board);
    }

    public void LikeMinus(LikeCount likeCount){
        Board board=likeCount.getBoard();
        board.setLikeCount(board.getLikeCount()-1);
        likeRepository.delete(likeCount);
        boardService.saveBoard(board);
    }



}
