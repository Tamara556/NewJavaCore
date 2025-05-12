package main.MedicalCenter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final Date globalDate = new Date();
    private static final SimpleDateFormat onlyYear = new SimpleDateFormat("yyyy");
    private static final SimpleDateFormat onlyMonth = new SimpleDateFormat("MM");
    private static final SimpleDateFormat onlyDay = new SimpleDateFormat("dd");

    static public final SimpleDateFormat dateMinute = new SimpleDateFormat("dd/MM/yyyy HH:m");
    static public final SimpleDateFormat dateYear = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean areTheDatesTheSame(Date date1, Date date2) {
        return dateYear.format(date1).equals(dateYear.format(date2));
    }

    public static boolean registeredPatientDateChecker(Date date){
        if(Integer.parseInt(onlyYear.format(date)) < Integer.parseInt(onlyYear.format(globalDate))){
            return false;
        }

        if(Integer.parseInt(onlyYear.format(date)) >= Integer.parseInt(onlyYear.format(globalDate))){
            if(Integer.parseInt(onlyMonth.format(date)) < Integer.parseInt(onlyMonth.format(globalDate))){
                return false;
            }
        }

        if(Integer.parseInt(onlyYear.format(date)) > Integer.parseInt(onlyYear.format(globalDate))){
            return true;
        }

        if(Integer.parseInt(onlyYear.format(date)) >= Integer.parseInt(onlyYear.format(globalDate))){
            if(Integer.parseInt(onlyMonth.format(date)) > Integer.parseInt(onlyMonth.format(globalDate))){
                return true;
            }
        }

        if(Integer.parseInt(onlyYear.format(date)) >= Integer.parseInt(onlyYear.format(globalDate))){
            if(Integer.parseInt(onlyMonth.format(date)) >= Integer.parseInt(onlyMonth.format(globalDate))){
                return Integer.parseInt(onlyDay.format(date)) >= Integer.parseInt(onlyDay.format(globalDate));
            }
        }

        return false;
    }

}