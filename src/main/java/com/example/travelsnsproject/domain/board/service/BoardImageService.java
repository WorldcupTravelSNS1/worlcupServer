package com.example.travelsnsproject.domain.board.service;


import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.BoardImage;
import com.example.travelsnsproject.domain.board.repository.BoardImageRepository;
import com.example.travelsnsproject.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardImageService {
    private final BoardImageRepository boardImageRepository;

    public List<Long> saveBoardImageByList(List<String> imageUrls, Board board){
        List<Long> returnBoardImageId = new ArrayList<>();
        for(int i=0; i<imageUrls.size();i++){
            BoardImage boardImage = boardImageRepository.save(new BoardImage(null,imageUrls.get(i),board));
            returnBoardImageId.add(boardImage.getId());
        }
        return returnBoardImageId;
    }

    public void deleteByIds(List<Long> imageIds){
        for(int i=0; i<imageIds.size(); i++){
            boardImageRepository.delete(new BoardImage(imageIds.get(i),null,null));
        }
    }

}
