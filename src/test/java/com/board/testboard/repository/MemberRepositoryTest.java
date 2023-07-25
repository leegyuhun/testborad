package com.board.testboard.repository;

import com.board.testboard.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

//    JpaMemberRepository repository = new JpaMemberRepository(em);

    @Test
    public void save(){
        Member member = new Member();
        member.setUserID("testID");
        member.setUserPW("testPW");
        member.setUserName("testName");

//        repository.save(member);
    }
}