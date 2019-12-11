package Base;

 /*@author=Vardhman Golchha*/

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.HashMap;
import java.util.List;

//All Screen classes will extend this class
//Contains common methods available for the screens
    public class ScreenBase {

        public AppiumDriver<MobileElement> driver;

        public WebDriverWait wait;

        public ScreenBase(AppiumDriver<MobileElement> driver) {

            this.driver = driver;

        }

        // Explicit wait for locator element till it is present
        public void waitforElement(long duration, String locator) {

            wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));

        }

        // To hide keyboard
        public void hideKeyboard() {

            driver.hideKeyboard();
        }
    //Match product with price.
    public HashMap<String,String> getTitleAndPrice(List<MobileElement> products, List<MobileElement>prices){
        HashMap<String ,String > map = new HashMap<String,String>();
        int numberofproductitems =products.size();
        int numberofpriceitems=prices.size();

        if(numberofpriceitems==0 | numberofpriceitems==0){
            return null;
        }

        if(numberofpriceitems!=numberofproductitems){
            return null;
        }

        for(int i=0;i<numberofpriceitems;i++){
            map.put(products.get(i).getText(),prices.get(i).getText());
        }
        return  map;
    }

    }




