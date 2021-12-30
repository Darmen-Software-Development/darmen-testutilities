package com.darmen.testutilities.ui;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.darmen.testutilities.common.utils.CommonUtils.pause;

/**
 * The DarmenWebDriver class wraps The Selenium WebDriver to simplify tests that need waits or other actions combined with
 * the traditional WebDriver actions.
 *
 * @author  Scott Shea
 * @version 1.0
 * @since   2020-04-13
 */

public class DarmenWebDriver {
    public static final int DEFAULT_WAIT_TIME = 45;
    public static final int NEW_TAB_WAIT_TIME = 250;
    public static final int NEW_TAB_RETRY_ATTEMPTS = 25;
    public static final int TAB_LOAD_WAIT_TIME = 1000;

    private WebDriver driver;
    private WebDriverWait wait;
    private String mainWindow;

    public DarmenWebDriver(WebDriver aDriver) {
        this.driver = aDriver;
        wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
    }

    /**
     * Waits a custom amount of time for an element to be displayed
     *
     * @param locator          - location of the element
     * @param timeOutInSeconds - time to wait in seconds
     */
    public void waitForElementToBeDisplayed(By locator, long timeOutInSeconds) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be displayed
     *
     * @param locator - location of the element
     */
    public void waitForElementToBeDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits a custom amount of time for an element to NOT be displayed
     *
     * @param locator        - location of the element
     * @param timeoutSeconds - time to wait in seconds
     */
    public void waitForElementToNotBeDisplayed(By locator, long timeoutSeconds) {
        wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.invisibilityOf(getElement(locator)));
    }

    /**
     * Waits for an element to NOT be displayed
     *
     * @param locator - location of the element
     */
    public void waitForElementToNotBeDisplayed(By locator) {
        wait.until(ExpectedConditions.invisibilityOf(getElement(locator)));
    }

    /**
     * Checks to see if an element is displayed
     *
     * @param locator - location of the element
     */
    public boolean isElementDisplayed(By locator) {
        return isElementDisplayed(getElement(locator));
    }

    /**
     * Checks to see if an element is displayed
     *
     * @param element - the desired webElement
     */
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

    /**
     * Checks to see if text is displayed on the page
     *
     * @param text - the text to check for
     */
    public boolean isTextDisplayed(String text) {
        return getElement(By.tagName("body")).getText().contains(text);
    }

    /**
     * Finds a desired element
     */
    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Finds all desired elements
     */
    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Mouseover element to display tool tips or dropdown
     */
    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * MouseOver element to display tool tips or dropdown
     *
     * @param locator -
     */
    public void hoverOverElement(By locator) {
        hoverOverElement(getElement(locator));
    }

    /**
     * Inputs text in a text field
     *
     * @param locator - location of the element
     * @param text    - the text that will be entered in the field
     */
    public void type(By locator, String text) {
        type(getElement(locator), text);
    }

    /**
     * Inputs text in a text field
     *
     * @param element - the desired webelement
     * @param text    - the text that will be entered in the field
     */
    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Clears a field of text and then types
     *
     * @param locator - location of the element
     * @param text    - the text that will be entered in the field
     */
    public void clearThenType(By locator, String text) {
        clearThenType(getElement(locator), text);
    }

    /**
     * Clears a field of text and then types
     *
     * @param element - the desired webelement
     * @param text    - the text that will be entered in the field
     */
    public void clearThenType(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Executes Javascript in the browser
     *
     * @param javascript - the javascript command
     * @param args       - The arguments to the script
     */
    public Object executeJavascript(String javascript, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(javascript, args);
    }

    /**
     * Executes Javascript in the browser
     *
     * @param javascript - the javascript command
     * @param args       - The arguments to the script
     */
    public Object executeAsyncJavaScript(String javascript, Object... args) {
        return ((JavascriptExecutor) driver).executeAsyncScript(javascript, args);
    }

    /**
     * Clicks on an element
     *
     * @param locator - location of the element
     */
    public void click(By locator) {
        waitAndClick(locator);
    }

    /**
     * click on an element
     *
     * @param element - WebElement
     */
    public void click(WebElement element) {
        waitAndClick(element);
    }

    /**
     * Drags and drops an element onto another element
     *
     * @param fromLocator - the location of the element to drag
     * @param toLocator   - the location of the element to drop
     */
    public void dragAndDrop(By fromLocator, By toLocator) {
        dragAndDropElement(getElement(fromLocator), getElement(toLocator));
    }

    /**
     * Drags and drops an element unto another element
     *
     * @param fromElement - the element to drag
     * @param toElement   - the element to drop
     */
    public void dragAndDropElement(WebElement fromElement, WebElement toElement) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release()
                .build()
                .perform();
    }

    /**
     * Selects an option from a dropdown
     *
     * @param locator - location of the element
     * @param option  - name of the option to be selected
     */
    public void select(By locator, String option) {
        select(getElement(locator), option);
    }

    /**
     * Selects an option from a dropdown
     *
     * @param element - the desired webelement
     * @param option  - name of the option to be selected
     */
    public void select(WebElement element, String option) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option);
    }

    /**
     * Refreshes the page
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Navigates back in the browser
     */
    public void goBack() {
        driver.navigate().back();
    }

    /**
     * Navigates forward in the browser
     */
    public void goForward() {
        driver.navigate().forward();
    }

    /**
     * Get the current url
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void setWindowSize(int xWidth, int yHeight) {
        driver.manage().window().setSize(new Dimension(xWidth, yHeight));
    }

    /**
     * Clicks the Ok on an alert popup message and returns focus to main window
     * TODO:: Verify other browser besides Chrome
     */
    public void acceptBrowserAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept(); // for OK
        this.switchFocusToMainFrame();
    }

    /**
     * Return focus back to the main frame after focused on iframe
     */
    public void switchFocusToMainFrame() {
        driver.switchTo().defaultContent();
    }

    /**
     * Switches to a iFrame
     *
     * @param frameElement the iFrame webelement to switch to
     */
    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    /**
     * Switches to a iFrame using the frame name or id
     *
     * @param frameNameOrId the name or id of the iFrame to switch to
     */
    public void switchToFrame(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }

    /**
     * Switches to a iFrame using the index
     *
     * @param frameIndex the iFrame index to switch to
     */
    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    /**
     * Set the main window so we can return to this window later
     */
    public void setMainWindow() {
        mainWindow = getCurrentWindow();
    }

    public String getMainWindow() {
        return this.mainWindow;
    }

    /**
     * Gets a list of window handles
     */
    public List<String> getWindowList() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    /**
     * Gets current window handle
     */
    public String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    /**
     * Switch to window
     *
     * @param window window handle or window name?
     */
    public void switchToWindow(String window) {
        driver.switchTo().window(window);
    }

    /**
     * Switches back to the mainWindow
     */
    public void switchBackToMain() {
        driver.switchTo().window(getMainWindow());
    }

    /**
     * Switches to the newest tab
     */
    public void switchToLatestTab() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(getWindowList());
        String latestTab = tabs.get(tabs.size() - 1);
        driver.switchTo().window(latestTab);
        pause(TAB_LOAD_WAIT_TIME); // we sleep for one second for tab loading time
    }

    /**
     * Gets the page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Gets the text of an element
     *
     * @param locator - location of the element
     */
    public String getText(By locator) {
        return getElement(locator).getText();
    }

    /**
     * Gets the text of an element
     *
     * @param element - the desired webelement
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Gets the attribute text of an element
     *
     * @param element   - the desired webElement
     * @param attribute - attribute text to return
     */
    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /**
     * Gets the attribute text of an element
     *
     * @param locator   - the desired webElement
     * @param attribute - attribute text to return
     */
    public String getAttribute(By locator, String attribute) {
        return getAttribute(getElement(locator), attribute);
    }

    /**
     * Gets the inner text attribute of an element
     *
     * @param element - the desired webElement
     */
    public String getInnerText(WebElement element) {
        return getAttribute(element, "innerText");
    }

    /**
     * Gets the inner text attribute of an element
     *
     * @param locator - location of the element
     */
    public String getInnerText(By locator) {
        return getAttribute(locator, "innerText");
    }

    /**
     * Gets the value attribute of an element
     *
     * @param element - the desired webelement
     */
    public String getValue(WebElement element) {
        return getAttribute(element, "value");
    }

    /**
     * Gets the value attribute of an element
     *
     * @param locator - location of the element
     */
    public String getValue(By locator) {
        return getAttribute(locator, "value");
    }

    /**
     * Gets the text of a group of elements with a single locator
     *
     * @param locator - Location of the element
     * @return list of strings from a group of elements
     */
    public List<String> getTextFromListOfElements(By locator) {
        List<String> list = new ArrayList<>();
        for (WebElement element : getElements(locator)) {
            list.add(element.getText());
        }
        return list;
    }

    /**
     * Opens a URL
     *
     * @param url - the desired url
     */
    public void openURL(String url) {
        driver.get(url);
    }

    /**
     * wait for an element to be click
     *
     * @param locator
     */
    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * check to see if element is clickable
     *
     * @param locator By
     * @return boolean isElementClickable
     */
    public boolean isElementClickable(By locator) {
        boolean clickable = false;

        if (ExpectedConditions.elementToBeClickable(locator) != null) {
            clickable = true;
        }
        return clickable;
    }

    /**
     * wait for an element to be clickable
     *
     * @param element
     */
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Gets all the options for a Select element
     *
     * @param locator - the locator of the Select element
     */
    public List<String> getSelectOptions(By locator) {
        List<WebElement> options = new Select(getElement(locator)).getOptions();
        List<String> labels = new ArrayList<>();
        for (WebElement element : options) {
            String elementName = element.getText();
            labels.add(elementName);
        }
        return labels;
    }

    /**
     * Gets the displayed selected option for a Select element
     *
     * @param locator - the locator of the Select element
     */
    public String getDisplayedSelectOption(By locator) {
        return new Select(getElement(locator)).getFirstSelectedOption().getText();
    }

    /**
     * Waits for five seconds for the new tab to appear
     */
    public void waitForNewTab() throws InterruptedException {
        int i = 0;
        while (getWindowList().size() == 1 && i < NEW_TAB_RETRY_ATTEMPTS) {
            /* Wait for file to open in new tab */
            pause(NEW_TAB_WAIT_TIME);
            i++;
        }
    }

    /************
     * Privates *
     ************/

    /**
     * wait for something and then click it
     * you should use click()
     *
     * @param locator
     */
    private void waitAndClick(By locator) {
        waitForElementToBeClickable(locator);
        getElement(locator).click();
    }

    /**
     * wait for something and then click it
     * you should use click
     *
     * @param element
     */
    private void waitAndClick(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }
}

