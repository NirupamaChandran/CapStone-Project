package com.automation.pages.mobile;

import com.automation.pages.interfaces.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileCartPage extends MobileBasePage implements CartPage {


    @Override
    public void changeSizeAndQuantity() throws InterruptedException {

    }

    @Override
    public boolean verifySizeAndQuantityUpdated(String configValue) {
        return false;
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.tul.tatacliq:id/toolbar_title'" +
            "]")
    WebElement myBagHeader;
    @Override
    public boolean isCartPageDisplayed() {
        return myBagHeader.isDisplayed();
    }

    @Override
    public void removeItem() {

    }

    @Override
    public boolean isItemRemoved() {
        return false;
    }

    @Override
    public void clickContinueShopping() {

    }

    @FindBy(id = "com.tul.tatacliq:id/text_view_my_bag_product_name")
    WebElement title;
    @Override
    public String cartProductTitle() {
        return title.getText();
    }

    @Override
    public boolean calculateTotal() {

        return false;

    }

    @Override
    public void clickCheckForCoupons() {

    }

    @Override
    public void applyCoupon() {

    }

    @Override
    public boolean isCouponApplied() {
        return false;
    }
}
