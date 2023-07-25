package com.board.testboard.service.impl;

import com.board.testboard.domain.Member;
import com.board.testboard.repository.MemberRepository;
import com.board.testboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public Member join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member;
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> findOne(String memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        if (member.getUserID() == null){
            throw new IllegalStateException("회원ID를 입력해주세요.");
        }
        if (member.getUserID() == null){
            throw new IllegalStateException("회원명을 입력해주세요.");
        }
        List<Member> mlist = memberRepository.findById(member.getUserID());
        if (memberRepository.findById(member.getUserID()).stream().count() > 0){
            throw new IllegalStateException("이미 존재하는 회원ID입니다.");
        }
//        memberRepository.findById(member.getUserID())
//                .ifPresent(a->{
//
//                });
    }
}
