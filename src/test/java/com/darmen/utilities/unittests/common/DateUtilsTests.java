package com.darmen.utilities.unittests.common;

import com.darmen.utilities.unittests.TestBase;
import com.darmen.utilities.unittests.common.dataproviders.CommonUtilsDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;
import java.util.TimeZone;

import static com.darmen.testutilities.common.constants.DateConstants.MM_DD_YYYY;
import static com.darmen.testutilities.common.constants.DateConstants.YYYY_DD_MM_HH_MM_SS;
import static com.darmen.testutilities.common.utils.DateUtils.formattedDateUTC;
import static com.darmen.testutilities.common.utils.DateUtils.getCurrentDateTime;
import static com.darmen.testutilities.common.utils.DateUtils.getFutureDateDays;
import static com.darmen.testutilities.common.utils.DateUtils.getFutureDateMonths;
import static com.darmen.testutilities.common.utils.DateUtils.getFutureDateYears;
import static com.darmen.testutilities.common.utils.DateUtils.getFormattedDateTime;

public class DateUtilsTests extends TestBase {

    private static final int TIME_LENGTH = 19;
    private static final int FUTURE_DAYS = 13;
    private static final int FUTURE_MONTHS = 8;
    private static final int FUTURE_YEARS = 5;

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String YEAR_FORMAT = "yyyy";
    private static final String MONTH_DAY_FORMAT = "MM-dd";

    private static final String BOGUS_DATE_TIME_FORMAT = "MEOW";

    private static final DateTimeFormatter MM_DD_YYYY_FORMATTER = DateTimeFormatter.ofPattern(MM_DD_YYYY);

    @Test
    public void getCurrentDateTimeDefaultFormat() {
        String theTime = getCurrentDateTime();
        Assert.assertEquals(theTime.length(), TIME_LENGTH, "Time: " + theTime + ", length was not equal to " + TIME_LENGTH);
    }

    @Test(dataProvider = "dateTimeFormats", dataProviderClass = CommonUtilsDataProvider.class)
    public void getCurrentDateTimeDifferentFormats(String timeFormat, String assertValue) {
        String theTime = getCurrentDateTime(timeFormat);
        assertContains(theTime, assertValue);
    }

    @Test
    public void getFutureDateDaysFutureDays() {
        String dateDay = getFutureDateDays(FUTURE_DAYS, DATE_FORMAT);
        String assertValue = String.valueOf(LocalDate.now().plusDays(FUTURE_DAYS));
        assertEquals(dateDay, assertValue);
    }

    @Test
    public void getFutureDateDaysFutureDaysNoFormat() {
        String dateDay = getFutureDateDays(FUTURE_DAYS);
        LocalDate today = LocalDate.now().plusDays(FUTURE_DAYS);
        String assertValue = today.format(MM_DD_YYYY_FORMATTER);
        assertEquals(dateDay, assertValue);
    }

    @Test
    public void getFutureDateMonthsFutureMonths() {
        String dateMonth = getFutureDateMonths(FUTURE_MONTHS, DATE_FORMAT);
        String assertValue = String.valueOf(LocalDate.now().plusMonths(FUTURE_MONTHS));
        assertEquals(dateMonth, assertValue);
    }

    @Test
    public void getFutureDateDaysFutureMonthsNoFormat() {
        String dateMonths = getFutureDateMonths(FUTURE_MONTHS);
        LocalDate today = LocalDate.now().plusMonths(FUTURE_MONTHS);
        String assertValue = today.format(MM_DD_YYYY_FORMATTER);
        assertEquals(dateMonths, assertValue);
    }

    @Test
    public void getFutureDateYearsFutureYears() {
        String dateYear = getFutureDateYears(FUTURE_YEARS, YEAR_FORMAT);
        String assertValue = Integer.toString(LocalDate.now().getYear() + FUTURE_YEARS);
        assertEquals(dateYear, assertValue);
    }

    @Test
    public void getFutureDateDaysFutureYearsNoFormat() {
        String dateDay = getFutureDateYears(FUTURE_YEARS);
        LocalDate today = LocalDate.now().plusYears(FUTURE_YEARS);
        String assertValue = today.format(MM_DD_YYYY_FORMATTER);
        assertEquals(dateDay, assertValue);
    }

    @Test
    public void getCurrentDateTimeMultipleTimeFormats() {
        String dateYear = getFutureDateYears(FUTURE_YEARS, YEAR_FORMAT, MONTH_DAY_FORMAT, DATE_FORMAT);
        String assertValue = Integer.toString(LocalDate.now().getYear() + FUTURE_YEARS);
        assertEquals(dateYear, assertValue);
    }


    @Test
    public void getFormattedDateTimeSuppliedPattern() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String theTime = getFormattedDateTime(localDateTime, DATE_FORMAT);
        assertEquals(theTime, localDateTime.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
    }

    @Test
    public void getFormattedDateTimeEmptyPattern() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String theTime = getFormattedDateTime(localDateTime, "");
        assertEquals(theTime, localDateTime.format(DateTimeFormatter.ofPattern(YYYY_DD_MM_HH_MM_SS)));
    }

    @Test(expectedExceptions = { UnsupportedTemporalTypeException.class })
    public void getFormattedDateTimeBogusPattern() {
        LocalDateTime localDateTime = LocalDateTime.now();
        getFormattedDateTime(localDateTime, BOGUS_DATE_TIME_FORMAT);
    }

    @Test
    public void getFormattedDateUTC() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MM_DD_YYYY);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        String expectedDate = simpleDateFormat.format(now);

        String actualDate = formattedDateUTC(MM_DD_YYYY, now);

        assertEquals(expectedDate, actualDate);
    }
}

