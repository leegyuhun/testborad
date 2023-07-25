package com.board.testboard.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {
    private int seq;
    private int userAuth;
    private String userID;
    private String userPW;
    private String userName;
    private String userBirth;
    private String userEmail;
    private String userNote;
}
