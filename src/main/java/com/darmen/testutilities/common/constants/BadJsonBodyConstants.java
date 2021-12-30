package com.darmen.testutilities.common.constants;

import java.util.HashMap;
import java.util.Map;

public class BadJsonBodyConstants {

    private BadJsonBodyConstants() { }

    public static final String NO_CURLY_BRACKETS = "[\"test\": 123]";
    public static final String EMPTY_CURLY_BRACKETS = "{}";
    public static final String NAME_ONLY = "{\"test\"}";
    public static final String NAME_WITH_COLON = "{\"test\":}";
    public static final String VALUE_ONLY = "{: 123}";
    public static final String UNQUOTED_NAME = "{test: 123}";
    public static final String NULL_VALUE = "{\"test\": null}";

    public static Map<String, String> getBadJsonBodyConstants() {
        return JSON_MAP;
    }

    private static final Map<String, String> JSON_MAP;
    static {
        JSON_MAP = new HashMap<>();
        JSON_MAP.put("nocurlybrackets", NO_CURLY_BRACKETS);
        JSON_MAP.put("emptycurlybrackets", EMPTY_CURLY_BRACKETS);
        JSON_MAP.put("nameonly", NAME_ONLY);
        JSON_MAP.put("namewithcolon", NAME_WITH_COLON);
        JSON_MAP.put("valueonly", VALUE_ONLY);
        JSON_MAP.put("unquotedname", UNQUOTED_NAME);
        JSON_MAP.put("nullvalue", NULL_VALUE);
    }
}