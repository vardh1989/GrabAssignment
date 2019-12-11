package Screens;

import Base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class ProductListingScreen extends ScreenBase {

    public static Logger log = Logger.getLogger("MyLogs");
    @AndroidFindBy(id="com.ebay.mobile:id/text_slot_1")
    private MobileElement ID_TEXT_SLOT_1;

    @AndroidFindBy(id="com.ebay.mobile:id/button_sort")
    private MobileElement ID_BUTTON_SORT;

    @AndroidFindBy(id="com.ebay.mobile:id/textview_item_title")
    private List<MobileElement> ID_TEXTVIEW_ITEM_TITLE;

    @AndroidFindBy(id="com.ebay.mobile:id/textview_item_price")
    private List<MobileElement> ID_TEXTVIEW_ITEM_PRICE;

    @AndroidFindBy(className="android.widget.CheckedTextView")
    private List<MobileElement> CLASS_CHECKED_TEXTVIEW;


    public ProductListingScreen(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /*
    Sort the product items from Low to High price
     */
    public void sortByPriceLowToHigh(){

        if(ID_TEXT_SLOT_1.isDisplayed()){
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        }
        ID_BUTTON_SORT.click();
        for(MobileElement pricelowtohigh:CLASS_CHECKED_TEXTVIEW)
        try{
            if(pricelowtohigh.getText().contains("Lowest Price")) {
                pricelowtohigh.click();
                break;
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    /*
    Getting first N(appearing) products' name and price .
    Printing product and price in TestOutPut.log
     */
    public void getProductNameAndPrice(){
        Map<String,String> map;
        map = getTitleAndPrice(ID_TEXTVIEW_ITEM_TITLE,ID_TEXTVIEW_ITEM_PRICE);

        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("Product =>"+entry.getKey()+". Price =>"+entry.getValue());
            log.debug("=======================PRODUCT DETAILS======================== ");
            log.debug("Product =>"+entry.getKey()+". Price =>"+entry.getValue());
            log.debug("=============================================== ");

        }

    }

    /*
    click on first item in the product search list.
     */
    public void clickOnFirstElement(){
        ID_TEXTVIEW_ITEM_TITLE.get(0).click();
    }

}
