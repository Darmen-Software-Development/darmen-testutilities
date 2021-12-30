# README for Darmen Test Utilities

## Overview
Parent library used for Api Commons that have common methods for UI and API based testing as well as any other shared
methods for other common libraries. It is designed to be a dependency and imported into the application to
support rapid functional test writing

## Getting Started

Make sure all the prerequisites listed below are installed. Clone the project locally using git from 
[Github](https://url.com) and then perform a `gradle clean build`.

### Prerequisites
#### External
* git
* Java 1.8
* Gradle
* IDE (IntelliJ, Eclipse, Atom, etc.)


### Running Locally

This library is not designed to run independently on a system. Rather it is designed to be consumed by a test project.
As such the following sections give examples on how to integrate it within the test project.

#### Properties file
Create a config.properties file inside your test resources package
These properties are used to set things like the base url '*automation.projectName.url*', web url
'*automation.projectName.webUrl*' and jwt token '*automation.projectName.token*'

here is an example of config.properties might look like for a selenium project that uses service project where web url
is for selenium and url is for the api calls.

__EXAMPLE:__
``````
automation.commons.weburl=https://websiteUrlHere.com/
automation.commons.url=https://apiBaseUrlHere.com/
automation.commons.token=jwttokenhere
``````

in the TestBase paste this code to set system properties using this file

`````` 
   /**
     * Sets the config.properties values as system property values
     */
    @BeforeSuite
    public void setConfigs() {
        setConfigProperties = new SetConfigProperties();
    }

    public void assertEquals(String valueOne, String valueTwo) {
        Assert.assertEquals(valueOne, valueTwo, "Value one: " + valueOne + ", did not equal value two: " + valueTwo);
    }

    public void assertNotEquals(String valueOne, String valueTwo) {
        Assert.assertNotEquals(valueOne, valueTwo, "Value one: " + valueOne + ", incorrectly equals value two: " + valueTwo);
    }

    public void assertContains(String valueOne, String valueTwo) {
        Assert.assertTrue(valueOne.contains(valueTwo), "Value one: " + valueOne + ", did not contain value two: " + valueTwo);
    }

    public void assertDoesNotContain(String valueOne, String valueTwo) {
        Assert.assertFalse(valueOne.contains(valueTwo), "Value one: " + valueOne + ", incorrectly contained value two: " + valueTwo);
    }


``````

- - - - 
#### Listeners
TestNG listeners are used for adding additional effects to a test, such as, repeating failed tests.

#### Retry:
By default using this Listener will run a test 3 times if it fails.
Tests will be marked as Skipped until the 3rd run of the test where it will be marked as Pass or Fail.
The Listener does not really work through the IDE.

To Change the number of retries set the System Property '*retryCount*'
 ```groovy
//in the build.gradle file
//inside a test task
useTestNG(){
        options {
            listeners << 'com.darmen.testautomation.common.listener.RetryListener'
        }
    }
```

## Tests

### Unit Tests
Unit tests were written with TestNG and can be executed by `gradle clean test`

## Deployment
As this is a dependency used for testing it is not recommended to use in a production environment

## Versioning
This library follows the "N.n-Snapshot" versioning format 

