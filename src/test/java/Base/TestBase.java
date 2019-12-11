package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import Base.AppiumServer;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public static Logger log = Logger.getLogger("MyLogs");
    String APPIUM_PORT = "4723";
    private URL serverUrl=null;
    public  static AppiumDriver<MobileElement> driver;

    @BeforeSuite(alwaysRun=true)
    public void setup() throws IOException {

        int port = 4723;
        if (!AppiumServer.checkIfServerIsRunning(port)) {
            log.debug("****************** STARTING APPIUM ************************");
           AppiumServer.startServer();
        } else {
            log.error("Appium Server already running on Port - " + port);
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.ebay.mobile");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.ebay.mobile.activities.MainActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(AutomationName.SELENDROID,"Selendroid");

        serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub ");
        driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterSuite
    public void teardown(){
        log.debug("****************** EXITING SERVER ************************");
        driver.quit();
        AppiumServer.stopServer();



    }


}
