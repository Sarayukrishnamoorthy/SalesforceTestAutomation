package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserNameDropDownTC5 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement userNavBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitForVisibility(userNavBtn);
		userNavBtn.click();
		
		Thread.sleep(2000);
		quitBrowser();
		
	}
}
