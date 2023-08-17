package com.example.travelsnsproject.domain.board.repository;

import com.example.travelsnsproject.domain.board.request.GetBoardRequest;
import com.example.travelsnsproject.domain.board.entity.QBoard;
import com.example.travelsnsproject.domain.board.response.BoardGetResponse;
import com.example.travelsnsproject.domain.board.response.QBoardGetResponse;
import com.example.travelsnsproject.domain.member.Entity.QMember;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class CustomBoardRepositoryImpl implements CustomBoardRepository{
    private JPAQueryFactory queryFactory;
    private QBoard qBoard = QBoard.board;
    private QMember qMember = QMember.member;
    public CustomBoardRepositoryImpl(EntityManager entityManager){
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Page<BoardGetResponse> getBoard(GetBoardRequest getBoardRequest) {
        JPAQuery<BoardGetResponse> query = queryFactory
                .select(new QBoardGetResponse(qBoard))
                .from(qBoard)
                .leftJoin(qBoard.member,qMember)
                .where(titleContains(getBoardRequest.getTitle()),
                        contentContains(getBoardRequest.getContent()),
                        qBoard.tema.eq(getBoardRequest.getTema())
                        )
                .offset(getBoardRequest.getPageNumber())
                .limit(getBoardRequest.getPageSize());
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



//    private Long id;
//    private String title;
//    private String content;
//    private LocalDateTime createAt;
//    private String tema;
//    private Integer like;



}



