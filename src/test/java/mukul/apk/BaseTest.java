package mukul.apk;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriverLocalService appiumservicebuilder;
	public AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException{
		
		appiumservicebuilder = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		appiumservicebuilder.start();
		
		
		UiAutomator2Options options = new UiAutomator2Options(); 
		options.setDeviceName("Pixel 6 Pro API 34");
		options.setApp("//Users//mukul//eclipse-workspace//apk//src//test//java//resources//ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	public void longPress(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
			    ImmutableMap.of("elementID", ((RemoteWebElement) ele).getId(),
			            "x", ele.getLocation().getX() + ele.getSize().getWidth() / 2,
			            "y", ele.getLocation().getY() + ele.getSize().getHeight() / 2,
			            "duration", 2000));

	}
	
	public void scrollUntilTextFound(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text("+text+"));"));
		
	}
	private boolean isElementPresent(By locator) {
	    try {
	        driver.findElement(locator);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	public void scollUntilObjectFound(WebElement ele,By ele3) {
		
//		
		int scroll =1;
		do {
			

			HashMap<String, Object> scrollObject = new HashMap<>();
			scrollObject.put("element", ((RemoteWebElement) ele).getId());
			scrollObject.put("direction", "down");
			scrollObject.put("percent", 0.3); // Adjust the percentage as needed
//			scrollObject.put("speed", 4000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("mobile: scrollGesture", scrollObject);
			
			Boolean elementlocator = isElementPresent(ele3);
			if(elementlocator) {
				System.out.println("Element 3 found");
				break;
			}
			if(scroll>10) {
				System.out.println("element not found");
			}
			System.out.println("Scrolling " + scroll + " times");
			scroll++;
		}
		while(true);
		
		
	}
	
	public void swipe(WebElement ele, String Direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"element", ((RemoteWebElement)ele).getId(),
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", Direction,
			    "percent", 0.75
			));
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		appiumservicebuilder.stop();
	}
}
