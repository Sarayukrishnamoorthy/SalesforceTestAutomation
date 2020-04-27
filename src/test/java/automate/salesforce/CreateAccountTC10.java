package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountTC10 extends BrowserUtitlity{

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
		
		//Click on New
		WebElement newButton = driver.findElement(By.xpath("//input[@name='new']"));
		waitForVisibility(newButton);
		newButton.click();
		Thread.sleep(2000);
		
		//ENter account name
		WebElement accountName = driver.findElement(By.xpath("//input[@id='acc2']"));
		waitForVisibility(accountName);
		accountName.sendKeys("primary");
		
		
		//Select Technology partner from type drop down
		Select typeDropDown = new Select(driver.findElement(By.xpath("//select[@id='acc6']")));
		typeDropDown.selectByVisibleText("Technology Partner");//option[contains(text(),'Technology Partner')]
		Thread.sleep(2000);
		
		//Select Customer Priority
		Select cusPriority = new Select(driver.findElement(By.id("00N5w00000HaM4l")));
		cusPriority.selectByVisibleText("High");
		Thread.sleep(2000);
		
		//click on save the account
		WebElement accountSaveBtn = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		waitForVisibility(accountSaveBtn);
		accountSaveBtn.click();
		
		Thread.sleep(3000);
		quitBrowser();
		
		
	}
}
