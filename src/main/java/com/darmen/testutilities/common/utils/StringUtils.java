package com.darmen.testutilities.common.utils;

import java.util.Random;

/**
 * This Class will be contain string manipulation methods
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
public class StringUtils {

    private StringUtils() { }

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "1234567890";
    private static final String FOREIGN_CHARACTERS = "ñäöüßÄÖÜÑÞþÇçÙùÛûБбЯяФф";

    private static Random random = new Random();

    /**
     * Returns a String with the first letter capitalized
     *
     * @param capitalizeMe String
     * @return capitalizedString String
     */
    public static String capitalize(String capitalizeMe) {
        return capitalizeMe.substring(0, 1).toUpperCase() + capitalizeMe.substring(1);
    }

    /**
     * Makes a random string
     * @param size int
     * @return randomString String
     */
    public static String randomString(int size) {
        String charList = CHARACTERS + NUMBERS + FOREIGN_CHARACTERS;
        return randomString(charList, size);
    }

    /**
     * Returns a random string of ONLY letters based on size
     * @param size int
     * @return randomLettersString String
     */
    public static String randomLetterString(int size) {
        return randomString(CHARACTERS, size);
    }

    /**
     * Returns a random string of ONLY Foreign letters based on size
     * @param size int
     * @return randomForeignLetterString String
     */
    public static String randomForeignLetterString(int size) {
        return randomString(FOREIGN_CHARACTERS, size);
    }

    /**
     * Returns a random string of ONLY numbers based on size
     * @param size int
     * @return randomNumbersOnlyString String
     */
    public static String randomNumbersOnlyString(int size) {
        return randomString(NUMBERS, size);
    }

    /**
     * Returns a random string from character list for specified length
     *
     * @param charList "abcEFG"
     * @param size     length of string
     * @return randomString String
     */
    public static String randomString(String charList, int size) {
        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int number = random.nextInt(charList.length());
            char ch = charList.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    /**
     * Returns a random int between 0 and size
     * @param size int
     * @return randomInt int
     */
    public static int randomInt(int size) {
        return randomInt(0, size);
    }

    /**
     * Returns a random int between min and max values
     * @param min int
     * @param max int
     * @return randomInt int
     */
    public static int randomInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return random.nextInt((max - min) + 1) + min;
    }
}

