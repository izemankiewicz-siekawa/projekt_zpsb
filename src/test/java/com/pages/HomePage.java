package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement searchField;

    @FindBy(how = How.CLASS_NAME, using = "button-search")
    private WebElement searchButton;

    @FindBy(how = How.CLASS_NAME, using = "heading-counter")
    private WebElement resultHeader;

    public void inputTextToSearchField(String text) {
        searchField.sendKeys(text);
    }

    public void searchButtonClick() {
        searchButton.click();
    }

    public String getTextFromCounterHeader() {
        return resultHeader.getText().toLowerCase();
    }
}