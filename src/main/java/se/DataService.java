package se;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataService {
    static public int subDate(String date1, String date2){
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Date date = null;
        try {
            date = sdf.parse(date1);
            cal1.setTime(date);
            date = sdf.parse(date2);
            cal2.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return (int)( (cal2.getTime().getTime() - cal1.getTime().getTime()) / (1000 * 60 * 60 * 24));

    }
    static public double subDate(String date1){
        Calendar cal1 = new GregorianCalendar();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Date date = null;
        try {
            date = sdf.parse(date1);
            cal1.setTime(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  (double)(cal1.getTime().getTime()) / (1000 * 60 * 60 * 24);

    }
    static public String revertDate(Double date1){
        Calendar cal1 = new GregorianCalendar();
        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        cal1.setTimeInMillis((long)(1000 * 60 * 60 * 24 * date1));
        return sdf.format(cal1.getTime());
    }
}
