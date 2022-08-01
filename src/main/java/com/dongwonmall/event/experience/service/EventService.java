package com.dongwonmall.event.experience.service;

import com.dongwonmall.event.dao.DataDao;
import com.dongwonmall.event.experience.domain.Event;
import com.dongwonmall.event.experience.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final String packageName = "com.dongwonmall.event.experience.domain.";

    private DataDao dataDao;

    @Autowired
    public EventService(DataDao dataDao){
        this.dataDao = dataDao;
    }

    public Event selEvent(Product product){
        return dataDao.selectOne(packageName+"selEvent",product);
    }

    public List<Event> selAllEvent(int e_Cnt){
        return dataDao.selectList(packageName+"selAllEvent", e_Cnt);
    }

    public int selEventCnt(){
        return dataDao.selectOne(packageName+"selEventCnt");
    }

    public List<Product> selRelProduct(Product product){
        return dataDao.selectList(packageName+"selRelProduct", product);
    }

    public List<Product> getMainProdLis(String event_Seq){
        Product product = new Product(event_Seq);
        return dataDao.selectList(packageName+"getMainProdLis", product);
    }

    public List<Product> getEndProdLis(String event_Seq){
        Product product = new Product(event_Seq);
        return dataDao.selectList(packageName+"getEndProdLis", product);
    }

    public List<Product> getRestProdLis(String event_Seq, int refreshNum){
        Product product = new Product(event_Seq, refreshNum);
        return dataDao.selectList(packageName + "getRestProdLis" ,product);
    }

}
