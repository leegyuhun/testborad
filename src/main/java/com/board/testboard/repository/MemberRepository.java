package com.board.testboard.repository;

import com.board.testboard.domain.Member;
import com.board.testboard.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public MemberRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    QMember qMember = QMember.member;

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public List<Member> findById(String id) {
        return queryFactory.selectFrom(qMember)
                .where(qMember.userID.eq(id))
                .fetch();
//        return Optional.ofNullable(em.find(Member.class, id));
    }

    public List<Member> findByName(String name) {
        return queryFactory.selectFrom(qMember)
                .where(qMember.userName.eq(name))
                .fetch();
//        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//        return result.stream().findAny();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
