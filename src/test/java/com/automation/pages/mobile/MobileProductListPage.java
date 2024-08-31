package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProductListPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
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
        if (isDisplayed(viewButton)) {
            viewButton.click();
        }
        ConfigReader.setConfigValue("product.name", titleList.get(0).getText());
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


    @FindBy(xpath = "//android.widget.TextView[@text='Price High to Low']")
    WebElement highToLow;

    @Override
    public void sortPriceHighToLow() {
        sortButton.click();
        highToLow.click();
    }


    @FindBy(id = "com.tul.tatacliq:id/emptyText")
    WebElement productListEnd;
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.tul.tatacliq:id/linearLayoutPriceInfo']/android.widget.TextView[1]")
    List<WebElement> priceList;

    @Override
    public boolean isPriceHighToLowSorted() {
        int i = 0;

        //Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        do {
            List<Double> newPriceList = new ArrayList<>();
            for (WebElement price : priceList) {
                newPriceList.add(Double.parseDouble(price.getText().substring(1).replace(",", "")));
            }
            List<Double> copyPriceList = new ArrayList<>(newPriceList);
            Collections.sort(copyPriceList);
            Collections.reverse(copyPriceList);

            if (!newPriceList.equals(copyPriceList)) {
                return false;
            }

            scrollOrSwipe(width / 2, height / 2, width / 2, 0);

            i++;

        } while (i <= 5);

        return true;
    }

    @FindBy(id = "com.tul.tatacliq:id/searchEditText")
    WebElement brandInput;
    @FindBy(id = "com.tul.tatacliq:id/textViewFilterValueName")
    WebElement searchResult;
    @FindBy(id = "com.tul.tatacliq:id/txtShowResults")
    WebElement showResult;
    @Override
    public void addBrandFilter(String filter, String filterType) {
        filterButton.click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.tul.tatacliq:id/txtFilterKey' and @text='"+filterType+"']")).click();
        brandInput.sendKeys(filter);
        searchResult.click();
        showResult.click();
    }

    @FindBy(id = "com.tul.tatacliq:id/appCompatTextView2")
    WebElement giveFeedback;
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
