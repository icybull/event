package com.dongwonmall.event.service;

import com.dongwonmall.event.experience.domain.Event;
import com.dongwonmall.event.experience.domain.Product;
import com.dongwonmall.event.experience.service.EventService;
import com.dongwonmall.event.user.domain.User;
import com.dongwonmall.event.user.service.UserService;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface DesignService {
    default void setCommonMainModel(Model model, List<Event> eventList, int e_Cnt, int eventCnt){
        model.addAttribute("eventCnt", eventCnt)
                .addAttribute("listSize", eventList.size())
                .addAttribute("e_Cnt", e_Cnt)
                .addAttribute("mainEvent", eventList.get(0));
        eventList.remove(0);
        model.addAttribute("endEventList", eventList);
    }

    default void setCommonDetailModel(HttpSession session, UserService userService, EventService eventService, Model model, List<User> contentList, Product product, int page, int myContent){
        session.setAttribute("event_Seq", product.getEvent_Seq());
        Event event = eventService.selEvent(product);
        Product total = userService.getContentsCnt(product);

        if (contentList.size() > 1) {
            model.addAttribute("totalPage", total.getTotalPage());
        } else {
            model.addAttribute("totalPage", 1);
        }
        model.addAttribute("event", event)
                .addAttribute("page", page)
                .addAttribute("totalCnt", total.getTotalCnt())
                .addAttribute("contentList", contentList)
                .addAttribute("myContent", myContent);
    }

    String setRestMainModel(Model model, List<Event> eventList, String event_Seq);
    String setRestDetailModel(EventService eventService, Model model, List<Product> prodList, List<User> contentList, Product product);
}
