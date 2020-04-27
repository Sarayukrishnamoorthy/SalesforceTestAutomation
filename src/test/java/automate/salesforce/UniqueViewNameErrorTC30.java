package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class UniqueViewNameErrorTC30 extends BrowserUtitlity {

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
		viewName.sendKeys("view1");
		Thread.sleep(1000);
		
		WebElement uniqueViewName = driver.findElement(By.xpath("//input[@id='devname']"));
		uniqueViewName.clear();
		uniqueViewName.sendKeys("UniqueName : ABCD");
		Thread.sleep(1000);
		
		WebElement saveBtn = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		waitForVisibility(saveBtn);
		saveBtn.click();
		
		WebElement errorEle = driver.findElement(By.xpath("//div[contains(text(),'The View Unique Name field can only contain unders')]"));
		System.out.println("Error Msg is : "+errorEle.getText());
		
		Thread.sleep(3000);
		logout();
		
		Thread.sleep(2000);
		quitBrowser();
	}

}
