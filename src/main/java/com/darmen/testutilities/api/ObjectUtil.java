package com.darmen.testutilities.api;

import com.google.gson.Gson;

import java.util.Map;

/**
 * This Class will be used to hold helper methods for test objects
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */

public class ObjectUtil {

    /**
     * Turns object into Json string
     *
     * @return String
     */
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Converts a Json String to a Map
     *
     * @return Map
     */
    public Map<String, Object> toMap() {
        Gson gson = new Gson();
        return JsonUtil.createMapFromJsonString(gson.toJson(this));
    }
}

