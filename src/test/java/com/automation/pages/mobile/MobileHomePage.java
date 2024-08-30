package com.automation.pages.mobile;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MobileHomePage extends MobileBasePage implements HomePage {

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]")
    WebElement goToHomePage;
    public void openWebsite(){
        goToHomePage.click();
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement denyButton;
    @FindBy(id = "android:id/button2")
    WebElement closeAdd;
    @FindBy(className = "android.widget.ImageView")
    WebElement closeButton;
    @Override
    public void closePopUp() {
        denyButton.click();
        closeAdd.click();
        closeButton.click();
    }


    @FindBy(id = "com.tul.tatacliq:id/rl_tv_prominent")
    WebElement searchBox;
    @Override
    public boolean isHomePageDisplayed() {
        return searchBox.isDisplayed();
    }

    @Override
    public void chooseBrand() {

    }

    @Override
    public void searchCategory() {

    }

    @FindBy(xpath = "//android.widget.AutoCompleteTextView[@resource-id='android:id/search_src_text']")
    WebElement searchInput;
    @Override
    public void searchItem(String key) {
        searchBox.click();
        searchInput.sendKeys(key);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).pause(1000).keyUp(Keys.ENTER).build().perform();
    }

    @Override
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickTataLuxury(){
    }

    @Override
    public boolean isLuxuryPageTitleDisplayed() {
        return false;
    }
}
