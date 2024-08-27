package com.automation.pages.mobile;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileHomePage extends MobileBasePage implements HomePage {

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]")
    WebElement goToHomePage;
    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement denyButton;
    @FindBy(id = "android:id/button1")
    WebElement skipNowButton;
    @FindBy(className = "android.widget.ImageView")
    WebElement closeButton;
    public void openWebsite(){
        goToHomePage.click();
        denyButton.click();
        skipNowButton.click();
        closeButton.click();
    }

    @Override
    public void closePopUp() {

    }

    @Override
    public boolean isHomePageDisplayed() {
        return false;
    }

    @Override
    public void chooseBrand() {

    }

    @Override
    public void searchCategory() {

    }

    @Override
    public void searchItem(String configValue) {

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
