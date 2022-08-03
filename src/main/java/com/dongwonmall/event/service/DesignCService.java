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
public class DesignCService implements DesignService {

    private final String DESIGN_VERSION = "3";
    private final EventService eventService;

    public DesignCService(EventService eventService) {
        this.eventService = eventService;
    }

    public String setRestMainModel(Model model, List<Event> eventList, String event_Seq) {
        List<Product> mainProdList = eventService.getMainProdLis(event_Seq);
        model.addAttribute("mainProdList", mainProdList);
        return "event_3";
    }

    @Override
    public String setRestDetailModel(EventService eventService, Model model, List<Product> prodList, List<User> contentList, Product product){
        for(User content : contentList){
            String level = "";
            switch (content.getGrd_Cd()){
                case 46 :
                    level = "LV.1 씨앗";
                    break;
                case 45 :
                    level = "LV.2 새싹";
                    break;
                case 44 :
                    level = "LV.3 나무";
                    break;
                case 43 :
                    level = "LV.4 밴드플러스";
                    break;
                default :
                    level = "임직원";
            }
            content.setLevel(level);
        }

        model.addAttribute("prodList", prodList)
                .addAttribute("contentList", contentList);
        return "experience_3";
    }
}
