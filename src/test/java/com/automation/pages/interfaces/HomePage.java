package com.automation.pages.interfaces;

import org.openqa.selenium.WebElement;

public interface HomePage {
    void openWebsite();

    void closePopUp();

    boolean isHomePageDisplayed();

    void chooseBrand();

    void searchCategory();

    void searchItem(String configValue);

    boolean isDisplayed(WebElement element);

    void clickTataLuxury();

    boolean isLuxuryPageTitleDisplayed();
}
