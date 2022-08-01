package com.dongwonmall.event;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getCurrentMMddHHmm(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd HH:mm");
        return dateFormat.format(date);
    }


}
