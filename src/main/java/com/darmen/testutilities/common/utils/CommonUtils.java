package com.darmen.testutilities.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;


/**
 * This Class will be used to contain various data manipulation methods
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
public class CommonUtils {

    private CommonUtils() { }

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

    /**
     * Sorts a list of elements, defaults to 'asc'
     *
     * @param list      List
     * @param sortOrder sort order 'asc' or 'desc'
     * @return Sorted List
     */
    public static List<String> sortList(List<String> list, String sortOrder) {
        Collections.sort(list);

        if (sortOrder.equalsIgnoreCase("desc"))  {
            list.sort(Collections.reverseOrder());
        }

        return list;
    }


    /**
     * Pauses the thread run for specified milliseconds
     *
     * @param milliseconds Long for milliseconds to pause
     */
    public static void pause(long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    /**
     * Outputs formatted status message to the console
     *
     * @param message String to be output to the console
     */
    public static void outputToConsole(String message) {
        LOGGER.debug(message);
    }

    /**
     * Outputs formatted status message to the console
     *
     * @param message int to be output to the console
     */
    public static void outputToConsole(int message) {
        outputToConsole(String.valueOf(message));
    }


}

