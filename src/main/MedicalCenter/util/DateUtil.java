package main.MedicalCenter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final Date globalDate = new Date();

    private static final SimpleDateFormat year = new SimpleDateFormat("yyyy");
    private static final SimpleDateFormat month = new SimpleDateFormat("MM");
    private static final SimpleDateFormat day = new SimpleDateFormat("dd");
}
