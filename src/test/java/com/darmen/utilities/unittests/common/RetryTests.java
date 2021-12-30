package com.darmen.utilities.unittests.common;

import com.darmen.testutilities.common.listener.Retry;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class RetryTests {
    private static final String METHOD_NAME = "testMethodName";
    private static final boolean EXPECTED_TRUE = true;

    private Retry retry;

    ITestResult mockITestResult = mock(ITestResult.class);
    ITestNGMethod mockTestMethod = mock(ITestNGMethod.class);

    @Test
    public void retryDefaultTries() {
        retry = new Retry();
        when(mockITestResult.getMethod()).thenReturn(mockTestMethod);
        when(mockTestMethod.getMethodName()).thenReturn(METHOD_NAME);

        boolean actual = retry.retry(mockITestResult);

        assertEquals(actual, EXPECTED_TRUE);
    }

    @Test
    public void retrySpecifiedTries() {
        System.setProperty("retryCount", "10");
        retry = new Retry();
        when(mockITestResult.getMethod()).thenReturn(mockTestMethod);
        when(mockTestMethod.getMethodName()).thenReturn(METHOD_NAME);

        boolean actual = retry.retry(mockITestResult);

        assertEquals(actual, EXPECTED_TRUE);
    }

    @Test
    public void retryNoRetries() {
        System.setProperty("retryCount", "0");
        retry = new Retry();
        when(mockITestResult.getMethod()).thenReturn(mockTestMethod);
        when(mockTestMethod.getMethodName()).thenReturn(METHOD_NAME);

        boolean actual = retry.retry(mockITestResult);

        assertFalse(actual);
    }
}

