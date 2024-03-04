package ecom.apk;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTest{
	
	public void userDetailsPage() {
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")).click();
		By ele = By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Australia\"]");
		WebElement elem = driver.findElement(By.xpath("//android.widget.ListView"));
		scollUntilObjectFound(elem,ele);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Australia\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Mukul");	
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")).click();
		
	}
		
	public String AddtoCart(String ProductName) {
		String result = "";
		try {
//		WebElement elem = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]"));
//		By ele = By.xpath("//android.widget.TextView[@text='"+ProductName+"']");
//		scollUntilObjectFound(elem,ele);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+ProductName+"']"+"/../android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
		result = "Passed";
		}
		catch(Exception e) {
			e.printStackTrace();
			result = "Failed";
		}
		return result;
		
	}
	
	public double getPriceOfProduct(String ProductName) {
		WebElement elem = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]"));
		By ele = By.xpath("//android.widget.TextView[@text='"+ProductName+"']");
		scollUntilObjectFound(elem,ele);
		String price = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ProductName+"']"+"/../android.widget.LinearLayout[2]/android.widget.TextView[1]")).getText();
		price = price.replace("$", "");
		System.out.println("Price of product is :- "+price);
		return Double.parseDouble(price);
		
	}
	
	@Test
	public void CheckSum() throws InterruptedException {
		userDetailsPage();
		double price1 = getPriceOfProduct("Air Jordan 4 Retro");
		WebElement elem = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]"));
	//	scrollPageToTop(elem);
		String result = AddtoCart("Air Jordan 4 Retro");
	
	    double price2 = getPriceOfProduct("Air Jordan 9 Retro");
	//    scrollPageToTop(elem);
		AddtoCart("Air Jordan 9 Retro");
		double totalPrice = price1+price2;
		
		System.out.println(totalPrice);
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]")).click();
		
		String TotalPriceShown = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")).getText();
		TotalPriceShown = TotalPriceShown.replace("$", "");
		double actualPrice = Double.parseDouble(TotalPriceShown);
		
		Assert.assertEquals(totalPrice, actualPrice, "Price is different ");
		
		
		
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnProceed\"]")).click();
		Thread.sleep(5000);
		
		Set<String> contexts = driver.getContextHandles();
		System.out.println("Before Context Switch: " + driver.getContext());
		for (String context : contexts) {
		    System.out.println("Available Context: " + context);
		    if(context.contains("WEBVIEW")) {
		    	System.out.println("In loop");
			    driver.context(context);
				System.out.println("After Context Switch: " + driver.getContext());
			    System.out.println("Switch Context from Android to Web");
			    break;
		    }
		}

		


		
		driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		
	}
	
	
	// Driver Switching Concepts
	

}
