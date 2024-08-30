package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProductDetailPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileProductDetailPage extends MobileBasePage implements ProductDetailPage {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Product Name']")
    WebElement title;
    @Override
    public boolean isTheClickedProductDisplayed() {
        return title.getText().equals(ConfigReader.getConfigValue("product.name"));
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
