package mukul.apk;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;


public class LongPress_2 extends BaseTest {

	@Test
	public void LongPress() throws MalformedURLException, InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementID",((RemoteWebElement) ele).getId(),"duration",2000));
		longPress(ele);
		
		String menuText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title']")).
				getText();
		
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title']")).isDisplayed());
		Assert.assertEquals(menuText, "Sample menu");
	
		Thread.sleep(2000);
	}
}
