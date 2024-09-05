package com.automation.steps;

import com.automation.pages.interfaces.ProductListPage;
import com.automation.pages.android.AndroidProductListPage;
import com.automation.pages.web.WebProductListPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListSteps {

    ProductListPage productListPage;

    public ProductListSteps() {
        if (ConfigReader.getConfigValue("platform").equals("Web")) {
            productListPage = new WebProductListPage();
        } else {
            productListPage = new AndroidProductListPage();
        }
    }

    @Then("verify whether product {string} list page is displayed")
    public void verifyWhetherProductListPageIsDisplayed(String key) {
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
        Assert.assertTrue(productListPage.isListPageHeadingDisplayed(ConfigReader.getConfigValue(key)));
    }


    @When("user clicks on the first product")
    public void userClicksOnTheFirstProduct() {
        productListPage.clickFirstProduct();
    }


    @Then("verify {string} listing page is displayed")
    public void verifyHeadsetListingPageIsDisplayed(String key) {
        if (key.contains(".")) {
            Assert.assertTrue(productListPage.isItemHeadingDisplayed(ConfigReader.getConfigValue(key)));
        } else {
            Assert.assertTrue(productListPage.isItemHeadingDisplayed(key));
        }
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
    }

    @And("user sort price high to low")
    public void userSortPriceHighToLow() throws InterruptedException {
        productListPage.sortPriceHighToLow();
    }

    @Then("verify whether product list is sorted high to low")
    public void verifyWhetherProductListIsSortedHighToLow() {
        Assert.assertTrue(productListPage.isPriceHighToLowSorted());
    }

    @When("user selects filter by {string} {string}")
    public void userSelectsFilterByBrand(String filterType, String key) throws InterruptedException {
        productListPage.addBrandFilter(ConfigReader.getConfigValue(key), filterType);
    }

    @Then("verify filter {string} is applied")
    public void verifyFilterIsApplied(String key) {
        Assert.assertTrue(productListPage.isBrandFilterApplied(ConfigReader.getConfigValue(key)));
    }

    @When("user clicks on the view icon")
    public void userClicksOnTheViewIcon() {
        productListPage.changeView();
    }

    @Then("verify view has changed")
    public void verifyViewHasChanged() {
        Assert.assertTrue(productListPage.isViewChanged());
    }

    @Then("verify similar products listing page is displayed")
    public void verifySimilarProductsListingPageIsDisplayed() {
        Assert.assertTrue(productListPage.isSimilarProductsDisplayed());
    }

    @When("user clicks give feedback button")
    public void userClicksGiveFeedbackButton() {
        productListPage.clickFeedBack();
    }

    @Then("verify feedback form is displayed")
    public void verifyFeedbackFormIsDisplayed() {
        Assert.assertTrue(productListPage.isFeedBackPageDisplayed());
    }

    @And("user enters feedback and click next")
    public void userEntersFeedbackAndClickNext() {
        productListPage.enterFeedBack();
    }

    @When("user enters text and clicks submit")
    public void userEntersTextAndClicksSubmit() {
        productListPage.submitFeedBack();
    }

    @Then("verify {string} is displayed")
    public void verifyIsDisplayed(String text) {
        Assert.assertEquals(text, productListPage.successMsg());
    }

    @And("user sort price low to high")
    public void userSortPriceLowToHigh() throws InterruptedException {
        productListPage.sortPriceLowToHigh();
    }

    @Then("verify whether product list is sorted low to high")
    public void verifyWhetherProductListIsSortedLowToHigh() {
        Assert.assertTrue(productListPage.isPriceLowToHighSorted());
    }

    @When("user click right shift arrow")
    public void userClickRightShiftArrow() {
        productListPage.clickRightArrow();
    }

    @Then("verify image is changing")
    public void verifyImageIsChanging() {
        Assert.assertTrue(productListPage.verifyImage());
    }

    @Then("verify filter {string} is applied to all products")
    public void verifyFilterIsAppliedToAllProducts(String filter) {
        Assert.assertTrue(productListPage.isDiscountFilterApplied());
    }

    @When("user clicks on the product")
    public void userClicksOnTheProduct() {
//        productListPage.clickProduct();
    }
}
