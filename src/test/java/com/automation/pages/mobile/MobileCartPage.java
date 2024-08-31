package com.automation.pages.mobile;

import com.automation.pages.interfaces.CartPage;

public class MobileCartPage extends MobileBasePage implements CartPage {


    @Override
    public void changeSizeAndQuantity() throws InterruptedException {

    }

    @Override
    public boolean verifySizeAndQuantityUpdated(String configValue) {
        return false;
    }

    @Override
    public boolean isCartPageDisplayed() {
        return false;
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

    @Override
    public String cartProductTitle() {
        return "";
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
