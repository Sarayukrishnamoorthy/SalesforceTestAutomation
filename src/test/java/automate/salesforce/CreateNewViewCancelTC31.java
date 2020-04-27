package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewViewCancelTC31 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitForVisibility(opportunitiesBtn);
		opportunitiesBtn.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		
		WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitForVisibility(newView);
		newView.click();
		Thread.sleep(1000);
		
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.sendKeys("ABCD");
		Thread.sleep(1000);
		
		WebElement uniqueViewName = driver.findElement(By.xpath("//input[@id='devname']"));
		uniqueViewName.click();
		uniqueViewName.clear();
		Thread.sleep(1000);
		uniqueViewName.sendKeys("EFGH");
		Thread.sleep(3000);
		
		WebElement cancelBtn = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']"));
		waitForVisibility(cancelBtn);
		cancelBtn.click();
		
		Thread.sleep(3000);
		logout();
		
		Thread.sleep(2000);
		quitBrowser();
	}

}
