package com.dongwonmall.event.user.service;

import com.dongwonmall.event.dao.DataDao;
import com.dongwonmall.event.experience.domain.Product;
import com.dongwonmall.event.user.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private final String packageName = "com.dongwonmall.event.user.domain.";
    private DataDao dataDao;

    @Autowired
    public UserService(DataDao dataDao){
        this.dataDao = dataDao;
    }

    /**
     * 사용자 로그인
     * @param session 로그인 성공시 세션에 user_seq 저장
     * @param user 로그인하려는 사용자 정보
     * @return 사용자 등록 여부
     */
    public String regUser(HttpSession session, User user){
        String result = "";
        User chkUser = chkUser(user);
        // 기존 사용자인데 전화번호는 맞는데 이름이 틀릴 경우
        if (chkUser.getName().equals("notName")) {
            return "notName";
        }
        result = "login";
        if (chkUser.getName().equals(" ")) {
            dataDao.insert(packageName+"regUser", user);
            chkUser = dataDao.selectOne(packageName+"selUser", user);
            chkUser.setIsReg("F");
            result = "success";
        }
        session.setAttribute("user_Seq", chkUser.getUser_Seq());
        session.setAttribute("isReg", chkUser.getIsReg());
        return result;
    }


    // 사용자 등록 중복 체크
    private User chkUser(User user){
        //Optional.ofNullable()을 사용하면 db query 결과값에 대해 null 처리를 할 수 있다.
        Optional<User> chkUser = Optional.ofNullable(dataDao.selectOne(packageName+"chkUser", user)); // Optional 값을 가져오기 위해서는 get()으로 객체를 꺼내줘야 한다.
        Optional<User> regUser = null;
        if(chkUser.isPresent()){
            regUser = Optional.ofNullable(dataDao.selectOne(packageName+"selUser", user));
            if(regUser.isPresent()){
                // 사용자 등록은 되어있는 상태
                regUser.get().setIsReg("F");
            } else {
                regUser = Optional.ofNullable(new User());
                regUser.get().setName("notName");
            }
        } else {
            // 사용자 등록도 안된 상태
            regUser = Optional.ofNullable(new User());
            // notName
            regUser.get().setName(" ");
            regUser.get().setIsReg("F");
        }
        return regUser.get();
    }


    /**
     * 상세페이지 - 댓글 등록 여부 확인
     * @param user_Seq 사용자 정보
     */
    public String chkContent(int user_Seq){
        User user = new User(user_Seq);
        int chkUser = dataDao.selectOne(packageName + "chkContent", user);
        if(chkUser == 0){
            return "F";
        } else {
            return "T";
        }
    }
    // DB에서 직접 삭제할 경우 등록된 사용자인지 체크 아니면 세션 user_seq 값 삭제
    public String chkRegUser(HttpSession session){
        if (session.getAttribute("user_Seq") != null) {
            session.setAttribute("isReg", chkContent(Integer.parseInt(session.getAttribute("user_Seq").toString())));
            int chkReg = dataDao.selectOne(packageName + "chkRegUser", Integer.parseInt(session.getAttribute("user_Seq").toString()));
            if ( chkReg == 0) {
                session.removeAttribute("user_Seq");
                return "0";
            } else {
                return session.getAttribute("user_Seq").toString();
            }
        } else {
            return "0";
        }
    }



    //댓글 등록
    public int regContent(User user){
        return dataDao.update(packageName+"regContent", user);
    }

    // 댓글 조회
    public List<User> selContents(int myContent, Product product, int page, String user_Seq){
        //전체 댓글 보기 버튼
        List<User> contentList = null;
        if(myContent == 0){
            int start_N = ((page + 1) * 8) - 7 ;
            int end_N = (page + 1) * 8;
            product.setStart_N(start_N);
            product.setEnd_N(end_N);
            contentList = dataDao.selectList(packageName+"selContents", product);
        //내 댓글 보기 (등록된거 있으면 user_seq 통해서 검색하고 없으면 0으로 검색해서 검색 안되게 한다.)
        } else {
            User user = user_Seq == null ? new User(0) : new User(Integer.parseInt(user_Seq));
            contentList = dataDao.selectList(packageName+"myContent", user);
        }
        return contentList;
    }

    //댓글 총 갯수
    public Product getContentsCnt(Product product){
        int totalCnt = dataDao.selectOne(packageName+"getContentsCnt", product);
        int totalPage = totalCnt/8;
        if(totalCnt%8 != 0) totalPage++;
        return new Product(totalCnt, totalPage);
    }

    // 댓글 삭제
    public void delContent(User user){
         int result = dataDao.delete(packageName+"delContent", user);
         logger.debug("delContent result ::>> " + result);
    }

    // version 1 실시간 댓글 가져오기(5개)
    public List<User> getLatestContent(){
        return dataDao.selectList(packageName+"getLatestContent");
    }
}
