package Training.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeFormat {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String time1 = "06:00:00 AM";
        String time2 = "06:00:01 AM";

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date;
        try {
            date = formatter.parse(time1);
            long time11 = date.getTime();
            System.out.println("Time " + time1 + " in Milliseconds: " + time11);


            date = formatter.parse(time2);
            long time22 = date.getTime();
            System.out.println("Time " + time2 + " in Milliseconds: " + time22);


            long timechenhlech = Math.abs(time11 - time22);
            System.out.println("time 2 - time 1: " + timechenhlech);
            System.out.println(timechenhlech <= 1000);


        } catch (
                ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
