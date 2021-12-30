package com.darmen.testutilities.customexceptions;

/**
 * The AutomationCommonsRuntimeException class provides custom runtime exceptions for test automation issues
 *
 * @author scottshea
 */

public class AutomationCommonsRuntimeException extends RuntimeException {

    /**
     * Provides custom runtime exceptions for test automation issues
     *
     * @param errorMessage String
     */

    public AutomationCommonsRuntimeException(String errorMessage) {
        super(errorMessage);
    }
}