package com.automation.pages.interfaces;

public interface CartPage {
    void changeSizeAndQuantity() throws InterruptedException;

    boolean verifySizeAndQuantityUpdated(String configValue);

    boolean isCartPageDisplayed();

    void removeItem();

    boolean isItemRemoved();

    void clickContinueShopping();

    String cartProductTitle();

    boolean calculateTotal();
}
