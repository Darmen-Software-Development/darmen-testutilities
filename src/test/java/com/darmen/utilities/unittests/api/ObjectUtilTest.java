package com.darmen.utilities.unittests.api;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ObjectUtilTest {
    private JsonTestObject testObject;
    private static final String NAME = "test";
    private static final int COUNT = 5;
    private static final boolean ACTIVE = true;
    private static final String EXPECTED_JSON =
            String.format("{\"name\":\"%s\",\"count\":%s,\"active\":%s}", NAME, COUNT, ACTIVE);

    @BeforeMethod
    public void initialize() {
        testObject = new JsonTestObject();
        testObject.setName(NAME).setCount(COUNT).setActive(ACTIVE);
    }

    @Test
    public void toJson() {
        String actualJson = testObject.toJson();
        assertEquals(actualJson, EXPECTED_JSON);
    }

    @Test
    public void toMap() {
        Map<String, Object> actualMap = testObject.toMap();
        assertEquals(actualMap.get("name"), NAME);
        assertEquals(actualMap.get("count"), Double.valueOf(COUNT));
        assertEquals(actualMap.get("active"), ACTIVE);
    }
}
