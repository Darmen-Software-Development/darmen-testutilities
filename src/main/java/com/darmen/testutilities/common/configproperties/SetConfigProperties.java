package com.darmen.testutilities.common.configproperties;

import com.darmen.testutilities.customexceptions.AutomationCommonsRuntimeException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static com.darmen.testutilities.common.utils.CommonUtils.outputToConsole;

/**
 * This Class will contain the SetConfigurations methods
 * @author scottshea
 * @version 1.0
 * @since 1.0
 */
public class SetConfigProperties {
    private static final String PROPERTY_FILE_PATH = SetConfigProperties.class.getClassLoader().getResource("config.properties").getPath();

    /**
     * Reads the config.properties file in the default location of test.resources folder and then sets system properties for running tests
     */
    public SetConfigProperties() throws IOException {
        setSystemProperties(PROPERTY_FILE_PATH);
    }

    /**
     * Specify specific path inside the test.resources folder to set system properties
     *
     * @param propFilePath this.getClass().getClassLoader().getResource("specialConfigLocation/specialConfig.properties").getPath();
     */
    public SetConfigProperties(String propFilePath) throws IOException {
        setSystemProperties(propFilePath);
    }

    /**
     * @param filePath
     * @return
     */
    private Properties getAllPropertyKeysFromFile(String filePath) throws IOException {
        // Get all the property keys from the property file

        Properties properties = new Properties();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
            properties.load(reader);
        } catch (FileNotFoundException fileNotFoundException) {
            outputToConsole(String.valueOf(fileNotFoundException.getStackTrace()));
        }

        return properties;
    }

    /**
     * Read the properties file and set system properties if those values have not be set at runtime
     *
     * @param filePath File name and path
     *                 EXAMPLE: this.getClass().getClassLoader().getResource("config.properties").getPath();
     */
    private void setSystemProperties(String filePath) throws IOException {
        Properties properties = getAllPropertyKeysFromFile(filePath);

        // Set all properties values as system properties if values are not set at runtime.
        for (Map.Entry<Object, Object> property : properties.entrySet()) {
            String propertyKey = property.getKey().toString();
            setSystemPropertyIfNull(propertyKey, getPropertyValue(properties, propertyKey));
        }
    }

    /**
     * Sets the system property to the property from the properties file only if system property was null
     *
     * @param property Property key
     * @param value    Property value
     */
    private void setSystemPropertyIfNull(String property, String value) {
        if (System.getProperty(property) == null) {
            System.setProperty(property, value);
        }
    }

    /**
     * Gets the property from the properties file
     *
     * @param properties Properties
     * @param property Property
     * @return The property value from the config.properties file
     */
    public String getPropertyValue(Properties properties, String property) {
        String theProperty = properties.getProperty(property);
        if (theProperty != null) {
            return theProperty;
        }
        throw new AutomationCommonsRuntimeException(property + " not specified in the properties file.");
    }
}

