package com.example.travelsnsproject.domain.board.service;

import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.domain.board.repository.BoardRepository;
import com.example.travelsnsproject.domain.board.request.GetBoardRequest;
import com.example.travelsnsproject.domain.board.request.SaveBoardRequest;
import com.example.travelsnsproject.domain.board.request.UpdateBoardRequest;
import com.example.travelsnsproject.domain.board.response.BoardGetResponse;
import com.example.travelsnsproject.domain.board.response.BoardSaveResponse;
import com.example.travelsnsproject.domain.board.response.UpdateBoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardImageService boardImageService;

    public Page<BoardGetResponse> getBoard(GetBoardRequest getBoardRequest){
        return boardRepository.getBoard(getBoardRequest);
    }

    public BoardSaveResponse saveBoard(SaveBoardRequest saveBoardRequest){
        Board thisBoard = boardRepository.save(new Board(saveBoardRequest));

        //image save하고, boardImageId 리스트 BoardSaveResponse에 set해서 반환함. =>image url을 저장해서 생성된 boardImageId반환
        List<Long> boardImageId = null;
        if(saveBoardRequest.getImageUrl()!=null){
            boardImageId = boardImageService.saveBoardImageByList(saveBoardRequest.getImageUrl(), thisBoard);
        }
        //여기서 set해줘야함
        BoardSaveResponse boardSaveResponse = new BoardSaveResponse(thisBoard);
        //여기서 set해줘야함
        if(saveBoardRequest.getImageUrl()!=null) {
            boardSaveResponse.setBoardImageId(boardImageId);
        }
        return boardSaveResponse;
    }

    public void saveBoard(Board board){
        Board thisBoard = boardRepository.save(board);
    }

    public void deleteBoard(Long boardId){
        boardRepository.deleteById(boardId);
    }

    //이거 로직 개판임. 쿼리 지옥임. 쿼리 개선 필요함(bulk쿼리 해야할 것 같음)
    public UpdateBoardResponse updateBoard(Long boardId, UpdateBoardRequest updateBoardRequest){
        Board thisBoard = boardRepository.findById(boardId).get();
        thisBoard.setContent(updateBoardRequest.getContent());
        thisBoard.setTitle(updateBoardRequest.getTitle());
        //프론트에서 이미지가 바뀐 경우에 서버에 BoardImageId보내서 수정하고, 수정한 boardImageId 반환함
        UpdateBoardResponse updateBoardResponse = new UpdateBoardResponse();
        if (updateBoardRequest.getBoardImageId()!=null){
            boardImageService.deleteByIds(updateBoardRequest.getBoardImageId());
            List<Long> boardImageId = boardImageService.saveBoardImageByList(updateBoardRequest.getImageUrl(), thisBoard);
            updateBoardResponse.setBoardImageId(boardImageId);
        }
        return updateBoardResponse;
    }

}
