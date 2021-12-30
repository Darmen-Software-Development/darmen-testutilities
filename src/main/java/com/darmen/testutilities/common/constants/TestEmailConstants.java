package com.darmen.testutilities.common.constants;

/**
 * Constants for different types of problematic emails
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
import com.darmen.testutilities.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/*
 * You can use this to validate email addresses: http://isemail.info/
 */
public class TestEmailConstants {
    private TestEmailConstants() { }
    private static final String SAMPLE_DOMAIN = "@domain.com";
    private static final String SAMPLE_LOCAL = "local@";
    /*
     * VALID
     */
    // Taken from https://en.wikipedia.org/wiki/Email_address#Examples
    public static final String SIMPLE = "simple@example.com";
    public static final String COMMON = "very.common@example.com";
    public static final String DISPOSABLE = "disposable.style.email.with+symbol@example.com";
    public static final String HYPHEN_LOCAL = "other.email-with-hyphen@example.com";
    public static final String FULLY_QUALIFIED = "fully-qualified-domain@example.com";
    public static final String SORTING = "user.name+tag+sorting@example.com";
    public static final String SINGLE_LETTER_LOCAL = "x@example.com";
    public static final String HYPHEN_DOMAIN = "example-indeed@strange-example.com";
    public static final String LOCAL = "admin@mailserver1";
    public static final String SUB_DOMAIN = "example@s.example";
    public static final String SPACE_WITH_QUOTES = "\" \"@example.org";
    public static final String QUOTES_DOUBLE_DOT = "\"john..doe\"@example.org";
    public static final String BANG = "mailhost!username@example.org";
    public static final String ESCAPED_ROUTE = "user%example.com@example.org";
    // Taken from https://blogs.msdn.microsoft.com/testing123/2009/02/06/email-address-test-cases/
    public static final String IP_ADDRESS = "email@123.123.123.123";
    public static final String QUOTES = "\"email\"@domain.com";
    public static final String DIGITS = "1234567890@domain.com";
    public static final String UNDERSCORE = "_______@domain.com";
    public static final String COUNTRY_DOMAIN = "email@domain.co.jp";
    // Special characters broken out individually with quotes
    public static final String QUOTED_LONE_QUOTE = "\"lonequote\"\"@example.com";
    public static final String QUOTED_LEFT_PARENS = "\"leftparens(\"@example.com";
    public static final String QUOTED_RIGHT_PARENS = "\"rightparens)\"@example.com";
    public static final String QUOTED_COMMA = "\"comma,\"@example.com";
    public static final String QUOTED_COLON = "\"colon:\"@example.com";
    public static final String QUOTED_SEMI_COLON = "\"semicolon;\"@example.com";
    public static final String QUOTED_LESS_THAN = "\"lessthan<\"@example.com";
    public static final String QUOTED_GREATER_THAN = "\"greaterthan>\"@example.com";
    public static final String QUOTED_LEFT_BRACKET = "\"leftbracket[\"@example.com";
    public static final String QUOTED_RIGHT_BRACKET = "\"rightbracket]\"@example.com";
    public static final String QUOTED_BACKSLASH = "\"backslash\\\"@example.com";
    public static final String QUOTED_AT_SYMBOL = "\"atsymbol@\"@example.com";
    public static final String QUOTED_DOT = "\"dot.\"@example.com";
    // Special characters allowed without quotes - not otherwise covered
    public static final String HASH_POUND = "hash#pound@example.com";
    public static final String DOLLAR = "g$money@example.com";
    public static final String AMPERSAND = "in&out@example.com";
    public static final String SINGLE_QUOTE = "o'shea@example.com";
    public static final String ASTERISK = "wildcard*@example.com";
    public static final String FORWARD_SLASH = "forward/slash@example.com";
    public static final String EQUALS_SYMBOL = "one=one@example.com";
    public static final String QUESTION_MARK = "seriously?@example.com";
    public static final String CARET = "five^diamond@example.com";
    public static final String THE_TICK = "the`spoon@example.com";
    public static final String LEFT_CURLY_BRACE = "left{brace@example.com";
    public static final String RIGHT_CURLY_BRACE = "right}brace@example.com";
    public static final String PIPE_MORE = "more|pipe@example.com";
    public static final String TILDE = "~swinton@example.com";
    // Pushing the boundaries
    public static final String LOCAL_SIXTY_FOUR = StringUtils.randomLetterString(64) + SAMPLE_DOMAIN; // The local part of the address can be 64 characters long
    public static final String DOMAIN_TWO_FIFTY_FIVE = SAMPLE_LOCAL + StringUtils.randomLetterString(249) + ".com"; // The domain part of the address can be 254 characters long including the @ and the .TLN

