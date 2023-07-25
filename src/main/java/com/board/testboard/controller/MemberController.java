package com.board.testboard.controller;

import com.board.testboard.domain.Member;
import com.board.testboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/new")
    public String createForm(){
        return "member/createMember";
    }

    @PostMapping("member/new")
//    public String create(Member form) {
    public String create(String userID, String userPW, String userName, String userBirth, String userEmail) {
        Member member = new Member();
        member.setUserID(userID);
        member.setUserPW(userPW);
        member.setUserName(userName);
        member.setUserBirth(userBirth);
        member.setUserEmail(userEmail);

        System.out.println("member = " + member.toString());
        memberService.join(member);

        return "redirect:/member/memberList";
    }

    @GetMapping("member/memberList")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();

        model.addAttribute("members", members);

        return "member/memberList";
    }
}
