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


public class swipe_4 extends BaseTest {

	@Test
	public void Swipe() throws MalformedURLException, InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		
		String focusable = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
		Assert.assertEquals(focusable, "true");
		
		WebElement ele = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		swipe(ele,"left");
		String focusable1 = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
		Assert.assertEquals(focusable1, "false");
		
		Thread.sleep(2000);
	}
}
