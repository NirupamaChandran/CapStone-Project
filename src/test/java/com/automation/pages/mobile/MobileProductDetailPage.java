package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProductDetailPage;

public class MobileProductDetailPage extends MobileBasePage implements ProductDetailPage {

    @Override
    public boolean isTheClickedProductDisplayed() {
        return false;
    }

    @Override
    public void clickAddToCart() {

    }

    @Override
    public String verifyCartCount() {
        return "";
    }

    @Override
    public void clickCartIcon() {

    }

    @Override
    public void selectSize(String key) {

    }

    @Override
    public void clickMoreProductInfo() {

    }

    @Override
    public boolean isProductInfoDisplayed() {
        return false;
    }

    @Override
    public void clickVisitStore() {

    }

    @Override
    public void clickSimilarProductsIcon() {

    }

    @Override
    public void clickViewAllProducts() {

    }

    @Override
    public String isSuccessMsgDisplayed() {
        return "";
    }
}
