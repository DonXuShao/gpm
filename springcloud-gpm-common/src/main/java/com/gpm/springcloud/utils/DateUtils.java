package com.gpm.springcloud.utils;

import org.apache.commons.httpclient.util.DateParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Don
 * @Description  时间日期工具类
 * @Date 2020/7/10 17:00
 **/
public class DateUtils {


    private DateUtils() {
    }


    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    private static final Collection DEFAULT_PATTERNS = Arrays.asList("EEE MMM d HH:mm:ss yyyy", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:ss zzz");
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
    private static final TimeZone GMT;

    public static Date parseDate(String dateValue) throws DateParseException {
        return parseDate(dateValue, (Collection)null, (Date)null);
    }

    public static Date parseDate(String dateValue, Collection dateFormats) throws DateParseException {
        return parseDate(dateValue, dateFormats, (Date)null);
    }

    public static Date parseDate(String dateValue, Collection dateFormats, Date startDate) throws DateParseException {
        if (dateValue == null) {
            throw new IllegalArgumentException("dateValue is null");
        } else {
            if (dateFormats == null) {
                dateFormats = DEFAULT_PATTERNS;
            }

            if (startDate == null) {
                startDate = DEFAULT_TWO_DIGIT_YEAR_START;
            }

            if (dateValue.length() > 1 && dateValue.startsWith("'") && dateValue.endsWith("'")) {
                dateValue = dateValue.substring(1, dateValue.length() - 1);
            }

            SimpleDateFormat dateParser = null;
            Iterator formatIter = dateFormats.iterator();

            while(formatIter.hasNext()) {
                String format = (String)formatIter.next();
                if (dateParser == null) {
                    dateParser = new SimpleDateFormat(format, Locale.US);
                    dateParser.setTimeZone(TimeZone.getTimeZone("GMT"));
                    dateParser.set2DigitYearStart(startDate);
                } else {
                    dateParser.applyPattern(format);
                }

                try {
                    return dateParser.parse(dateValue);
                } catch (ParseException var7) {
                }
            }

            throw new DateParseException("Unable to parse the date " + dateValue);
        }
    }

    public static String formatDate(Date date) {
        return formatDate(date, "EEE, dd MMM yyyy HH:mm:ss zzz");
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        } else if (pattern == null) {
            throw new IllegalArgumentException("pattern is null");
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.US);
            formatter.setTimeZone(GMT);
            return formatter.format(date);
        }
    }


    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 0, 1, 0, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = calendar.getTime();
        GMT = TimeZone.getTimeZone("GMT");
    }



}
