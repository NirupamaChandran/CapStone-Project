package com.automation.steps;

import com.automation.pages.interfaces.HomePage;
import com.automation.pages.mobile.MobileHomePage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HomeSteps {
    HomePage homePage;

    public HomeSteps() {
        if (ConfigReader.getConfigValue("platform").equals("Web")) {
            homePage = new WebHomePage();
        } else {
            homePage = new MobileHomePage();
        }
    }


    @Given("user opens website")
    public void user_opens_website() {
        homePage.openWebsite();
        homePage.closePopUp();
    }

    @Then("verify user is on homepage")
    public void verify_user_is_on_homepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user selects adidas from Footwear in brands menu")
    public void userSelectsAdidasFromFootwearInBrandsMenu() {
        homePage.chooseBrand();
    }

    @When("user select Shirts from Men's fashion in Categories")
    public void userSelectShirtsFromMensSFashionInCategories() {
        homePage.searchCategory();
    }

    @When("user search an item {string} in search bar")
    public void userSearchAnItemInSearchBar(String key) {
        if (key.contains(".")) {
            homePage.searchItem(ConfigReader.getConfigValue(key));
        } else {
            homePage.searchItem(key);
        }
    }


    @Then("verify user is in home page")
    public void verifyUserIsInHomePage() {
        homePage.isHomePageDisplayed();
    }

    @When("user clicks tata cliq luxury from home page")
    public void userClicksTataCliqLuxuryFromHomePage() {
        homePage.clickTataLuxury();
    }

    @Then("verify tata cliq luxury site is displayed")
    public void verifyTataCliqLuxurySiteIsDisplayed() {
        Assert.assertTrue(homePage.isLuxuryPageTitleDisplayed());
    }
}
