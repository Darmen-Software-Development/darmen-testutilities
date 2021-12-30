package com.darmen.testutilities.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * This Class will be used to Parse the JSON that comes in mainly through
 * other classes that communicate with ReSTFul services
 *
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
@Data
public class JsonUtil {
    private JsonUtil() { }

    /**
     * convert a map of objects into a json string
     *
     * @param map - map of objects
     * @return - Json String
     */
    public static String createJson(Map<String, Object> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    /**
     * Converts a string json into a map
     *
     * @param json string json
     * @return Map
     */
    public static Map<String, Object> createMapFromJsonString(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    /**
     * return a json string from an Object
     *
     * @param obj - Bean Object
     * @return String
     */
    public static String toJsonString(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * return a map generated from Object
     *
     * @param obj Bean Object
     * @return Map
     */
    public static Map<String, Object> toJsonMap(Object obj) {
        return createMapFromJsonString(toJsonString(obj));
    }
}
