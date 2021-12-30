package com.darmen.utilities.unittests.common;


import com.darmen.utilities.unittests.TestBase;
import org.testng.annotations.Test;

import static com.darmen.testutilities.common.utils.StringUtils.capitalize;
import static com.darmen.testutilities.common.utils.StringUtils.randomInt;
import static com.darmen.testutilities.common.utils.StringUtils.randomLetterString;
import static com.darmen.testutilities.common.utils.StringUtils.randomString;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class StringUtilsTests extends TestBase {
    private static final int STRING_SIZE = 8;
    private static final String CHARACTER_SET = "abcdefghijklmnopqurstuvwxyz";
    private static final int MAX_RANGE = 20;
    private static final int MIN_RANGE = 10;

    @Test
    public void capitalizeAllLower() {
        String testLower = "testlower";
        assertEquals(capitalize(testLower), "Testlower");
    }

    @Test
    public void capitalizeAllUpper() {
        String testCaps = "TESTCAPS";
        assertEquals(capitalize(testCaps), "TESTCAPS");
    }

    @Test
    public void capitalizeMixedCase() {
        String testMixedCase = "tesTmiXeD";
        assertEquals(capitalize(testMixedCase), "TesTmiXeD");
    }

    @Test
    public void randomStringBySize() {
        String testString = randomString(STRING_SIZE);
        assertEquals(testString.length(), STRING_SIZE);
    }

    @Test
    public void randomLetterStringBySize() {
        String testString = randomLetterString(STRING_SIZE);
        assertEquals(testString.length(), STRING_SIZE);
        assertFalse(testString.matches("[0-9]+"));

    }

    @Test
    public void randomLetterStringBySetAndSize() {
        String testString = randomString(CHARACTER_SET, STRING_SIZE);
        assertEquals(testString.length(), STRING_SIZE);
        assertTrue(testString.matches("[a-z]+"));
        assertFalse(testString.matches("[0-9]+"));
        assertFalse(testString.matches("[A-Z]+"));

    }

    @Test
    public void randomIntWithMaxOnly() {
        int testInt = randomInt(MAX_RANGE);
        assertTrue(testInt > 0);
        assertTrue(testInt <= MAX_RANGE);
    }

    @Test
    public void randomIntWithMinAndMax() {
        int testInt = randomInt(MIN_RANGE, MAX_RANGE);
        assertTrue(testInt >= MIN_RANGE);
        assertTrue(testInt <= MAX_RANGE);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void randomIntWithMinAndMaxReversed() {
        randomInt(MAX_RANGE, MIN_RANGE);
    }
}