    public static Map<String, String> getValidEmailMap() {
        return VALID_EMAIL_MAP;
    }

    private static final Map<String, String> VALID_EMAIL_MAP;
    static {
        VALID_EMAIL_MAP = new HashMap<>();
        VALID_EMAIL_MAP.put("simple", SIMPLE);
        VALID_EMAIL_MAP.put("common", COMMON);
        VALID_EMAIL_MAP.put("disposable", DISPOSABLE);
        VALID_EMAIL_MAP.put("hyphen_local", HYPHEN_LOCAL);
        VALID_EMAIL_MAP.put("fully_qualified", FULLY_QUALIFIED);
        VALID_EMAIL_MAP.put("sorting", SORTING);
        VALID_EMAIL_MAP.put("single_letter_local", SINGLE_LETTER_LOCAL);
        VALID_EMAIL_MAP.put("hyphen_domain", HYPHEN_DOMAIN);
        VALID_EMAIL_MAP.put("local", LOCAL);
        VALID_EMAIL_MAP.put("sub_domain", SUB_DOMAIN);
        VALID_EMAIL_MAP.put("space_with_quotes", SPACE_WITH_QUOTES);
        VALID_EMAIL_MAP.put("quotes_double_dot", QUOTES_DOUBLE_DOT);
        VALID_EMAIL_MAP.put("bang", BANG);
        VALID_EMAIL_MAP.put("escaped_route", ESCAPED_ROUTE);
        VALID_EMAIL_MAP.put("ip_address", IP_ADDRESS);
        VALID_EMAIL_MAP.put("quotes", QUOTES);
        VALID_EMAIL_MAP.put("digits", DIGITS);
        VALID_EMAIL_MAP.put("underscore", UNDERSCORE);
        VALID_EMAIL_MAP.put("country_domain", COUNTRY_DOMAIN);
        VALID_EMAIL_MAP.put("quoted_lone_quote", QUOTED_LONE_QUOTE);
        VALID_EMAIL_MAP.put("quoted_left_parens", QUOTED_LEFT_PARENS);
        VALID_EMAIL_MAP.put("quoted_right_parens", QUOTED_RIGHT_PARENS);
        VALID_EMAIL_MAP.put("quoted_comma", QUOTED_COMMA);
        VALID_EMAIL_MAP.put("quoted_colon", QUOTED_COLON);
        VALID_EMAIL_MAP.put("quoted_semi_colon", QUOTED_SEMI_COLON);
        VALID_EMAIL_MAP.put("quoted_less_than", QUOTED_LESS_THAN);
        VALID_EMAIL_MAP.put("quoted_greater_than", QUOTED_GREATER_THAN);
        VALID_EMAIL_MAP.put("quoted_left_bracket", QUOTED_LEFT_BRACKET);
        VALID_EMAIL_MAP.put("quoted_right_bracket", QUOTED_RIGHT_BRACKET);
        VALID_EMAIL_MAP.put("quoted_backslash", QUOTED_BACKSLASH);
        VALID_EMAIL_MAP.put("quoted_at_symbol", QUOTED_AT_SYMBOL);
        VALID_EMAIL_MAP.put("quoted_dot", QUOTED_DOT);
        VALID_EMAIL_MAP.put("hash_pound", HASH_POUND);
        VALID_EMAIL_MAP.put("dollar", DOLLAR);
        VALID_EMAIL_MAP.put("ampersand", AMPERSAND);
        VALID_EMAIL_MAP.put("single_quote", SINGLE_QUOTE);
        VALID_EMAIL_MAP.put("asterisk", ASTERISK);
        VALID_EMAIL_MAP.put("forward_slash", FORWARD_SLASH);
        VALID_EMAIL_MAP.put("question_mark", QUESTION_MARK);
        VALID_EMAIL_MAP.put("caret", CARET);
        VALID_EMAIL_MAP.put("the_tick", THE_TICK);
        VALID_EMAIL_MAP.put("left_curly_brace", LEFT_CURLY_BRACE);
        VALID_EMAIL_MAP.put("right_curly_brace", RIGHT_CURLY_BRACE);
        VALID_EMAIL_MAP.put("pipe_more", PIPE_MORE);
        VALID_EMAIL_MAP.put("tilde", TILDE);
        VALID_EMAIL_MAP.put("equals", EQUALS_SYMBOL);
        VALID_EMAIL_MAP.put("local_64", LOCAL_SIXTY_FOUR);
        VALID_EMAIL_MAP.put("domain_255", DOMAIN_TWO_FIFTY_FIVE);
    }

