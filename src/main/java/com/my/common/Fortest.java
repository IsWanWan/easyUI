package com.my.common;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wanwan on 16/9/2.
 */
public class Fortest {

    @Test
    public void test(){
      System.out.print("hahhaah");
  }

     @Test
    public void haha(){
         Date date  = new Date();

         System.out.println("hshshsh :"+System.currentTimeMillis());
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         String datestr = df.format(new Date());
         System.out.println(" 日期转字符串 :"+ datestr);

         String date1 = "2016-09-08";
         try {
           Date date2 =  df.parse(date1);
             System.out.println("dfsds:"+date2);
         } catch (ParseException e) {
             e.printStackTrace();
         }
     }

}
