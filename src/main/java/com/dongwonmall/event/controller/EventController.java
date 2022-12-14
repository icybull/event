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
     * ????????? ????????? ?????? ?????????
     * @param e_Cnt ????????? ????????? ????????? ??????
     * @param version ????????? ?????????
     */
    @GetMapping("/event/main.do")
    public String main(HttpServletRequest request, Model model, @RequestParam("E_CNT") int e_Cnt, @RequestParam("version") int version) {
        try{
            HttpSession session = request.getSession();
            session.setAttribute("version", version);

            DesignService designerService = version == 1 ? designAService : version == 2 ? designBService : version == 3 ? designCService : null;
            List<Event> eventList = eventService.selAllEvent(e_Cnt);
            String event_Seq = eventList.get(0).getEvent_Seq();
            int eventCnt = eventService.selEventCnt();

            designerService.setCommonMainModel(model, eventList, e_Cnt, eventCnt);
            return designerService.setRestMainModel(model, eventList, event_Seq);
        } catch(NullPointerException e){
            logger.info("NullPointerException?????? ?????? redirect:/");
            return "error";
        } catch (Exception e){
            return "error";
        }
    }


    /**
     * ?????? ????????? ????????? ?????? ?????????
     * @param product ?????? ????????? seq ??????
     * @param page ?????? ?????? ????????? ??????
     * @param myContent ?????? ?????? ?????? / ??? ?????? ??????
     */
    @GetMapping("/experienceForm.do")
    public String detail(HttpServletRequest request, Model model, Product product, @RequestParam("page") int page, @RequestParam("myContent") int myContent) {
        try{
            HttpSession session = request.getSession();
            // ?????? ??? ????????? index??? ???????????????
            if (session.getAttribute("version") == null) {
                return "redirect:/";
            }
            // ????????? ??????, ?????? ?????? ?????? ?????? - ????????? user_seq / ????????? 0
            String user_Seq = userService.chkRegUser(session);
            int version = Integer.parseInt(session.getAttribute("version").toString());
            DesignService designerService = version == 1 ? designAService : version == 2 ? designBService : version == 3 ? designCService : null;
            List<Product> prodList = eventService.selRelProduct(product);
            List<User> contentList = userService.selContents(myContent, product, page, user_Seq);

            designerService.setCommonDetailModel(session, userService, eventService, model, contentList, product, page, myContent);
            return designerService.setRestDetailModel(eventService, model, prodList, contentList, product);
        } catch(Exception e){
            return "error";
        }
    }

    /**
     * ????????? ?????? ????????? ??????
     * @param user ????????? ??????
     */
    @ResponseBody
    @PostMapping("/join/regUser")
    public String regUser(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        return userService.regUser(session, user);
    }

    //?????? ??????
    @ResponseBody
    @PostMapping("/join/regContent")
    public String regContent(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        userService.regContent(user);
        session.setAttribute("isReg", "T");
        return "success";
    }

    /**
     * ?????? ??????
     * @param user_Seq ????????? ????????? seq
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
