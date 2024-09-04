package com.automation.pages.mobile;

import com.automation.pages.interfaces.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileCartPage extends MobileBasePage implements CartPage {

    @FindBy(id = "com.tul.tatacliq:id/text_size")
    WebElement changeSizeDropdown;
    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View")
    List<WebElement> sizeChange;
    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[4]/android.view.View")
    List<WebElement> quantityChange;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Done\"]")
    WebElement doneButton;
    int flag =0;
    @Override
    public void changeSizeAndQuantity() throws InterruptedException {
        changeSizeDropdown.click();
        if(isPresent(sizeChange.get(1))) {
            sizeChange.get(1).click();
        }
        if(quantityChange.get(1).isEnabled()) {
            quantityChange.get(1).click();
            flag=1;
        }
        doneButton.click();
        // page loading
        Thread.sleep(5000);
    }

    @FindBy(id = "com.tul.tatacliq:id/text_quantity")
    WebElement changeQuantityDropdown;
    @Override
    public boolean verifySizeAndQuantityUpdated(String size) {
        if(changeSizeDropdown.getText().equals(size)){
            return false;
        }
        if(flag==1 && (!changeQuantityDropdown.getText().equals("1"))){
            return false;
        }
        return true;
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
