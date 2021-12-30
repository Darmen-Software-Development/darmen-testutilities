package com.darmen.testutilities.common.constants;

import com.darmen.testutilities.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;
/**
 * Constants for different types of problematic emails
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
public class TestStringConstants {
    private TestStringConstants() { }
    private static final int RANDOM_CHAR_LENGTH = 5;

    // Accents
    public static final String ENYA = "peña";
    public static final String ACCUTE = "padmé";
    public static final String GRAVE = "très";
    public static final String CEDILLA = "françois";
    public static final String UMLAUT = "anaïs";
    public static final String CIRCUMFLEX = "côte";

    // Symbols & Spaces
    public static final String CONTRACTION = "o'shea";
    public static final String SPACE = "king richard";
    public static final String HYPHEN = "mary-jo";
    public static final String AMPERSAND = "in&out";
    public static final String AT_SYMBOL = "a@b";
    public static final String QUESTION = "what?";
    public static final String ASTERISK = "aaa*bbb";
    public static final String SEMICOLON = "var;";
    public static final String COLON = "food:water";
    public static final String PERIOD = "who.com";
    public static final String PERCENTAGE = "ten%";
    public static final String FORWARDSLASH = "and/or";
    public static final String BACKWARDSLASH = "and\\or";
    public static final String QUOTE = "\"quote\"";
    public static final String UNDERSCORE = "ruby_variable";
    public static final String EQUAL = "1=2";
    public static final String EXCLAMATION = "YES!";
    public static final String TICK = "`Code`";
    public static final String PLUS = "One+Two";

    // Boundaries
    public static final String SINGLE_CHARACTER = StringUtils.randomLetterString(1);

    public static Map<String, String> getStringMap() {
        return STRING_MAP;
    }

    private static final Map<String, String> STRING_MAP;
    static {
        STRING_MAP = new HashMap<>();
        STRING_MAP.put("enya", ENYA + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("accute", ACCUTE + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("grave", GRAVE + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("cedilla", CEDILLA + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("umlaut", UMLAUT + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("circumflex", CIRCUMFLEX + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("contraction", CONTRACTION + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("space", SPACE + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("hyphen", HYPHEN + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("ampersand", AMPERSAND + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("at_symbol", AT_SYMBOL + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("question", QUESTION + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("asterisk", ASTERISK + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("semicolon", SEMICOLON + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("colon", COLON + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("period", PERIOD + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("percentage", PERCENTAGE + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("forwardslash", FORWARDSLASH + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("backwardslash", BACKWARDSLASH + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("quote", QUOTE + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("underscore", UNDERSCORE + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("equal", EQUAL + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("exclamation", EXCLAMATION + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("tick", TICK + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("plus", PLUS + StringUtils.randomLetterString(RANDOM_CHAR_LENGTH));
        STRING_MAP.put("single", SINGLE_CHARACTER);
    }

}

