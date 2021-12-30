package com.darmen.testutilities.common.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This Class will contain testNG retry extended methods
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private static final int DEFAULT_MAX_TRY = 3;
    private int maxRetry;

    public Retry() {
        // Normally I think of ternary operators as "the devil's method" but they are helpful in keeping code clean
        maxRetry = System.getProperty("retryCount") != null ? Integer.parseInt(System.getProperty("retryCount")) : DEFAULT_MAX_TRY;
    }
    /**
     * TestNG Retry
     * This will Run a failing test a number of times based on a provided property or 3 times by default
     * set Property 'retryCount'
     */


    @Override
    public boolean retry(ITestResult iTestResult) {

        boolean success;

        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
            if (count < maxRetry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
                success = true;                                 //Tells TestNG to re-run the test
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
                success = false;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
            success = false;
        }
        return success;
    }
}

