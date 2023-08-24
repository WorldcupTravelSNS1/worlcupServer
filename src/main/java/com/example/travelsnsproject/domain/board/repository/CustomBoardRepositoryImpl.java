package com.example.travelsnsproject.domain.board.repository;

import com.example.travelsnsproject.config.entity.QBoard;
import com.example.travelsnsproject.config.entity.QBoardImage;
import com.example.travelsnsproject.config.entity.QMember;
import com.example.travelsnsproject.domain.board.request.GetBoardRequest;
import com.example.travelsnsproject.domain.board.response.BoardGetResponse;
import com.example.travelsnsproject.domain.board.response.QBoardGetResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
public class CustomBoardRepositoryImpl implements CustomBoardRepository{

    private QBoard qBoard = QBoard.board;
    private QMember qMember = QMember.member;
    private QBoardImage qBoardImage = QBoardImage.boardImage;

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<BoardGetResponse> getBoard(GetBoardRequest getBoardRequest) {
        JPAQuery<BoardGetResponse> query = queryFactory
                .select(Projections.constructor(BoardGetResponse.class,
                        qBoard.id,
                        qBoard.title,
                        qBoard.content,
                        qBoard.createAt,
                        qBoard.tema,
                        qBoard.likeCount,
                        qMember.id,
                        qMember.name,
                        JPAExpressions.select(Expressions.stringTemplate("JSON_ARRAYAGG({0})", qBoardImage.imageUrl))
                                .from(qBoardImage)
                                .where(qBoardImage.board.id.eq(qBoard.id)), // 이미지 URL들을 JSON 배열로 변환하여 가져오는 서브쿼리
                        qBoardImage.id != null ?
                                JPAExpressions.select(Expressions.stringTemplate("JSON_ARRAYAGG({0})", qBoardImage.id))
                                        .from(qBoardImage)
                                        .where(qBoardImage.board.id.eq(qBoard.id))
                                : null
                ))
                .from(qBoard)
                .leftJoin(qBoard.member,qMember)
                .leftJoin(qBoard.boardImages, qBoardImage)
                .where(titleContains(getBoardRequest.getTitle()),
                        contentContains(getBoardRequest.getContent()),
                        qBoard.tema.eq(getBoardRequest.getTema()),
                        qBoard.isAvailable.eq(Boolean.TRUE)
                        )
                .offset(getBoardRequest.getPageNumber())
                .groupBy(qBoard.id)
                .limit(getBoardRequest.getPageSize());
        List<BoardGetResponse> content = query.fetch();
        return new PageImpl<BoardGetResponse>(content);
    }

    @Override
    public Page<BoardGetResponse> getBlockedBoard(GetBoardRequest getBoardRequest) {
        JPAQuery<BoardGetResponse> query = queryFactory
                .select(Projections.constructor(BoardGetResponse.class,
                        qBoard.id,
                        qBoard.title,
                        qBoard.content,
                        qBoard.createAt,
                        qBoard.tema,
                        qBoard.likeCount,
                        qMember.id,
                        qMember.name,
                        JPAExpressions.select(Expressions.stringTemplate("JSON_ARRAYAGG({0})", qBoardImage.imageUrl))
                                .from(qBoardImage)
                                .where(qBoardImage.board.id.eq(qBoard.id)), // 이미지 URL들을 JSON 배열로 변환하여 가져오는 서브쿼리
                        qBoardImage.id != null ?
                                JPAExpressions.select(Expressions.stringTemplate("JSON_ARRAYAGG({0})", qBoardImage.id))
                                        .from(qBoardImage)
                                        .where(qBoardImage.board.id.eq(qBoard.id))
                                : null
                ))
                .from(qBoard)
                .leftJoin(qBoard.member,qMember)
                .leftJoin(qBoard.boardImages, qBoardImage)
                .where(titleContains(getBoardRequest.getTitle()),
                        contentContains(getBoardRequest.getContent()),
                        qBoard.isAvailable.eq(Boolean.FALSE),
                        qBoard.member.id.eq(getBoardRequest.getMemberId())
                )
                .offset(getBoardRequest.getPageNumber())
                .groupBy(qBoard.id)
                .limit(getBoardRequest.getPageSize());
        List<BoardGetResponse> content = query.fetch();
        return new PageImpl<BoardGetResponse>(content);
    }

    @Override
    public Page<BoardGetResponse> getBoardById(Long boardId) {
        JPAQuery<BoardGetResponse> query = queryFactory
                .select(Projections.constructor(BoardGetResponse.class,
                        qBoard.id,
                        qBoard.title,
                        qBoard.content,
                        qBoard.createAt,
                        qBoard.tema,
                        qBoard.likeCount,
                        qMember.id,
                        qMember.name,
                        JPAExpressions.select(Expressions.stringTemplate("JSON_ARRAYAGG({0})", qBoardImage.imageUrl))
                                .from(qBoardImage)
                                .where(qBoardImage.board.id.eq(qBoard.id)), // 이미지 URL들을 JSON 배열로 변환하여 가져오는 서브쿼리
                        qBoardImage.id != null ?
                                JPAExpressions.select(Expressions.stringTemplate("JSON_ARRAYAGG({0})", qBoardImage.id))
                                        .from(qBoardImage)
                                        .where(qBoardImage.board.id.eq(qBoard.id))
                                : null
                ))
                .from(qBoard)
                .leftJoin(qBoard.member,qMember)
                .leftJoin(qBoard.boardImages, qBoardImage)
                .where(qBoard.id.eq(boardId))
                .offset(0)
                .groupBy(qBoard.id)
                .limit(1);
        List<BoardGetResponse> content = query.fetch();
        return new PageImpl<BoardGetResponse>(content);
    }


    private BooleanExpression titleContains(String title){
        return title == null?
                null
                :qBoard.title.like("%"+title+"%");
    }

    private BooleanExpression contentContains(String content){
        return content == null?
                null
                :qBoard.content.like("%"+content+"%");
    }



}



