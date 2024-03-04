package mukul.apk;

import java.net.MalformedURLException;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;


public class Scroll_3 extends BaseTest {

	
	
	@Test
	public void Scroll() throws MalformedURLException, InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();

//		Scrolling using google uiAutomator 
//		scrollUntilTextFound("WebView")


//		Scrolling using JS Executor
		By ele3 = By.xpath("//android.widget.TextView[@content-desc=\"WebView\"]");
		WebElement ele = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']"));
		
		scollUntilObjectFound(ele,ele3);
		
		Thread.sleep(2000);
	}
}
