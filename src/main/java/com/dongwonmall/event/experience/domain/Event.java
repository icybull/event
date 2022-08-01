package com.dongwonmall.event.experience.domain;

import lombok.Data;

@Data
public class Event {

    private String event_Seq;
    private String img_Nm;
    private String title;
    private String start_Date;
    private String end_Date;
    //요일
    private String start_Dy;
    private String end_Dy;
    // 이벤트 기간 flag
    private String eventIng;

}
