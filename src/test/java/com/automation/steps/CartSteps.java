package com.automation.steps;

import com.automation.pages.interfaces.CartPage;
import com.automation.pages.mobile.MobileCartPage;
import com.automation.pages.web.WebCartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage;

    public CartSteps() {
        if (ConfigReader.getConfigValue("platform").equals("Web")) {
            cartPage = new WebCartPage();
        } else {
            cartPage = new MobileCartPage();
        }
    }

    @And("verify cart contain the correct item")
    public void verifyCartContainTheCorrectItem() {
        Assert.assertEquals(ConfigReader.getConfigValue("product.name"), cartPage.cartProductTitle());
    }

    @When("user changes the size and quantity of the item")
    public void userChangesTheSizeAndQuantityOfTheItem() throws InterruptedException {
        cartPage.changeSizeAndQuantity();
    }

    @Then("verify the size {string} and quantity is updated")
    public void verifyTheSizeNadQuantityIsUpdated(String key) {
        Assert.assertTrue(cartPage.verifySizeAndQuantityUpdated(ConfigReader.getConfigValue(key)));
    }

    @Then("verify user is on cart page")
    public void verifyUserIsOnCartPage() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @When("user clicks on remove button")
    public void userClicksOnRemoveButton() {
        cartPage.removeItem();
    }

    @Then("verify the item is removed from the cart")
    public void verifyTheItemIsRemovedFromTheCart() {
        Assert.assertTrue(cartPage.isItemRemoved());
    }

    @When("user clicks continue shopping button")
    public void userClicksContinueShoppingButton() {
        cartPage.clickContinueShopping();
    }

    @And("verify the total amount is correct")
    public void verifyTheTotalAmountIsCorrect() {
        Assert.assertTrue(cartPage.calculateTotal());
    }

    @When("user increase quantity then verify")
    public void userIncreaseQuantityThenVerify() {
    }

    @When("user clicks check for coupons")
    public void userClicksCheckForCoupons() {
        cartPage.clickCheckForCoupons();
    }

    @And("apply a coupon if available")
    public void applyACoupon() {
        cartPage.applyCoupon();
    }

    @Then("verify coupon amount is reduced from total amount")
    public void verifyCouponAmountIsReducedFromTotalAmount() {
        cartPage.isCouponApplied();
    }

}
