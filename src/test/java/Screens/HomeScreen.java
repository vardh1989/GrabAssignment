package Screens;

import Base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class HomeScreen extends ScreenBase {

    @AndroidFindBy(id="com.ebay.mobile:id/search_box")
    private MobileElement ID_SEARCH_BOX;

    @AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
    private MobileElement ID_SEARCH_SRC_TEXT;

    public HomeScreen(AppiumDriver<MobileElement>driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /*
    @param : keyword to search
     */
    public void searchKeywordText(String keyword) throws InterruptedException {
       ID_SEARCH_BOX.click();
       ID_SEARCH_SRC_TEXT.sendKeys(keyword);
       ID_SEARCH_SRC_TEXT.click();
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
       }

}

