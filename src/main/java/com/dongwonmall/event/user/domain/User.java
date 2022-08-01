package com.dongwonmall.event.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본 생성자 자동으로 사용할 수 있게 해줌
public class User {

    private int user_Seq;
    private String name;
    private String phone_No;
    private String content;
    private int grd_Cd;
    private String grd_Nm;
    private String reg_Datetime;
    private String event_Seq;
    private String useYn;
    private String isReg;

    private String level;
    public User(int user_Seq){
        this.user_Seq = user_Seq;
    }
}
