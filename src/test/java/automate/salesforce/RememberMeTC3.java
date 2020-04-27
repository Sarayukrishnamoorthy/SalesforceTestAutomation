package automate.salesforce;

import org.openqa.selenium.By;

public class RememberMeTC3 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(true);
		
		logout();
		
		// login page after remember me clicked and logout
		waitForVisibility(driver.findElement(By.xpath("//span[@id='idcard-identity']")));
		System.out.println("After remember me = " + driver.findElement(By.xpath("//span[@id='idcard-identity']")).getText());
		
		Thread.sleep(2000);
		quitBrowser();
		
		
	}
}