    /*
     * INVALID
     */
    // Taken from https://en.wikipedia.org/wiki/Email_address#Examples
    public static final String NO_AT_SIGN = "Abc.example.com";
    public static final String MULTIPLE_AT_SIGN = "A@b@c@example.com";
    public static final String SPECIAL_NO_QUOTES = "a\"b(c)d,e:f;g<h>i[j\\k]l@example.com";
    public static final String QUOTES_NOT_DOT_SEPARATED = "just\"not\"right@example.com";
    public static final String UNQUOTED_SPACE = "this is_not_allowed@example.com";
    public static final String UNQUOTED_SPACE_ESCAPED = "this\\ is_not_allowed@example.com";
    public static final String LOCAL_TOO_LONG = StringUtils.randomLetterString(65) + "@example.com";
    public static final String DOMAIN_TOO_LONG = SAMPLE_LOCAL + StringUtils.randomLetterString(255) + ".com";
    // Taken from https://blogs.msdn.microsoft.com/testing123/2009/02/06/email-address-test-cases/
    public static final String MISSING_LOCAL = SAMPLE_DOMAIN;
    public static final String MISSING_DOMAIN = SAMPLE_LOCAL;
    public static final String HTML_ENCODED = "Joe Smith <email@domain.com>";
    public static final String LEADING_DOT_LOCAL = ".email@domain.com";
    public static final String TRAILING_DOT_LOCAL = "email.@domain.com";
    public static final String LEADING_DOT_DOMAIN = "email@.domain.com.";
    public static final String TRAILING_DOT_DOMAIN = "email@domain.com.";
    public static final String MULTIPLE_DOTS_LOCAL = "email..email@domain.com";
    public static final String MULTIPLE_DOTS_DOMAIN = "email@domain..com";
    public static final String UNICODE = "あいうえお@domain.com";
    public static final String TRAILING_TEXT = "email@domain.com (Joe Smith)";
    public static final String LEADING_DASH = "email@-domain.com";
    public static final String INVALID_IP = "email@111.222.333.44444";
    public static final String INVALID_TOP_LEVEL = "email@domain." + StringUtils.randomLetterString(5);
    // Special characters broken out individually without quotes
    public static final String LONE_QUOTE = "lonequote\"@example.com";
    public static final String LEFT_PARENS = "leftparens(@example.com";
    public static final String RIGHT_PARENS = "rightparens)@example.com";
    public static final String COMMA = "comma,@example.com";
    public static final String COLON = "colon:@example.com";
    public static final String SEMI_COLON = "semicolon;@example.com";
    public static final String LESS_THAN = "lessthan<@example.com";
    public static final String GREATER_THAN = "greaterthan>@example.com";
    public static final String LEFT_BRACKET = "leftbracket[@example.com";
    public static final String RIGHT_BRACKET = "rightbracket]@example.com";
    public static final String BACKSLASH = "backslash\\@example.com";

