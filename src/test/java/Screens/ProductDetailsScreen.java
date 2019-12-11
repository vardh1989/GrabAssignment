package Screens;

import Base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ProductDetailsScreen extends ScreenBase {

    @AndroidFindBy (uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"com.ebay.mobile:id/button_watch\"))")
    public MobileElement ID_BUTTON_WATCH;

    @AndroidFindBy (uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"com.ebay.mobile:id/about_this_item_title\"))")
    public MobileElement ID_ABOUT_THIS_ITEM_TITLE;


    public ProductDetailsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /*
    To add the item in watchlist
     */
    public void addToWatchList(){
        ID_BUTTON_WATCH.click();

    }

    /*
    To Verify if user is on Product detail page
     */
    public void verifyIfUserIsOnProductDetailsPage(){
        String texttoverify="About This Item";
        //If user can find "watch" button and "About this item" product details then user is on details page.
        ID_BUTTON_WATCH.isDisplayed();
        ID_ABOUT_THIS_ITEM_TITLE.isDisplayed();
        String textresult= ID_ABOUT_THIS_ITEM_TITLE.getText();

        Assert.assertEquals(texttoverify,textresult);

        }


    }



