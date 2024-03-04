package ecom.apk;

import org.testng.annotations.Test;

public class Test2 {

	@Test
	public void testing() {
		String text = "abcd.adkjfnd";
		if(text.contains("nd")) {
			System.out.println("True");
		}
		else {
			System.out.println("Fail");
		}
	}
}
