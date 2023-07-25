package com.board.testboard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "user")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;
    @ColumnDefault("1")
    private int userAuth; //0: 관리자, 1: 일반회원
    @Column(name = "user_ID", length = 20, unique = true)
    private String userID;
    @Column(name = "user_PW", length = 20, nullable = false)
    private String userPW;
    @Column(name = "user_name", length = 20, nullable = false)
    private String userName;
    @Column(name = "user_birth", length = 8, nullable = false)
    private String userBirth;
    @Column(name = "user_email", length = 30)
    private String userEmail;
    @Column(columnDefinition="TEXT")
    private String userNote;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();
}
