package automate.salesforce;


public class SuccessLoginTC2 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		Thread.sleep(2000);
		quitBrowser();
		
		
	}
}
