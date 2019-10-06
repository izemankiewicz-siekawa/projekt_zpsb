package com.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Random;

public class BasePage {

    public BasePage(final WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static WebDriver driver;
    private static final String HOME_URL = "http://automationpractice.com/index.php";
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public void openHomePage() {
        driver.get(HOME_URL);
    }

    public void waitForElementToBeClickable(int timeInSeconds, WebElement elementToClick) throws NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        } catch (Exception e) {
            logger.error("Couldn't click on element: " + elementToClick + "! Sorry...");
        }
    }

    public void waitForElementToBeVisible(int timeInSeconds, WebElement elementToBeVisible) throws NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(elementToBeVisible));
        } catch (Exception e) {
            logger.error("Element wasn't visible: " + elementToBeVisible + "! Sorry...");
        }
    }

    public boolean isDisplayed(int timeInSeconds, WebElement elementToBeDisplayed) throws NoSuchElementException, WebDriverException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(elementToBeDisplayed));
            return elementToBeDisplayed.isDisplayed();
        } catch (Exception e) {
            logger.error("Couldn't display element: " + elementToBeDisplayed + "! Sorry...");
            return false;
        }
    }

    public void selectFromDropdownByIntValue(int value, WebElement elementName) {
        Select dropdown = new Select(elementName);
        dropdown.selectByIndex(value);
    }

    public void selectFromDropdownByStringValue(String textValue, WebElement elementName) {
        Select dropdown = new Select(elementName);
        dropdown.selectByVisibleText(textValue);
    }

    public int randomValue(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    //This method is just for testing purpose, it shouldn't be used in development environment//
    public void sleep() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}