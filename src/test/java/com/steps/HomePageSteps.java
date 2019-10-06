package com.steps;

import com.DriverFactory;
import com.pages.HomePage;
import com.pages.base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class HomePageSteps extends DriverFactory {

    private BasePage basePage = new BasePage(driver);
    private HomePage homepage = new HomePage(driver);

    @Given("^I open home page$")
    public void iOpenHomePage() {
        basePage.openHomePage();
    }

    @When("^I write search phrase \"([^\"]*)\"$")
    public void iWriteSearchPhrase(String phrase) {
        homepage.inputTextToSearchField(phrase);
    }

    @And("^I click Search$")
    public void iClickSearch() {
        homepage.searchButtonClick();
    }

    @Then("^I will see that \"([^\"]*)\"$")
    public void iWillSeeThat(String resultText) {
        Assert.assertEquals(resultText.toLowerCase(), homepage.getTextFromCounterHeader());
    }
}