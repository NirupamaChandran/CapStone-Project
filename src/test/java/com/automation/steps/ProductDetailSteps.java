package com.automation.steps;

import com.automation.pages.interfaces.ProductDetailPage;
import com.automation.pages.mobile.MobileProductDetailPage;
import com.automation.pages.web.WebProductDetailPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailSteps {

    ProductDetailPage productDetailPage;

    public ProductDetailSteps() {
        if (ConfigReader.getConfigValue("platform").equals("Web")) {
            productDetailPage = new WebProductDetailPage();
        } else {
            productDetailPage = new MobileProductDetailPage();
        }
    }

    @Then("verify whether product detail page is displayed")
    public void verifyWhetherProductDetailPageIsDisplayed() {
        Assert.assertTrue(productDetailPage.isTheClickedProductDisplayed());
    }

    @And("user clicks add to cart button")
    public void userClicksAddToCartButton() {
        productDetailPage.clickAddToCart();
    }


    @Then("verify cart count is {string}")
    public void verifyCartCountIs(String count) {
        Assert.assertEquals(count, productDetailPage.verifyCartCount());
    }

    @And("user click cart icon")
    public void userClickCartIcon() {
        productDetailPage.clickCartIcon();
    }

    @And("user selects size {string} of the product")
    public void userSelectsSizeOfTheProduct(String key) throws InterruptedException {
        productDetailPage.selectSize(key);
        Thread.sleep(3000); //Due to the behaviour of the page
    }

    @When("user clicks more product info")
    public void userClicksMoreProductInfo() {
        productDetailPage.clickMoreProductInfo();
    }

    @Then("verify product info is displayed")
    public void verifyProductInfoIsDisplayed() {
        Assert.assertTrue(productDetailPage.isProductInfoDisplayed());
    }

    @When("user clicks visit store button")
    public void userClicksVisitStoreButton() {
        productDetailPage.clickVisitStore();
    }

    @When("user clicks similar products icon from product image")
    public void userClicksSimilarProductsIconFromProductImage() {
        productDetailPage.clickSimilarProductsIcon();
    }

    @And("click view all products button")
    public void clickViewAllProductsButton() {
        productDetailPage.clickViewAllProducts();
    }


    @Then("verify success message is displayed")
    public void verifyTextIsDisplayed() {
        String message;
        if (ConfigReader.getConfigValue("platform").equals("Web")) {
            message = ConfigReader.getConfigValue("web.success");
        } else {
            message = ConfigReader.getConfigValue("mobile.success");
        }
        Assert.assertEquals(message, productDetailPage.isSuccessMsgDisplayed());
    }
}
