package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by suci on 4/4/17.
 */

public  class AndroidSetup {

    public static AndroidDriver driver;

    public static void androidSetUpAppium() throws MalformedURLException {
        System.out.println("setup driver");
        File app = new File("/opt/apks","athena-sample.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", "com.naspers_classifieds.loginsample");
        capabilities.setCapability("appActivity", "com.naspers_classifieds.loginsample.MainActivity");
        capabilities.setCapability("appWaitActivity", "com.naspers_classifieds.loginsample.MainActivity");

        capabilities.setCapability("deviceName","Galaxy");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("newCommandTimeout", 60 * 5);

        //No Reset Apps
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", true);

        //No Keyboard Layout
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("locationContextEnabled", "true");
        capabilities.setCapability("deviceReadyTimeout", 100);
        capabilities.setCapability("appWaitDuration", 1000000);

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);

    }

    public static void checkEligibleRun() throws Exception {
        SessionId sessionId = driver.getSessionId();
        boolean isappinst = driver.isAppInstalled("com.naspers_classifieds.loginsample");
        if(sessionId == null && isappinst == false){
            System.exit(1);
        }
    }

    public static AndroidDriver getDriver(){
        return driver;
    }

    public static void stopDriver(){
        driver.quit();
    }

    @Before
    public static void beforeScenario() throws Exception {
        androidSetUpAppium();
        checkEligibleRun();
    }

    @After
    public static void afterScenario(){
        stopDriver();
    }




}
