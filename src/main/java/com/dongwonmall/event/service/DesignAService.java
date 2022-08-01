package com.dongwonmall.event.service;

import com.dongwonmall.event.DateUtil;
import com.dongwonmall.event.experience.domain.Event;
import com.dongwonmall.event.experience.domain.Product;
import com.dongwonmall.event.experience.service.EventService;
import com.dongwonmall.event.user.domain.User;
import com.dongwonmall.event.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class DesignAService implements DesignService {

    private final String DESIGN_VERSION = "1";
    private final UserService userService;

    public DesignAService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String setRestMainModel(Model model, List<Event> eventList, String event_Seq) {
        model.addAttribute("now", DateUtil.getCurrentMMddHHmm())
                .addAttribute("latestContentList", userService.getLatestContent());
        return "event_1";
    }

    @Override
    public String setRestDetailModel(EventService eventService, Model model, List<Product> prodList, List<User> contentList, Product product) {
        // DESIGN VERSION 1 '이런 상품 어때요 새로고침 페이지
        int refreshNum = product.getRefreshNum() + 1;
        if (refreshNum == 4) refreshNum = 1;
        for (Product prod : prodList) {
            prod.setImg_Nm(prod.getImg_Nm().replace("/", "-"));
        }
        List<Product> restProdList = eventService.getRestProdLis(DESIGN_VERSION, refreshNum);
        model.addAttribute("prodList", prodList)
                .addAttribute("prodCnt", prodList.size())
                .addAttribute("restProdList", restProdList)
                .addAttribute("refreshNum", refreshNum);
        return "experience_1";
    }
}
