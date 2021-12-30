package com.darmen.utilities.unittests.common;

import com.darmen.testutilities.common.utils.CommonUtils;
import com.darmen.utilities.unittests.TestBase;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CommonUtilsTests extends TestBase {

    private static final long PAUSE_TEST_DURATION = 5000;
    private static final String APPLE = "Apple";
    private static final String BANANA = "Banana";
    private static final String COCONUT = "Coconut";

    @Test
    public void pauseTest() throws InterruptedException {
        long before = System.currentTimeMillis();
        CommonUtils.pause(PAUSE_TEST_DURATION);
        long after = System.currentTimeMillis();

        assert (after - before >= PAUSE_TEST_DURATION);
    }

    @Test
    public void sortListAscending() {
        List<String> expectedList = Arrays.asList(APPLE, BANANA, COCONUT);
        List<String> unSortedList = Arrays.asList(BANANA, APPLE, COCONUT);
        List<String> sortedList = CommonUtils.sortList(unSortedList, "asc");

        assertEquals(sortedList.get(0), expectedList.get(0));
        assertEquals(sortedList.get(1), expectedList.get(1));
        assertEquals(sortedList.get(2), expectedList.get(2));
    }

    @Test
    public void sortListDescending() {
        List<String> expectedList = Arrays.asList(COCONUT, BANANA, APPLE);
        List<String> unSortedList = Arrays.asList(BANANA, APPLE, COCONUT);
        List<String> sortedList = CommonUtils.sortList(unSortedList, "desc");

        assertEquals(sortedList.get(0), expectedList.get(0));
        assertEquals(sortedList.get(1), expectedList.get(1));
        assertEquals(sortedList.get(2), expectedList.get(2));
    }
}

