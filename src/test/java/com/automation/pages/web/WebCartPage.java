package com.automation.pages.web;

import com.automation.pages.interfaces.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebCartPage extends WebBasePage implements CartPage {

    @FindBy(css = ".CartPage__myBag")
    WebElement myBagHeader;

    public boolean isCartPageDisplayed() {
        return myBagHeader.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='CartItemForDesktop__textWithOutOfStock']/preceding-sibling::div")
    WebElement title;

    public String cartProductTitle() {
        return title.getText();
    }

    @FindBy(className = "SizeQuantitySelectBox__bottom")
    WebElement sizeAndQuantity;
    @FindBy(xpath = "//div[@class='SizeSelector__grid']/child::div[@class='SizeSelector__child']")
    List<WebElement> sizeSelectList;
    @FindBy(xpath = "//div[text()='2']")
    WebElement quantitySelect;
    @FindBy(xpath = "//span[text()='Done']/parent::div")
    WebElement doneButton;

    public void changeSizeAndQuantity() throws InterruptedException {
        sizeAndQuantity.click();
        sizeSelectList.get(0).click();
        quantitySelect.click();
        doneButton.click();
        Thread.sleep(3000);
    }

    @FindBy(xpath = "//div[text()='Size']/following-sibling::div/span")
    WebElement sizeCheck;
    @FindBy(xpath = "//div[text()='Qty']/following-sibling::div/span")
    WebElement quantityCheck;

    public boolean verifySizeAndQuantityUpdated(String size) {
        if (sizeCheck.getText().equalsIgnoreCase(size) || quantityCheck.getText().equals("1")) {
            return false;
        }
        return true;
    }

    @FindBy(xpath = "//div[text()='Remove']")
    WebElement removeButton;

    public void removeItem() {
        removeButton.click();
    }

    @FindBy(className = "EmptyBag__headingText")
    WebElement removeResponse;

    public boolean isItemRemoved() {
        return removeResponse.getText().equals("Your bag is empty! Let’s fill it up shall we?");
    }

    @FindBy(xpath = "//span[text()='Continue Shopping']")
    WebElement continueShoppingButton;

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    @FindBy(xpath = "//div[@class='CartItemForDesktop__informationTextWithBolder']")
    List<WebElement> productPrice;
    @FindBy(xpath = "//div[@class='DesktopCheckout__shippingCharge' and not(./span)]")
    WebElement processingPrice;
    @FindBy(xpath = "//div[@class='DesktopCheckout__price']")
    WebElement totalAmount;

    public boolean calculateTotal() {
        double expectedTotal = 0;
        for (WebElement price : productPrice) {
            double itemPrice = Double.parseDouble(price.getText().substring(1));
            expectedTotal += itemPrice;
        }
        double processingFee = Double.parseDouble(processingPrice.getText().split("₹")[2]);
        expectedTotal += processingFee;
        double actualTotal = Double.parseDouble(totalAmount.getText().substring(1));
        return expectedTotal == actualTotal;
    }
}

