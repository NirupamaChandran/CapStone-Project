package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProductListPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileProductListPage extends MobileBasePage implements ProductListPage {

    @FindBy(xpath = "//android.widget.TextView[@text='Sort']")
    WebElement sortButton;
    @FindBy(id = "com.tul.tatacliq:id/textViewRefine")
    WebElement filterButton;
    @Override
    public boolean isProductListPageDisplayed() {
        return isDisplayed(sortButton) && isDisplayed(filterButton);
    }

    @Override
    public boolean isListPageHeadingDisplayed(String configValue) {
        return false;
    }


    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[2]")
    List<WebElement> titleList;
    @FindBy(id = "com.tul.tatacliq:id/llGridListView")
    WebElement viewButton;
    @Override
    public void clickFirstProduct() {
        if(isDisplayed(viewButton)){
            viewButton.click();
        }
        ConfigReader.setConfigValue("product.name",titleList.get(0).getText());
        titleList.get(0).click();
    }

//    @Override
//    public void clickProduct() {
//    }


    @FindBy(id = "com.tul.tatacliq:id/toolbar_icon_title")
    WebElement heading;
    @Override
    public boolean isItemHeadingDisplayed(String configValue) {
        return isDisplayed(heading);
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
