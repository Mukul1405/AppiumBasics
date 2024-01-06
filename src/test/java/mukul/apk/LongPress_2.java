package mukul.apk;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
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
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
			    ImmutableMap.of("elementID", ((RemoteWebElement) ele).getId(),
			            "x", ele.getLocation().getX() + ele.getSize().getWidth() / 2,
			            "y", ele.getLocation().getY() + ele.getSize().getHeight() / 2,
			            "duration", 2000));

	
		Thread.sleep(2000);
	}
}
