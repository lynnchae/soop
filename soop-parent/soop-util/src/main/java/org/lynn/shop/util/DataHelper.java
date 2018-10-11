package org.lynn.soop.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public final class DataHelper {
    public static String generateUniqueToken() {
        return String.format("gougou_%s", UUID.randomUUID().toString());
    }

    public static String exceptionID() {
        return String.format("exception_gougou_%s", UUID.randomUUID().toString());
    }

    public static boolean notSet(Integer integer) {
        return integer == null || integer == 0;
    }

    public static String buildErrorMsg(String message) {
        String exceptionID = exceptionID();
        if (isEmpty(message)) {
            message = "error happens here";
        }

        return String.format("[%s]: %s", exceptionID, message);
    }


    public static Integer multiple(Integer base, BigDecimal factor) {
        if (base == null) {
            return 0;
        }
        double intFactor = factor.multiply(new BigDecimal(100)).doubleValue();
        return new BigDecimal(Math.ceil(intFactor * base / 100.0)).intValue();
    }

    public static Date startOfToday() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        String dateString = formatter.print(DateTime.now());
        DateTime dateTime = formatter.parseDateTime(dateString);
        return dateTime.toDate();
    }

    public static String batchNo(String randomSeed) {
        String datePrefix = dateFormat(DateTime.now(), "yyyyMMddhhmm");
        return String.format("%s%s", datePrefix, randomSeed);
    }


    public static String dateFormat(DateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
        return formatter.print(dateTime);
    }

    public static String shortString(String target, int lenght) {
        if (isEmpty(target)) return target;
        if (target.length() < lenght) return target;
        return target.substring(0, lenght);
    }

    public static String null2Empty(Object object) {
        if (object == null) {
            return "";
        }
        return object.toString();
    }
}