    public static Map<String, String> getInvalidEmailMap() {
        return INVALID_EMAIL_MAP;
    }

    private static final Map<String, String> INVALID_EMAIL_MAP;
    static {
        INVALID_EMAIL_MAP = new HashMap<>();
        INVALID_EMAIL_MAP.put("no_at_sign", NO_AT_SIGN);
        INVALID_EMAIL_MAP.put("multiple_at_sign", MULTIPLE_AT_SIGN);
        INVALID_EMAIL_MAP.put("special_no_quotes", SPECIAL_NO_QUOTES);
        INVALID_EMAIL_MAP.put("quotes_not_dot_separated", QUOTES_NOT_DOT_SEPARATED);
        INVALID_EMAIL_MAP.put("unquoted_space", UNQUOTED_SPACE);
        INVALID_EMAIL_MAP.put("unquoted_space_escaped", UNQUOTED_SPACE_ESCAPED);
        INVALID_EMAIL_MAP.put("local_too_long", LOCAL_TOO_LONG);
        INVALID_EMAIL_MAP.put("domain_too_long", DOMAIN_TOO_LONG);
        INVALID_EMAIL_MAP.put("missing_local", MISSING_LOCAL);
        INVALID_EMAIL_MAP.put("missing_domain", MISSING_DOMAIN);
        INVALID_EMAIL_MAP.put("html_encoded", HTML_ENCODED);
        INVALID_EMAIL_MAP.put("leading_dot_local", LEADING_DOT_LOCAL);
        INVALID_EMAIL_MAP.put("trailing_dot_local", TRAILING_DOT_LOCAL);
        INVALID_EMAIL_MAP.put("leading_dot_domain", LEADING_DOT_DOMAIN);
        INVALID_EMAIL_MAP.put("trailing_dot_domain", TRAILING_DOT_DOMAIN);
        INVALID_EMAIL_MAP.put("multiple_dots_local", MULTIPLE_DOTS_LOCAL);
        INVALID_EMAIL_MAP.put("multiple_dots_domain", MULTIPLE_DOTS_DOMAIN);
        INVALID_EMAIL_MAP.put("unicode", UNICODE);
        INVALID_EMAIL_MAP.put("trailing_text", TRAILING_TEXT);
        INVALID_EMAIL_MAP.put("leading_dash", LEADING_DASH);
        INVALID_EMAIL_MAP.put("invalid_ip", INVALID_IP);
        INVALID_EMAIL_MAP.put("invalid_top_level", INVALID_TOP_LEVEL);
        INVALID_EMAIL_MAP.put("lone_quote", LONE_QUOTE);
        INVALID_EMAIL_MAP.put("left_parens", LEFT_PARENS);
        INVALID_EMAIL_MAP.put("right_parens", RIGHT_PARENS);
        INVALID_EMAIL_MAP.put("comma", COMMA);
        INVALID_EMAIL_MAP.put("colon", COLON);
        INVALID_EMAIL_MAP.put("semi_colon", SEMI_COLON);
        INVALID_EMAIL_MAP.put("less_than", LESS_THAN);
        INVALID_EMAIL_MAP.put("greater_than", GREATER_THAN);
        INVALID_EMAIL_MAP.put("left_bracket", LEFT_BRACKET);
        INVALID_EMAIL_MAP.put("right_bracket", RIGHT_BRACKET);
        INVALID_EMAIL_MAP.put("backslash", BACKSLASH);
    }
}

