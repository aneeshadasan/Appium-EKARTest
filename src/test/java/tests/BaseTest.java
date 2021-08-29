package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.EkarDemoPage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static AndroidDriver driver;
    static Properties prop = new Properties();
    EkarDemoPage ekarDemoPage = new EkarDemoPage(driver);

    @BeforeAll
    public static void init() throws MalformedURLException {
        loadProperties();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", prop.getProperty("deviceName"));
        cap.setCapability("udid", prop.getProperty("udid"));
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", prop.getProperty("platformVersion"));
        cap.setCapability("autoGrantPermissions", true);

        cap.setCapability("appPackage", "in.testdemo.map");
        cap.setCapability("appActivity", "in.testdemo.map.MainActivity");

        URL url = new URL(prop.getProperty("url") + "/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, cap);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.println("Application  Started... ");
    }

    @AfterAll
    public static void tearDown() {
        driver.closeApp();
        driver.quit();
    }

    public static void loadProperties() {
        File file = new File("src/main/resources/config");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            prop.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
