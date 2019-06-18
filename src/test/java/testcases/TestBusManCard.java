package testcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBusManCard {

	public static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder() 
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\Michal\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		
		service.start();

		//File app = new File(".\\app\\BusManCard.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.busmancard");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "MainActivity");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Actions action = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		
		driver.findElementsByClassName("android.widget.EditText").get(0).sendKeys("test@test.pl");
		driver.findElementsByClassName("android.widget.EditText").get(1).sendKeys("Password1");
		driver.findElementsByClassName("android.widget.EditText").get(2).sendKeys("Password1");
		//action.sendKeys("test@test.pl").perform();
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		//driver.findElementsByClassName("android.widget.EditText").get(1).click();
		//action.sendKeys("Password123").perform();
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		//driver.findElementsByClassName("android.widget.EditText").get(2).click();
		//action.sendKeys("Password123").perform();
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		
		driver.findElementsByClassName("android.widget.TextView").get(2).click();

		
		//driver.findElementsByClassName("android.widget.EditText").get(2).sendKeys("aaaaa");
		
		
		
		//Thread.sleep(10000);

		Thread.sleep(2000);

		
		driver.quit();
		
		//service.stop();

	}

}
