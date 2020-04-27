package automate.salesforce;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MySettingsTC07 extends BrowserUtitlity{
	
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement userNavBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitForVisibility(userNavBtn);
		userNavBtn.click();
		Thread.sleep(2000);
		
		WebElement myProfile =  driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		waitForVisibility(myProfile);
		myProfile.click();
		Thread.sleep(2000);
		
		
		WebElement personalInfo =  driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
		waitForVisibility(personalInfo);
		personalInfo.click();
		Thread.sleep(2000);
		
		
		WebElement LoginHistory =  driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		waitForVisibility(LoginHistory);
		LoginHistory.click();
		Thread.sleep(2000);
		
		WebElement LoginHistordownload =  driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		waitForVisibility(LoginHistordownload);
		//LoginHistordownload.click();
		Thread.sleep(2000);
		
		
		WebElement displayLayout =  driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
		waitForVisibility(displayLayout);
		displayLayout.click();
		Thread.sleep(2000);
		
		
		WebElement customizeTabs =  driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		waitForVisibility(customizeTabs);
		customizeTabs.click();
		Thread.sleep(2000);
		
		Select tabsDropDown = new Select(driver.findElement(By.id("p4")));
		tabsDropDown.selectByVisibleText("Salesforce Chatter");
		
		Select addFromDropDown = new Select(driver.findElement(By.xpath("//select[@id='duel_select_0']")));
		addFromDropDown.selectByValue("report");
		//JavascriptExecutor jsExe = (JavascriptExecutor)driver;
		//jsExe.executeScript("arguments[0].scrollIntoView();",addFromDropDown );
		
	
		WebElement addSelected =  driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		waitForVisibility(addSelected);
		addSelected.click();
		Thread.sleep(2000);
		
//		WebElement saveTabs =  driver.findElement(By.xpath("//input[@name='save']"));
//		waitForVisibility(saveTabs);
//		saveTabs.click();
//		Thread.sleep(2000);
		
		WebElement email =  driver.findElement(By.xpath("//span[@id='EmailSetup_font']"));
		waitForVisibility(email);
		email.click();
		Thread.sleep(2000);
		
		WebElement emailSettings =  driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
		waitForVisibility(emailSettings);
		emailSettings.click();
		Thread.sleep(2000);
		
		WebElement emailEle =  driver.findElement(By.xpath("//input[@id='sender_email']"));
		waitForVisibility(emailEle);
		emailEle.clear();
		String emailData = ReadUserData.getUserData("email");
		emailEle.sendKeys(emailData);
		Thread.sleep(2000);
		
		
		WebElement bccEle =  driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
		waitForVisibility(bccEle);
		bccEle.click();
		Thread.sleep(2000);
		
		
		WebElement saveEmail =  driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[contains(@name,'save')]"));
		waitForVisibility(saveEmail);
		saveEmail.click();
		Thread.sleep(2000);
		
		//Calenders and Remainders
		WebElement calRem =  driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
		waitForVisibility(calRem);
		calRem.click();
		Thread.sleep(2000);
		
		
		WebElement remaindersEle =  driver.findElement(By.xpath("//span[@id='Reminders_font']"));
		waitForVisibility(remaindersEle);
		remaindersEle.click();
		Thread.sleep(2000);
		
		
		WebElement TestBtn =  driver.findElement(By.xpath("//input[@id='testbtn']"));
		waitForVisibility(TestBtn);
		TestBtn.click();
		Thread.sleep(2000);
		
		//driver.close();
		
		Thread.sleep(2000);
		quitBrowser();
	}

}
