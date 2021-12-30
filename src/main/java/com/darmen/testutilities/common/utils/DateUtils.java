package com.darmen.testutilities.common.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import static com.darmen.testutilities.common.constants.DateConstants.MM_DD_YYYY;
import static com.darmen.testutilities.common.constants.DateConstants.YYYY_DD_MM_HH_MM_SS;

/**
 * This Class will be contain date manipulation methods
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
public class DateUtils {

    private DateUtils() { }

    private static final String DEFAULT_DATE_PATTERN = YYYY_DD_MM_HH_MM_SS;
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);

    /**
     * Gets a formatted date time for the the date time passed
     *
     * @param dateTime LocalDateTime value
     * @param pattern  the desired pattern format
     *                 Using String... to make pattern optional and return a default pattern if blank
     * @return formattedDateTime String
     */
    public static String getFormattedDateTime(LocalDateTime dateTime, String... pattern) {
        String formattedDateTime = dateTime.format(DEFAULT_DATE_FORMATTER);

        if (pattern.length != 0 && pattern[0].length() != 0) {
            formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern(pattern[0]));
        }

        return formattedDateTime;
    }

    /**
     * Gets the current date time (defaults to yyyy-dd-MM HH:mm:ss if pattern is not specified)
     * Visit https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns for more pattern examples
     *
     * @param pattern - the desired pattern format
     * @return currentDateTime String
     */
    public static String getCurrentDateTime(String... pattern) {
        return getFormattedDateTime(LocalDateTime.now(), pattern);
    }

    /**
     * Gets a date in the future of x days
     *
     * @param days number of days in the future
     * @param pattern String
     * @return String MM/dd/yyyy
     */
    public static String getFutureDateDays(int days, String... pattern) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusDays(days);

        return getFutureFormattedDateTime(future, pattern);
    }

    /**
     * Gets a date in the future of x months
     *
     * @param months number of months in the future
     * @param pattern String
     * @return String MM/dd/yyyy
     */
    public static String getFutureDateMonths(int months, String... pattern) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusMonths(months);

        return getFutureFormattedDateTime(future, pattern);
    }

    /**
     * Gets a date in the future of x years
     *
     * @param years number of years in the future
     * @param pattern String
     * @return String MM/dd/yyyy
     */
    public static String getFutureDateYears(int years, String... pattern) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusYears(years);

        return getFutureFormattedDateTime(future, pattern);

    }

    /**
     * Formats a date into UTC for desired format
     *
     * @param format the date format desired
     * @param date Date object
     * @return String formatted date string in UTC time
     */
    public static String formattedDateUTC(String format, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        return simpleDateFormat.format(date);
    }

    private static String getFutureFormattedDateTime(LocalDateTime future, String[] pattern) {
        String futureDate;

        if (pattern.length == 0) {
            futureDate = getFormattedDateTime(future, MM_DD_YYYY);
        } else {
            futureDate = getFormattedDateTime(future, pattern[0]);
        }

        return futureDate;
    }
}

