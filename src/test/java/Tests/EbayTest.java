package Tests;

import Base.TestBase;
import Screens.HomeScreen;
import Screens.ProductDetailsScreen;
import Screens.ProductListingScreen;
import Screens.SignInScreen;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EbayTest extends TestBase {
    public static Logger log = Logger.getLogger("MyLogs");

    private HomeScreen homescreen;
    private ProductListingScreen productlistingscreen;
    private ProductDetailsScreen productdetailsscreen;
    private SignInScreen signinscreen;

    @BeforeTest(alwaysRun=true)
    public void init()
    {
        homescreen=new HomeScreen(driver);
        productlistingscreen=new ProductListingScreen(driver);
        productdetailsscreen=new ProductDetailsScreen(driver);
        signinscreen =new SignInScreen(driver);

    }
    //test steps
    @Test
    public void testSteps(){
        log.debug(" ====Executing test Steps====");
        String searchkeyword="java programming";
        String username="ebayuser@test.com";
        try {
            homescreen.searchKeywordText(searchkeyword);
            Thread.sleep(6000);
            productlistingscreen.sortByPriceLowToHigh();
            productlistingscreen.getProductNameAndPrice();
            productlistingscreen.clickOnFirstElement();
            productdetailsscreen.addToWatchList();
            signinscreen.verifyIfUserIsOnSignInScreen();
            signinscreen.useEmailToSignin();
            signinscreen.enterUsername(username);
            signinscreen.clickOnClose();
            signinscreen.clickOnClose();
            Thread.sleep(3000);
            productdetailsscreen.verifyIfUserIsOnProductDetailsPage();
            log.debug("Test Passed ");
        }catch (Exception e){
            log.error("Test Failed");
            e.printStackTrace();

        }


    }


}
