package automate.salesforce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditViewTC12 extends BrowserUtitlity {
	public static void main(String[] args) throws Exception{
		launchBrowser("ch");
		login(false);
		Thread.sleep(2000);
		
		
		
		// Click on Account Tab
		WebElement accountsTab = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		waitForVisibility(accountsTab);
		accountsTab.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lighteneing experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		//Thread.sleep(2000);
		
		//Select view to edit
		waitForVisibility(driver.findElement(By.xpath("//select[@id='fcf']")));
		Select tabsDropDown = new Select(driver.findElement(By.id("fcf")));
		tabsDropDown.selectByVisibleText("Example1");
		Thread.sleep(2000);
		
		//Click on Edit
		WebElement editView = driver.findElement(By.xpath("//span[@class='fFooter']//a[contains(text(),'Edit')]"));
		waitForVisibility(editView);
		editView.click();
		Thread.sleep(2000);
		
		//Enter View Name
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		waitForVisibility(viewName);
		viewName.clear();
		viewName.sendKeys("Example");
		Thread.sleep(2000);
		
		//Enter Unique view name
		WebElement UniqueView = driver.findElement(By.xpath("//input[@id='devname']"));
		waitForVisibility(UniqueView);
		UniqueView.clear();
		UniqueView.sendKeys("Example");
		Thread.sleep(2000);
		
		//select the field to filter
		Select selectField = new Select(driver.findElement(By.id("fcol1")));
		selectField.selectByVisibleText("Customer Priority");      
		Thread.sleep(2000);
		
		//Select filter condition
		Select selectOperator = new Select(driver.findElement(By.id("fop1")));
		selectOperator.selectByVisibleText("equals");
		Thread.sleep(2000);
		
		// send value to filter
		WebElement value = driver.findElement(By.xpath("//input[@id='fval1']"));
		waitForVisibility(value);
		value.clear();
		value.sendKeys("High");
		Thread.sleep(2000);
		
		Select addFromDropDown = new Select(driver.findElement(By.xpath("//select[@id='colselector_select_0']")));
		//List<WebElement> eleList = addFromDropDown.getOptions();
		addFromDropDown.selectByVisibleText("Customer Priority");
//		WebElement addField = driver.findElement(By.xpath("//select[@id='colselector_select_0']//option[contains(text(),'Customer Priority')]"));
//		waitForVisibility(addField);
//		addField.click();
		Thread.sleep(2000);
		
		//Click on add button 
		WebElement addBtn = driver.findElement(By.xpath("//a[@id='colselector_select_0_right']//img[@class='rightArrowIcon']"));
		waitForVisibility(addBtn);
		addBtn.click();
		
		
		//click on save the account
		WebElement accountSaveBtn = driver.findElement(By.xpath("//div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]"));
		waitForVisibility(accountSaveBtn);
		accountSaveBtn.click();
		
		
		Thread.sleep(3000);
		quitBrowser();

	}

}
