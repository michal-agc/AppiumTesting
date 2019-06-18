package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestHardwareKeys {

		public static AndroidDriver driver;
		private static String amka;

		public static void main(String[] args) throws MalformedURLException, InterruptedException {

			//File app = new File(".\\app\\selendroid-test-app-0.17.0.apk");
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "HomeScreenActivity");
			//let us use action.sendKeys().
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//amka = new String("Display text view");
			//System.out.println(amka);
			//Thread.sleep(3000);
			//driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/visibleButtonTest\")").click();
			driver.findElementByXPath("//android.widget.FrameLayout[1]");
			//driver.findElementById("io.selendroid.testapp:id/buttonStartWebview").click();
			
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(3000);
			driver.findElementById("io.selendroid.testapp:id/my_text_field").click();
			
			
			driver.pressKey(new KeyEvent(AndroidKey.A));
			driver.pressKey(new KeyEvent(AndroidKey.B));
			driver.pressKey(new KeyEvent(AndroidKey.C));
			Thread.sleep(3000);
			
			//other way to press keys
			Actions action = new Actions(driver);
			action.sendKeys("Appium").perform();
			
			/*driver.toggleWifi();
			try{
				driver.toggleAirplaneMode();
			}catch(Throwable t) {
				System.out.println("Airplane mode active");
			}
			Thread.sleep(3000);*/
			driver.quit();
			

	}

}
