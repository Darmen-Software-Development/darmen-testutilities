package com.darmen.utilities.unittests;

import org.testng.Assert;

public class TestBase {

    private static final String ASSERT_VALUE_ONE_ROOT = "Value one: ";

    public void assertEquals(String valueOne, String valueTwo) {
        Assert.assertEquals(valueOne, valueTwo, ASSERT_VALUE_ONE_ROOT + valueOne + ", did not equal value two: " + valueTwo);
    }

    public void assertEquals(int valueOne, int valueTwo) {
        Assert.assertEquals(valueOne, valueTwo, ASSERT_VALUE_ONE_ROOT + valueOne + ", did not equal value two: " + valueTwo);
    }

    public void assertNotEquals(String valueOne, String valueTwo) {
        Assert.assertNotEquals(valueOne, valueTwo, ASSERT_VALUE_ONE_ROOT + valueOne + ", incorrectly equals value two: " + valueTwo);
    }

    public void assertContains(String valueOne, String valueTwo) {
        Assert.assertTrue(valueOne.contains(valueTwo), ASSERT_VALUE_ONE_ROOT + valueOne + ", did not contain value two: " + valueTwo);
    }

    public void assertDoesNotContain(String valueOne, String valueTwo) {
        Assert.assertFalse(valueOne.contains(valueTwo), ASSERT_VALUE_ONE_ROOT + valueOne + ", incorrectly contained value two: " + valueTwo);
    }
}
