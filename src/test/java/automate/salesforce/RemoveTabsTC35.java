package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RemoveTabsTC35 extends BrowserUtitlity{
	
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement plusTab = driver.findElement(By.xpath("//img[@class='allTabsArrow']"));
		waitForVisibility(plusTab);
		plusTab.click();
		Thread.sleep(2000);
		
		WebElement customizeTab =  driver.findElement(By.xpath("//input[@name='customize']"));
		waitForVisibility(customizeTab);
		customizeTab.click();
		Thread.sleep(2000);

		Select selectedTabs = new Select(driver.findElement(By.xpath("//select[@id='duel_select_1']")));
		selectedTabs.selectByIndex(1);
		
		
		WebElement removeBtn = driver.findElement(By.xpath("//img[contains(@class,'leftArrowIcon')]"));
		waitForVisibility(removeBtn);
		removeBtn.click();
		Thread.sleep(2000);
		
		
		WebElement saveBtn = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		waitForVisibility(saveBtn);
		saveBtn.click();
		Thread.sleep(3000);
		logout();
		Thread.sleep(3000);
		login(false);
		Thread.sleep(4000);
		logout();
		Thread.sleep(3000);
		quitBrowser();
	}

}