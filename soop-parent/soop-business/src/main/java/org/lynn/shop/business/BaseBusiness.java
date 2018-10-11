package org.lynn.soop.business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenwen on 4/23/16.
 */
public abstract class BaseBusiness {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static String buildLikeCause(String text) {
        return "%" + text + "%";
    }
    
    public static String GenerateBillNo()
    {
      Date date = Calendar.getInstance().getTime();
      DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
      String str = sdf.format(date);
      Random random = new Random();
      int rannum = (int)(random.nextDouble() * 90000.0D) + 10000;
      return str + rannum;
    }
}
