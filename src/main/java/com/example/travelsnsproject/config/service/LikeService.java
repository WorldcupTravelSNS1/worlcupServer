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
            LikePlus(member,board);
        }
        else {
            LikeMinus(check);
        }
        return null;
    }

    public void LikePlus(Member member, Board board){
        LikeCount likeCount1=likeRepository.save(new LikeCount(null,board,member));
        Board board1=likeCount1.getBoard();
        board1.setLikeCount(board1.getLikeCount()+1);
//        boardService.saveBoard(board1);jpa는 자동 update
    }

    public void LikeMinus(LikeCount likeCount){
        Board board=likeCount.getBoard();
        board.setLikeCount(board.getLikeCount()-1);
        likeRepository.delete(likeCount);
    }



}
