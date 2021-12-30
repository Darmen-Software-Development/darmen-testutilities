package com.darmen.utilities.unittests.ui;

import com.darmen.testutilities.ui.DarmenWebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Quotes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class DarmenWebDriverTests {
    private static final boolean EXPECTED_TRUE = true;
    private static final String TEST_URL = "https://notaurl.com";
    private static final String WINDOW_HANDLE = "testWindowHandle";
    private static final String WINDOW_HANDLE_2 = "testWindowHandle2";
    private static final String PAGE_TITLE = "testPageTitle";
    private static final String ELEMENT_TEXT = "testElementText";
    private static final List<String> ELEMENT_LIST_TEXT = Arrays.asList(ELEMENT_TEXT);
    private static final String ATTRIBUTE = "testAttribute";
    private static final String VALUE = "testValue";
    private static final String FRAME_NAME_OR_ID = "testNameOrId";
    private static final int FRAME_INDEX = 42;
    private static final int FIVE = 5;
    private static final long WAIT_TIMEOUT = 1000;

    private WebDriver mockDriver;
    private WebElement mockWebElement;
    private WebElement mockWebElement2;
    private By mockBy;
    private List<WebElement> mockElementList;
    private WebDriver.Navigation mockNavigation;
    private WebDriver.Options mockOptions;
    private WebDriver.Window mockWindow;
    private WebDriver.TargetLocator mockTargetLocator;
    private Alert mockAlert;

    private Set<String> windowHandleSet;


    private DarmenWebDriver darmenWebDriver;

    @BeforeMethod
    public void setup() {
        this.mockDriver = mock(WebDriver.class);
        this.mockWebElement = mock(WebElement.class);
        this.mockWebElement2 = mock(WebElement.class);
        this.mockBy = mock(By.class);
        this.mockNavigation = mock(WebDriver.Navigation.class);
        this.mockOptions = mock(WebDriver.Options.class);
        this.mockWindow = mock(WebDriver.Window.class);
        this.mockTargetLocator = mock(WebDriver.TargetLocator.class);
        this.mockAlert = mock(Alert.class);

        darmenWebDriver = new DarmenWebDriver(mockDriver);
    }

    @Test
    public void isElementDisplayedByElement() {
        when(mockWebElement.isDisplayed()).thenReturn(true);
        boolean actual = darmenWebDriver.isElementDisplayed(mockWebElement);

        assertEquals(actual, EXPECTED_TRUE);
    }

    @Test
    public void isElementDisplayedByLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.isDisplayed()).thenReturn(true);
        boolean actual = darmenWebDriver.isElementDisplayed(mockBy);

        assertEquals(actual, EXPECTED_TRUE);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void isElementDisplayedNoSuchElementException() {
        when(mockWebElement.isDisplayed()).thenThrow(NoSuchElementException.class);
        darmenWebDriver.isElementDisplayed(mockWebElement);
    }

    @Test
    public void testIsTextDisplayed() {
        when(mockDriver.findElement(By.tagName("body"))).thenReturn(mockWebElement);
        when(mockWebElement.getText()).thenReturn(ELEMENT_TEXT);

        boolean actual = darmenWebDriver.isTextDisplayed(ELEMENT_TEXT);

        assertEquals(actual, EXPECTED_TRUE);
    }

    @Test
    public void getElementByLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        WebElement expectedWebElement = darmenWebDriver.getElement(mockBy);

        assertEquals(expectedWebElement, mockWebElement);
    }

    @Test
    public void getElementListByLocator() {
        mockElementList = Arrays.asList(mockWebElement, mockWebElement);
        when(mockDriver.findElements(mockBy)).thenReturn(mockElementList);

        List<WebElement> expectedWebElementList = darmenWebDriver.getElements(mockBy);

        assertEquals(expectedWebElementList, mockElementList);
    }

    @Test
    public void testGetCurrentUrl() {
        when(mockDriver.getCurrentUrl()).thenReturn(TEST_URL);

        String actualUrl = darmenWebDriver.getCurrentUrl();

        assertEquals(actualUrl, TEST_URL);
    }

    @Test
    public void testGetCurrentWindow() {
        when(mockDriver.getWindowHandle()).thenReturn(WINDOW_HANDLE);

        String actual = darmenWebDriver.getCurrentWindow();

        assertEquals(actual, WINDOW_HANDLE);
    }

    @Test
    public void testSetCurrentWindow() {
        String uniqueWindowHandle = WINDOW_HANDLE + System.currentTimeMillis();
        when(mockDriver.getWindowHandle()).thenReturn(uniqueWindowHandle);

        darmenWebDriver.setMainWindow();

        String actual = darmenWebDriver.getMainWindow();

        assertEquals(actual, uniqueWindowHandle);
    }

    @Test
    public void testGetWindowList() {
        windowHandleSet = new HashSet<>(Arrays.asList(WINDOW_HANDLE, WINDOW_HANDLE));
        when(mockDriver.getWindowHandles()).thenReturn(windowHandleSet);

        List<String> actual = darmenWebDriver.getWindowList();

        assertEquals(actual, new ArrayList<>(windowHandleSet));
    }

    @Test
    public void testGetPageTitle() {
        when(mockDriver.getTitle()).thenReturn(PAGE_TITLE);

        String actual = darmenWebDriver.getPageTitle();

        assertEquals(actual, PAGE_TITLE);
    }

    @Test
    public void getTextWithElement() {
        when(mockWebElement.getText()).thenReturn(ELEMENT_TEXT);

        String actual = darmenWebDriver.getText(mockWebElement);

        assertEquals(actual, ELEMENT_TEXT);
    }

    @Test
    public void getTextWithLocator() {
        when(mockWebElement.getText()).thenReturn(ELEMENT_TEXT);
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);

        String actual = darmenWebDriver.getText(mockBy);

        assertEquals(actual, ELEMENT_TEXT);
    }

    @Test
    public void testGetTextFromListOfElements() {
        mockElementList = Arrays.asList(mockWebElement);
        when(mockWebElement.getText()).thenReturn(ELEMENT_TEXT);
        when(mockDriver.findElements(mockBy)).thenReturn(mockElementList);

        List<String> actual = darmenWebDriver.getTextFromListOfElements(mockBy);

        assertEquals(actual, ELEMENT_LIST_TEXT);

    }

    @Test
    public void getValueByElement() {
        when(mockWebElement.getAttribute("value")).thenReturn(VALUE);

        String actual = darmenWebDriver.getValue(mockWebElement);

        assertEquals(actual, VALUE);
    }

    @Test
    public void getValueByLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.getAttribute("value")).thenReturn(VALUE);

        String actual = darmenWebDriver.getValue(mockBy);

        assertEquals(actual, VALUE);
    }

    @Test
    public void getAttributeByElement() {
        when(mockWebElement.getAttribute(ATTRIBUTE)).thenReturn(VALUE);

        String actual = darmenWebDriver.getAttribute(mockWebElement, ATTRIBUTE);

        assertEquals(actual, VALUE);
    }

    @Test
    public void getAttributeByElementLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.getAttribute(ATTRIBUTE)).thenReturn(VALUE);

        String actual = darmenWebDriver.getAttribute(mockWebElement, ATTRIBUTE);

        assertEquals(actual, VALUE);
    }

    @Test
    public void getInnerTextByElement() {
        when(mockWebElement.getAttribute("innerText")).thenReturn(VALUE);

        String actual = darmenWebDriver.getInnerText(mockWebElement);

        assertEquals(actual, VALUE);
    }

    @Test
    public void getInnerTextByLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.getAttribute("innerText")).thenReturn(VALUE);

        String actual = darmenWebDriver.getInnerText(mockBy);

        assertEquals(actual, VALUE);
    }

    /*******************************************
     * Tests for methods that are void returns *
     *******************************************/

    @Test
    public void waitForElementToBeClickableByElement() {
        when(mockWebElement.isDisplayed()).thenReturn(true);
        when(mockWebElement.isEnabled()).thenReturn(true);

        darmenWebDriver.waitForElementToBeClickable(mockWebElement);
    }

    @Test
    public void waitForElementToBeClickableByLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.isDisplayed()).thenReturn(true);
        when(mockWebElement.isEnabled()).thenReturn(true);

        darmenWebDriver.waitForElementToBeClickable(mockBy);
    }

    @Test
    public void testOpenUrl() {
        doNothing().when(mockDriver).get(TEST_URL);

        darmenWebDriver.openURL(TEST_URL);
    }

    @Test
    public void typeByElement() {
        doNothing().when(mockWebElement).sendKeys(ELEMENT_TEXT);

        darmenWebDriver.type(mockWebElement, ELEMENT_TEXT);
    }

    @Test
    public void typeByLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        doNothing().when(mockWebElement).sendKeys(ELEMENT_TEXT);

        darmenWebDriver.type(mockBy, ELEMENT_TEXT);
    }

    @Test
    public void clearThenTypeByElement() {
        doNothing().when(mockWebElement).clear();
        doNothing().when(mockWebElement).sendKeys(ELEMENT_TEXT);

        darmenWebDriver.clearThenType(mockWebElement, ELEMENT_TEXT);
    }

    @Test
    public void clearThenTypeByLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        doNothing().when(mockWebElement).clear();
        doNothing().when(mockWebElement).sendKeys(ELEMENT_TEXT);

        darmenWebDriver.clearThenType(mockBy, ELEMENT_TEXT);
    }

    @Test
    public void testRefreshPage() {
        when(mockDriver.navigate()).thenReturn(mockNavigation);
        doNothing().when(mockNavigation).refresh();

        darmenWebDriver.refreshPage();
    }

    @Test
    public void testGoBack() {
        when(mockDriver.navigate()).thenReturn(mockNavigation);
        doNothing().when(mockNavigation).back();

        darmenWebDriver.goBack();
    }

    @Test
    public void testGoForward() {
        when(mockDriver.navigate()).thenReturn(mockNavigation);
        doNothing().when(mockNavigation).forward();

        darmenWebDriver.goForward();
    }

    @Test
    public void testSetWindowSize() {
        when(mockDriver.manage()).thenReturn(mockOptions);
        when(mockOptions.window()).thenReturn(mockWindow);
        doNothing().when(mockWindow).setSize(new Dimension(FIVE, FIVE));

        darmenWebDriver.setWindowSize(FIVE, FIVE);
    }

    @Test
    public void testSwitchFocusToMainFrame() {
        when(mockDriver.switchTo()).thenReturn(mockTargetLocator);
        when(mockTargetLocator.defaultContent()).thenReturn(mockDriver);

        darmenWebDriver.switchFocusToMainFrame();
    }

    @Test
    public void switchFocusToIFrameElement() {
        when(mockDriver.switchTo()).thenReturn(mockTargetLocator);
        when(mockTargetLocator.frame(mockWebElement)).thenReturn(mockDriver);

        darmenWebDriver.switchToFrame(mockWebElement);
    }

    @Test
    public void switchFocusToIFrameNameOrID() {
        when(mockDriver.switchTo()).thenReturn(mockTargetLocator);
        when(mockTargetLocator.frame(FRAME_NAME_OR_ID)).thenReturn(mockDriver);

        darmenWebDriver.switchToFrame(FRAME_NAME_OR_ID);
    }

    @Test
    public void switchFocusToIFrameNameIndex() {
        when(mockDriver.switchTo()).thenReturn(mockTargetLocator);
        when(mockTargetLocator.frame(FRAME_INDEX)).thenReturn(mockDriver);

        darmenWebDriver.switchToFrame(FRAME_INDEX);
    }

    @Test
    public void testSwitchToWindow() {
        when(mockDriver.switchTo()).thenReturn(mockTargetLocator);
        when(mockTargetLocator.window(WINDOW_HANDLE)).thenReturn(mockDriver);

        darmenWebDriver.switchToWindow(WINDOW_HANDLE);
    }

    @Test
    public void testSwitchBackToMain() {
        when(mockDriver.switchTo()).thenReturn(mockTargetLocator);
        when(mockTargetLocator.window(WINDOW_HANDLE)).thenReturn(mockDriver);
        when(mockDriver.getWindowHandle()).thenReturn(WINDOW_HANDLE);

        darmenWebDriver.switchBackToMain();
    }

    @Test
    public void testAcceptBrowserAlert() {
        when(mockDriver.switchTo()).thenReturn(mockTargetLocator);
        when(mockTargetLocator.alert()).thenReturn(mockAlert);
        doNothing().when(mockAlert).accept();

        darmenWebDriver.acceptBrowserAlert();
    }

    @Test
    public void testSwitchToLatestTab() throws InterruptedException {
        windowHandleSet = new HashSet<>(Arrays.asList(WINDOW_HANDLE, WINDOW_HANDLE));
        when(mockDriver.getWindowHandles()).thenReturn(windowHandleSet);
        when(mockDriver.switchTo()).thenReturn(mockTargetLocator);
        when(mockTargetLocator.window(WINDOW_HANDLE)).thenReturn(mockDriver);

        darmenWebDriver.switchToLatestTab();
    }

    @Test
    public void waitForNewTabMultipleTabs() throws InterruptedException {
        windowHandleSet = new HashSet<>(Arrays.asList(WINDOW_HANDLE, WINDOW_HANDLE_2));
        when(mockDriver.getWindowHandles()).thenReturn(windowHandleSet);

        darmenWebDriver.waitForNewTab();
    }

    @Test
    public void testWaitForNewTabSingleTab() throws InterruptedException {
        windowHandleSet = new HashSet<>(Arrays.asList(WINDOW_HANDLE));
        when(mockDriver.getWindowHandles()).thenReturn(windowHandleSet);

        darmenWebDriver.waitForNewTab();
    }

    @Test
    public void waitForElementToBeDisplayedLocatorAndTime() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.isDisplayed()).thenReturn(EXPECTED_TRUE);

        darmenWebDriver.waitForElementToBeDisplayed(mockBy, WAIT_TIMEOUT);
    }

    @Test
    public void waitForElementToBeDisplayedLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.isDisplayed()).thenReturn(EXPECTED_TRUE);

        darmenWebDriver.waitForElementToBeDisplayed(mockBy);
    }

    @Test
    public void waitForElementToNotBeDisplayedLocatorAndTime() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.isDisplayed()).thenReturn(false);

        darmenWebDriver.waitForElementToNotBeDisplayed(mockBy, WAIT_TIMEOUT);
    }

    @Test
    public void waitForElementToNotBeDisplayedLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.isDisplayed()).thenReturn(false);

        darmenWebDriver.waitForElementToNotBeDisplayed(mockBy);
    }

    @Test
    public void testIsElementClickable() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.isDisplayed()).thenReturn(true);
        when(mockWebElement.isEnabled()).thenReturn(true);

        darmenWebDriver.isElementClickable(mockBy);
    }

    @Test
    public void clickByElement() {
        when(mockWebElement.isDisplayed()).thenReturn(true);
        when(mockWebElement.isEnabled()).thenReturn(true);
        doNothing().when(mockWebElement).click();

        darmenWebDriver.click(mockWebElement);
    }

    @Test
    public void clickByLocator() {
        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.isDisplayed()).thenReturn(true);
        when(mockWebElement.isEnabled()).thenReturn(true);
        doNothing().when(mockWebElement).click();

        darmenWebDriver.click(mockBy);
    }

    @Test
    public void selectByElement() {
        String text = "tag";
        mockElementList = Arrays.asList(mockWebElement2);
        when(mockWebElement.getTagName()).thenReturn("select");
        when(mockWebElement.getAttribute("multiple")).thenReturn("false");
        when(mockWebElement.findElements(By.xpath(".//option[normalize-space(.) = " + Quotes.escape(text) + "]"))).thenReturn(mockElementList);
        when(mockWebElement2.isSelected()).thenReturn(false);
        doNothing().when(mockWebElement2).click();

        darmenWebDriver.select(mockWebElement, text);
    }

    @Test
    public void selectByLocator() {
        String text = "tag";
        mockElementList = Arrays.asList(mockWebElement2);

        when(mockDriver.findElement(mockBy)).thenReturn(mockWebElement);
        when(mockWebElement.getTagName()).thenReturn("select");
        when(mockWebElement.getAttribute("multiple")).thenReturn("false");
        when(mockWebElement.findElements(By.xpath(".//option[normalize-space(.) = " + Quotes.escape(text) + "]"))).thenReturn(mockElementList);
        when(mockWebElement2.isSelected()).thenReturn(false);
        doNothing().when(mockWebElement2).click();

        darmenWebDriver.select(mockBy, text);
    }
}
