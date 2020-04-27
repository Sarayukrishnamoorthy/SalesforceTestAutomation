package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtitlity extends  ReadUserData {

public static WebDriver driver = null;
	
	static void launchBrowser(String sBrowser){
		
		if(sBrowser.startsWith("ch")) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		} else {
			System.out.println("You have not given browser type correctly");
		}
		
		driver.manage().window().maximize(); 
		driver.get("https://login.salesforce.com/"); 
		
	}

	static void quitBrowser(){
		driver.quit();
	}
	static void login(boolean rememberMe) {
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle);
		String username = ReadUserData.getUserData("username");
		usernameEle.sendKeys(username);
		
		WebElement passwordEle = driver.findElement(By.xpath("//input[@id='password']"));
		String password = ReadUserData.getUserData("password");
		passwordEle.sendKeys(password);
		
		if (rememberMe) {
			rememberMe();
		}
		
		WebElement loginEle = driver.findElement(By.xpath("//input[@id='Login']"));
		loginEle.click();

		waitForVisibility(driver.findElement(By.xpath("//a[contains(text(), 'Home')]")));
	}
	
	static void rememberMe() {
		WebElement rememberMeEle = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		waitForVisibility(rememberMeEle);
		if(!rememberMeEle.isSelected()) {
			rememberMeEle.click();
		}
		
	}
	
	static void logout() throws Exception {
		WebElement userNavBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitForVisibility(userNavBtn);
		userNavBtn.click();
		
		WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		waitForVisibility(logoutBtn);
		logoutBtn.click();
		Thread.sleep(2000);
		
	}
	static void waitForVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	static void mouseHover(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

}
