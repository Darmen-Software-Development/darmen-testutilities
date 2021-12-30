package com.darmen.testutilities.common.constants;

import com.darmen.testutilities.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class InvalidUrlConstants {
    private InvalidUrlConstants() {

    }

    private static final int STANDARD_RANDOM_LETTERS = 5;
    private static final int MAX_URL_LENGTH = 2048;

    public static final String GREATER_THAN = "x>y";
    public static final String LESSER_THAN = "x<y";
    public static final String HASH_POUND_NUMBER = "#";
    public static final String LEFT_CURLY_BRACE = "{";
    public static final String RIGHT_CURLY_BRACE = "}";
    public static final String PIPE = "|";
    public static final String CARROT = "^";
    public static final String TILDE = "~";
    public static final String LEFT_SQUARE_BRACKET = "[";
    public static final String RIGHT_SQUARE_BRACKET = "]";

    // Removed the curly braces as it was causing issues with the test runner

    public static Map<String, String> getInvalidCharacters() {
        return INVALID_CHARACTERS;
    }

    private static final Map<String, String> INVALID_CHARACTERS;
    static {
        INVALID_CHARACTERS = new HashMap<>();
        INVALID_CHARACTERS.put("space", TestStringConstants.SPACE);
        INVALID_CHARACTERS.put("doublequote", TestStringConstants.QUOTE);
        INVALID_CHARACTERS.put("percentage", TestStringConstants.PERCENTAGE);
        INVALID_CHARACTERS.put("backwardslash", TestStringConstants.BACKWARDSLASH);
        INVALID_CHARACTERS.put("tick", TestStringConstants.TICK);
        INVALID_CHARACTERS.put("greaterthan", GREATER_THAN + StringUtils.randomLetterString(STANDARD_RANDOM_LETTERS));
        INVALID_CHARACTERS.put("lessthan", LESSER_THAN + StringUtils.randomLetterString(STANDARD_RANDOM_LETTERS));
        INVALID_CHARACTERS.put("hash", HASH_POUND_NUMBER + StringUtils.randomLetterString(STANDARD_RANDOM_LETTERS));
        INVALID_CHARACTERS.put("pipe", PIPE + StringUtils.randomLetterString(STANDARD_RANDOM_LETTERS));
        INVALID_CHARACTERS.put("carrot", CARROT + StringUtils.randomLetterString(STANDARD_RANDOM_LETTERS));
        INVALID_CHARACTERS.put("tilde", TILDE + StringUtils.randomLetterString(STANDARD_RANDOM_LETTERS));
        INVALID_CHARACTERS.put("leftsquarebracket", LEFT_SQUARE_BRACKET + StringUtils.randomLetterString(STANDARD_RANDOM_LETTERS));
        INVALID_CHARACTERS.put("rightsquarebracket", RIGHT_SQUARE_BRACKET + StringUtils.randomLetterString(STANDARD_RANDOM_LETTERS));
        INVALID_CHARACTERS.put("toolong", StringUtils.randomLetterString(MAX_URL_LENGTH));
    }
}
