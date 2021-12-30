package com.darmen.utilities.unittests.api;

import com.darmen.testutilities.api.JsonUtil;
import com.darmen.testutilities.api.ObjectUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.darmen.testutilities.api.JsonUtil.createJson;
import static com.darmen.testutilities.api.JsonUtil.createMapFromJsonString;
import static com.darmen.testutilities.api.JsonUtil.toJsonMap;
import static com.darmen.testutilities.api.JsonUtil.toJsonString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JsonUtilTest {
    private static final int OBJECT_COUNT = 5083;

    @Test(description = "Tests report data for event listener and data provider", dataProvider = "listener")
    public void listenerStuff(String blah) {
        assertEquals(1, 1);
    }

    @Test(description = "Test createJson method")
    public void createJsonTest() {
        Map<String, Object> createMap = new HashMap<>();
        createMap.put("Test", "Test1234");
        String json = createJson(createMap);
        assertEquals(json, "{\"Test\":\"Test1234\"}");
    }

    @Test(description = "Test createMapFromJsonString method")
    public void createMapFromJsonStringTest() {
        String jsonString = "{\"Test\":\"Test1234\"}";
        Map<String, Object> returnJson;
        returnJson = createMapFromJsonString(jsonString);
        assertTrue(returnJson.containsKey("Test"));
        assertEquals(returnJson.get("Test"), "Test1234");
    }

    @Test(description = "Test toJsonString method")
    public void toJsonStringTest() {
        JsonTestObject toJsonStringObject = new JsonTestObject();
        toJsonStringObject.setName("Test");
        toJsonStringObject.setCount(OBJECT_COUNT);
        toJsonStringObject.setActive(false);

        String returnJson = toJsonString(toJsonStringObject);
        assertEquals(returnJson, "{\"name\":\"Test\",\"count\":5083,\"active\":false}");
    }

    @Test(description = "Test toJsonMap method")
    public void toJsonMapTest() {

        JsonTestObject toJsonStringObject = new JsonTestObject();
        toJsonStringObject.setName("Test");
        toJsonStringObject.setCount(OBJECT_COUNT);
        toJsonStringObject.setActive(true);

        // WHY?! Because the GSON library converts ints to doubles
        Double objectCount = Double.valueOf(OBJECT_COUNT);

        Map<String, Object> returnedMap = toJsonMap(toJsonStringObject);

        assertTrue(returnedMap.containsKey("name"));
        assertTrue(returnedMap.containsKey("count"));
        assertTrue(returnedMap.containsKey("active"));

        assertEquals(returnedMap.get("name"), "Test");
        assertEquals(returnedMap.get("count"), objectCount);
        assertEquals(returnedMap.get("active"), true);
    }

    @DataProvider(name = "listener")
    private Object[][] data() {
        return new Object[][]{
                {"hello"},
                {"world"}
        };
    }

}

class JsonTestObject extends ObjectUtil {
    private String name;
    private Integer count;
    private Boolean active;

    public String getName() {
        return name;
    }

    public JsonTestObject setName(String name) {
        this.name = name;

        return this;
    }

    public Integer getCount() {
        return count;
    }

    public JsonTestObject setCount(Integer count) {
        this.count = count;

        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public JsonTestObject setActive(Boolean active) {
        this.active = active;

        return this;
    }
}
