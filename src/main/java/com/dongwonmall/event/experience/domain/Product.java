package com.dongwonmall.event.experience.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

    private String productId;
    private String img_Nm;
    private String product_Nm;
    private String price;
    private String event_Seq;
    private String review_Star;


    // 댓글 페이지네이션 위함
    private int start_N;
    private int end_N;
    private int totalPage;
    private int totalCnt;

    //DESIGN VERSION 1
    private int refreshNum;
    private int prod_Seq;
    public Product(String event_Seq){
        this.event_Seq = event_Seq;
    }
    public Product(String event_Seq, int refreshNum){
        this.event_Seq = event_Seq;
        this.refreshNum = refreshNum;
    }

    public Product(int totalCnt, int totalPage){
        this.totalCnt = totalCnt;
        this.totalPage = totalPage;
    }
}
