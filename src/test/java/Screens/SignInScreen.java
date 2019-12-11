package Screens;
import Base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SignInScreen extends ScreenBase{

    @AndroidFindBy(id="com.ebay.mobile:id/button_classic")
    private MobileElement ID_BUTTON_CLASSIC;

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_username")
    private MobileElement ID_EDIT_TEXT_USERNAME;

    @AndroidFindBy(id="com.ebay.mobile:id/home")
    private  MobileElement ID_HOME;

    @AndroidFindBy(id="com.ebay.mobile:id/title")
    private  MobileElement ID_TITLE;

    public SignInScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /*
    To select user name and email option to sign in
     */
    public void useEmailToSignin(){
        ID_BUTTON_CLASSIC.click();
    }

    /*
    Enter user name
    @param : username.
     */
    public void enterUsername(String username){
        ID_EDIT_TEXT_USERNAME.sendKeys(username);
    }

    /*
    tap to close sign in page
     */
    public void clickOnClose(){
        ID_HOME.click();
    }

    /*
    To verify if user is on Sign in page
     */
    public void verifyIfUserIsOnSignInScreen(){
        String expectedpagetitle="Sign in";
        String pagetitle=ID_TITLE.getText();
        Assert.assertEquals(expectedpagetitle,pagetitle);
    }


}

