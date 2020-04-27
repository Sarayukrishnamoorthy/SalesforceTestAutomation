package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewViewTC11 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception{
		launchBrowser("ch");
		login(false);
		Thread.sleep(2000);
		
		// Click on Account Tab
		WebElement accountsTab = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		waitForVisibility(accountsTab);
		accountsTab.click();
		Thread.sleep(2000);
		
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		
		//Click on create new view
		WebElement newView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitForVisibility(newView);
		newView.click();
		Thread.sleep(2000);
		
		//Enter View Name
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		waitForVisibility(viewName);
		viewName.clear();
		viewName.sendKeys("viewName");
		Thread.sleep(2000);
		
		//Enter Unique view name
		WebElement UniqueView = driver.findElement(By.xpath("//input[@id='devname']"));
		waitForVisibility(UniqueView);
		UniqueView.clear();
		UniqueView.sendKeys("UniqueViewName");
		Thread.sleep(2000);
		
		//click on save the account
		WebElement accountSaveBtn = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
		waitForVisibility(accountSaveBtn);
		accountSaveBtn.click();
		
		Thread.sleep(3000);
		quitBrowser();

	}

}
