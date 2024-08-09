package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "Android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/";

    private static Platform instance;
    private Platform(){}

    public static Platform getInstance(){
        if (instance== null){
            instance = new Platform();
        }
        return instance;
    }

    public AppiumDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if (this.IsAndroid()){
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (this.IsIOS()) {
            return new IOSDriver(URL, this.getIOSdDesiredCapabilities());
        } else {
            throw  new Exception("Cannot detect type of the Driver. Platform value " + this.getPlatformVar());
        }
    }

    public  boolean IsAndroid(){
        return IsPlatform(PLATFORM_ANDROID);
    }

    public  boolean IsIOS(){
        return IsPlatform(PLATFORM_IOS);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Example");
        capabilities.setCapability("platformVersion","10.0");
        capabilities.setCapability("appium:automationName","uiautomator2");
        capabilities.setCapability("appium:appPackage","org.wikipedia");
        capabilities.setCapability("appium:appActivity","org.wikipedia.main.MainActivity");
        capabilities.setCapability("app","C:\\JavaAppiumAutomation_Project\\JavaAppiumAutomation_Project\\apks\\org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getIOSdDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","IOS");
        capabilities.setCapability("deviceName","iPhone SE");
        capabilities.setCapability("platformVersion","11.3");
        capabilities.setCapability("app","C:\\JavaAppiumAutomation_Project\\JavaAppiumAutomation_Project\\apks\\org.wikipedia.app");
        return capabilities;
    }

    private boolean IsPlatform(String my_platform){
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    private String getPlatformVar(){
        return System.getenv("PLATFORM");
    }
}
