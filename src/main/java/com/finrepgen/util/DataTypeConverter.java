package com.finrepgen.util;
import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.Date;

public class DataTypeConverter {

    public static Date parse(String isoFormatDatetime) {
        return DatatypeConverter.parseDateTime(isoFormatDatetime).getTime();
    }
    public static String print(Date date) {
        return DatatypeConverter.printDateTime(toCalendar(date));
    }

    private static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}