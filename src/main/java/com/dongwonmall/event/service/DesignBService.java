package com.dongwonmall.event.service;

import com.dongwonmall.event.experience.domain.Event;
import com.dongwonmall.event.experience.domain.Product;
import com.dongwonmall.event.experience.service.EventService;
import com.dongwonmall.event.user.domain.User;
import com.dongwonmall.event.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class DesignBService implements DesignService {


    private final String DESIGN_VERSION = "2";

    private final UserService userService;
    private final EventService eventService;

    public DesignBService(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    public String setRestMainModel(Model model, List<Event> eventList, String event_Seq) {

        Product product = new Product(event_Seq);

        Product total = userService.getContentsCnt(product);
        List<Product> mainProdList = eventService.getMainProdLis(event_Seq);
        List<Product> endProdList = eventService.getEndProdLis(DESIGN_VERSION);

        model.addAttribute("totalCnt", total.getTotalCnt())
                .addAttribute("mainProdList", mainProdList)
                .addAttribute("endProdList", endProdList);

        return "event_2";
    }

    @Override
    public String setRestDetailModel(EventService eventService, Model model, List<Product> prodList, List<User> contentList, Product product) {
        model.addAttribute("prodList", prodList)
                .addAttribute("prodCnt", prodList.size());
        return "experience_2";
    }
}
