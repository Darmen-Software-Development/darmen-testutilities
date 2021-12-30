package com.darmen.utilities.unittests.common;

import com.darmen.testutilities.common.configproperties.SetConfigProperties;
import com.darmen.testutilities.customexceptions.AutomationCommonsRuntimeException;

import com.darmen.utilities.unittests.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class ConfigPropertiesTests extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigPropertiesTests.class);
    private static final String NULLABLE_URL_PROPERTY = "automation.nullable.url";

    @AfterMethod
    public void cleanUpFiles() {
        try {
            deleteDirectory(new File("build/reports/functionalTests"));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Test
    public void defaultConfigPropertiesLocation() throws IOException {
        new SetConfigProperties();
        assertEquals(System.getProperty("automation.commons.url"), "https://example.com/");
        assertEquals(System.getProperty("automation.commons.token"), "jwttokenhere");
    }

    @Test
    public void specialConfigPropertiesLocation() throws IOException {
        String specialPath = this.getClass().getClassLoader().getResource("specialConfigLocation/specialConfig.properties").getPath();
        new SetConfigProperties(specialPath);

        assertEquals(System.getProperty("automation.special.url"), "https://youAreSpecial.com/");
        assertEquals(System.getProperty("automation.special.token"), "specialJWT");
    }

    /**
     * Test that this throws a Null Pointer exception
     */
    @Test(expectedExceptions = { IOException.class, NullPointerException.class })
    public void getAllPropertyKeysFromFileFileNotFound() throws IOException {
        String badPath = this.getClass().getClassLoader().getResource("doesNotExist.properties").getPath();
        new SetConfigProperties(badPath);

        Assert.assertTrue("This did not throw a".equals(" null pointer exception"), "This test should have thrown a null pointer");
    }

    @Test
    public void setSystemPropertyIfNullNotNullProperty() throws IOException {
        System.setProperty(NULLABLE_URL_PROPERTY, "ImNotNullDoNotOverwriteMe");
        String nullablePath = this.getClass().getClassLoader().getResource("specialConfigLocation/nullableConfig.properties").getPath();
        new SetConfigProperties(nullablePath);

        assertNotEquals(System.getProperty(NULLABLE_URL_PROPERTY), "https://youAreSpecial.com/");
        assertEquals(System.getProperty(NULLABLE_URL_PROPERTY), "ImNotNullDoNotOverwriteMe");
        assertEquals(System.getProperty("automation.nullable.token"), "nullableJWT");
    }

    @Test(expectedExceptions = { AutomationCommonsRuntimeException.class })
    public void getPropertyValueNull() throws IOException {
        SetConfigProperties scp = new SetConfigProperties();
        Properties properties = new Properties();

        scp.getPropertyValue(properties, "");
    }
}
