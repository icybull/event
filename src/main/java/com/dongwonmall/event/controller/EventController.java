package com.dongwonmall.event.controller;

import com.dongwonmall.event.experience.domain.Event;
import com.dongwonmall.event.experience.domain.Product;
import com.dongwonmall.event.experience.service.EventService;
import com.dongwonmall.event.service.DesignAService;
import com.dongwonmall.event.service.DesignBService;
import com.dongwonmall.event.service.DesignCService;
import com.dongwonmall.event.service.DesignService;
import com.dongwonmall.event.user.domain.User;
import com.dongwonmall.event.user.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class EventController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private final DesignAService designAService;
    private final DesignBService designBService;
    private final DesignCService designCService;
    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public EventController(DesignAService designAService, DesignBService designBService, DesignCService designCService, EventService eventService, UserService userService) {
        this.designAService = designAService;
        this.designBService = designBService;
        this.designCService = designCService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user_Seq") != null) {
            session.removeAttribute("user_Seq");
        }
        return "index";
    }


    /**
     * 이벤트 체험단 메인 페이지
     * @param e_Cnt 보여줄 체험단 이벤트 갯수
     * @param version 디자인 구분값
     */
    @GetMapping("/event/main.do")
    public String main(HttpServletRequest request, Model model, @RequestParam("E_CNT") int e_Cnt, @RequestParam("version") int version) {
        HttpSession session = request.getSession();
        session.setAttribute("version", version);

        DesignService designerService =
                version == 1 ? designAService :
                version == 2 ? designBService :
                version == 3 ? designCService :
                null;
        if(designerService == null) return "redirect:/";
        List<Event> eventList = eventService.selAllEvent(e_Cnt);
        String event_Seq = eventList.get(0).getEvent_Seq();
        int eventCnt = eventService.selEventCnt();

        designerService.setCommonMainModel(model, eventList, e_Cnt, eventCnt);
        return designerService.setRestMainModel(model, eventList, event_Seq);
    }


    /**
     * 해당 이벤트 체험단 상세 페이지
     * @param product 해당 이벤트 seq 정보
     * @param page 댓글 현재 페이지 정보
     * @param myContent 전체 댓글 보기 / 내 댓글 보기
     */
    @GetMapping("/experienceForm.do")
    public String detail(HttpServletRequest request, Model model, Product product, @RequestParam("page") int page, @RequestParam("myContent") int myContent) {
        HttpSession session = request.getSession();
        // 세션 값 없으면 index로 리다이렉트
        if (session.getAttribute("version") == null) {
            return "redirect:/";
        }
        // 사용자 등록, 댓글 등록 여부 확인 - 있으면 user_seq / 없으면 0
        String user_Seq = userService.chkRegUser(session);
        int version = Integer.parseInt(session.getAttribute("version").toString());
        DesignService designerService =
                version == 1 ? designAService :
                version == 2 ? designBService :
                version == 3 ? designCService :
                null;
        if(designerService == null) return "redirect:/";
        List<Product> prodList = eventService.selRelProduct(product);
        List<User> contentList = userService.selContents(myContent, product, page, user_Seq);

        designerService.setCommonDetailModel(session, userService, eventService, model, contentList, product, page, myContent);
        return designerService.setRestDetailModel(eventService, model, prodList, contentList, product);
    }

    /**
     * 레이어 팝업 사용자 등록
     * @param user 사용자 정보
     */
    @ResponseBody
    @PostMapping("/join/regUser")
    public String regUser(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        return userService.regUser(session, user);
    }

    //댓글 등록
    @ResponseBody
    @PostMapping("/join/regContent")
    public String regContent(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        userService.regContent(user);
        session.setAttribute("isReg", "T");
        return "success";
    }

    /**
     * 댓글 삭제
     * @param user_Seq 삭제할 사용자 seq
     */
    @ResponseBody
    @PostMapping("/delContent")
    public String delContent(HttpServletRequest request, @RequestParam("user_Seq") int user_Seq) {
        HttpSession session = request.getSession();
        User user = new User(user_Seq);
        userService.delContent(user);
        session.setAttribute("isReg", "F");
        return "success";
    }
}
