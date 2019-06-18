package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestWebBrowser {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder() 
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\Michal\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		
		service.start();

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("deviceName", "Android");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByName("q").sendKeys("Hello Appium!");
		driver.findElementByXPath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/button[2]").click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.quit();
		service.stop();

	}

}
