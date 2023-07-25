package com.board.testboard.repository;

import com.board.testboard.domain.Board;
import com.board.testboard.domain.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BoardRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public BoardRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    QBoard qBoard = QBoard.board;

    public void saveBoard(Board board) {
        em.persist(board);
    }

    public List<Board> findBoardsAll() {
        return queryFactory.selectFrom(qBoard)
                .fetch();
    }

    public List<Board> findBoards(String title) {
        return queryFactory.selectFrom(qBoard)
                .where(qBoard.title.like(title))
                .fetch();
    }
}
