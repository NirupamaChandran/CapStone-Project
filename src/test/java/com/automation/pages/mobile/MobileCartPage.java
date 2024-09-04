package com.automation.pages.mobile;

import com.automation.pages.interfaces.CartPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.Dimension;
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

    @FindBy(xpath = "//android.widget.TextView[@text='Total Payable']/following-sibling::android.widget.TextView")
    WebElement totalPayable;
    @FindBy(xpath = "//android.widget.TextView[@text='Price Details']")
    WebElement priceDetails;
    @FindBy(xpath = "//android.widget.TextView[@text='Check for coupon']")
    WebElement checkForCouponBtn;
    @Override
    public void clickCheckForCoupons() {

        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(priceDetails)){
            scrollOrSwipe(width/2, height/2, width/2, 0);
        }

        String payableAmount = totalPayable.getText().substring(1);
        ConfigReader.setConfigValue("actual.amount",payableAmount);
        checkForCouponBtn.click();
    }

    @FindBy(xpath = "//android.widget.TextView/preceding-sibling::android.widget.TextView[@text='Apply']")
    WebElement applyBtn;
    @FindBy(id = "com.tul.tatacliq:id/txtSecondTermValue")
    WebElement couponPrice;
    @FindBy(className = "android.widget.ImageButton")
    WebElement backBtn;
    @Override
    public void applyCoupon() {
        if(isDisplayed(applyBtn)){
            double amount = Double.parseDouble(couponPrice.getText().substring(1));
            ConfigReader.setConfigValue("coupon.amount", String.valueOf(amount));
            applyBtn.click();
        }
        else{
            backBtn.click();
        }
    }

    @FindBy(xpath = "//android.view.View[@resource-id='com.tul.tatacliq:id/hurrayThanksView']")
    WebElement successMsg;
    @FindBy(xpath = "//android.widget.TextView[@text='Total Payable']/following-sibling::android.widget.TextView")
    WebElement totalPrice;
    @Override
    public boolean isCouponApplied() {
        if(isDisplayed(successMsg)){
            double total = Double.parseDouble(totalPrice.getText().substring(1));
            return successMsg.isDisplayed() && total == Double.parseDouble(
                    ConfigReader.getConfigValue("actual.amount")) -
                    Double.parseDouble(ConfigReader.getConfigValue("coupon.amount"));
        }
        return true;
    }
}
