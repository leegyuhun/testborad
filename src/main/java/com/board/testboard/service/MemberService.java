package com.board.testboard.service;

import com.board.testboard.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member join(Member member);

    List<Member> findMembers();

    List<Member> findOne(String memberId);
}
