package mukul.apk;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
	@AfterClass
	public void teardown() {
		driver.quit();
		appiumservicebuilder.stop();
	}
}
