package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProductListPage;

public class MobileProductListPage extends MobileBasePage implements ProductListPage {
    @Override
    public boolean isProductListPageDisplayed() {
        return false;
    }

    @Override
    public boolean isListPageHeadingDisplayed(String configValue) {
        return false;
    }

    @Override
    public void clickFirstProduct() {

    }

//    @Override
//    public void clickProduct() {
//    }

    @Override
    public boolean isItemHeadingDisplayed(String configValue) {
        return false;
    }

    @Override
    public void sortPriceHighToLow() {

    }

    @Override
    public boolean isPriceHighToLowSorted() {
        return false;
    }

    @Override
    public void addBrandFilter(String configValue, String filterType) {

    }

    @Override
    public boolean isBrandFilterApplied(String configValue) {
        return false;
    }

    @Override
    public void changeView() {

    }

    @Override
    public boolean isViewChanged() {
        return false;
    }

    @Override
    public boolean isSimilarProductsDisplayed() {
        return false;
    }

    @Override
    public void clickFeedBack() {

    }

    @Override
    public boolean isFeedBackPageDisplayed() {
        return false;
    }

    @Override
    public void enterFeedBack() {

    }

    @Override
    public void submitFeedBack() {

    }

    @Override
    public String successMsg() {
        return "";
    }

    @Override
    public void sortPriceLowToHigh() {

    }

    @Override
    public boolean isPriceLowToHighSorted() {
        return false;
    }

    @Override
    public void clickRightArrow() {

    }

    @Override
    public boolean verifyImage() {
        return false;
    }

    @Override
    public boolean isDiscountFilterApplied() {
        return false;
    }
}
