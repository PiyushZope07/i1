

package combindTEst;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.apache.log4j.*;

import combined.IRCTC;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShot;
import utilities.ShipmentTest;

public class HomePage1 {

	public static WebDriver driver;
	public static Sheet sh;
	IRCTC i;
	public static JavascriptExecutor js ;
	public static String url="https://irctc.co.in";
	public static String pnr_url="https://www.indianrail.gov.in/enquiry/PNR/PnrEnquiry.html?locale=en";
	ShipmentTest ship;
	String[][] irctcdata;
	ScreenShot ss;
	String sshot;
	
	Logger logger;
	
	@BeforeTest
	public void setUp()
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(chromeOptions);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		ss=new ScreenShot();
		ship=new ShipmentTest();
		i=new IRCTC(driver);
		
		logger=Logger.getLogger("IRCTC");
		
	}
	
	@Test(priority=1)
	public void logintc01() throws Exception {
		
		
/* -------------------------------------------------------------------------------------------------------*/
		//SC01TC01--> To test login functionality with valid credentials
		irctcdata=ship.getData();
		driver.get(url);
		
		logger.debug("login with valid ");
		//click on OK button
		i.okButton();
		
		// click on panel for login
		i.panelClick();
		
		// calick on login button
		i.loginButton();
		
		
		//Enter username and password
		i.setUsername(irctcdata[0][0]);
		i.setPassword(irctcdata[0][1]);
		
		//To enter captcha manually we have given sleep of 10secs.
		Thread.sleep(10000);
		
		//click on login 
		i.signin();
		
		logger.debug("login with valid completed");
	}	
	@Test(priority=2)
	public void logintc02() throws Exception {
/* -------------------------------------------------------------------------------------------------------*/
		//SC01TC02--> To test login functionality with invalid credentials
		driver.get(url);
		logger.debug("login with invalid ");
		//click on OK button
		i.okButton();
		
		// click on panel for login
		i.panelClick();
		
		// click on login button
		i.loginButton();
		
		//Enter username and password
		i.setUsername(irctcdata[1][0]);
		i.setPassword(irctcdata[1][1]);
		
		//To enter captcha manually we have given sleep of 10secs.
		Thread.sleep(10000);
		
		//click on login 
		i.signin();
		logger.debug("login with invalid completed ");
	}
	
	@Test(priority=3)
	public void logintc03() throws Exception {

/* -------------------------------------------------------------------------------------------------------*/
		//SC01TC03--> To test login functionality with some empty fields
		
		driver.get(url);
		logger.debug("login with empty fields ");
		//click on OK button
		i.okButton();
		
		// click on panel for login
		i.panelClick();
		
		// click on login button
		i.loginButton();
		
		//Enter username and password
		i.setUsername("");
		i.setPassword("");
		
		//To enter captcha manually we have given sleep of 10secs.
		Thread.sleep(10000);
		
		//click on login 
		i.signin();
		logger.debug("login with empty fields completed ");
	}
	@Test(priority=4)
	public void searchtc01() throws InvalidFormatException, IOException {
		
/* -------------------------------------------------------------------------------------------------------*/
		//SC02TC01--> To test if trains for the route exists or not.
				
		
		
		driver.get(url);
				
		logger.debug("trains for the route exists or not ");
				
		// click on OK button
		i.okButton();
										
		// Enter Source station
		i.source(irctcdata[0][2]);
		i.sourceList();
				
		//checking whether source station is available or not 
		//s.sourceAvailable();
		System.out.println("Source Station Available:" +i.sourceAvailable());
				
		//Enter Destination Staion
		i.destination(irctcdata[1][2]);
		i.destinationList();
				
		//checking whether destination station is available or not 
		//s.destinationAvailable();		
		System.out.println("Destination Station Available:" + i.destinationAvailable());
		
		logger.debug("trains for the route exists or not done");
	}
	@Test(priority=5)
	public void searchtc02()throws InvalidFormatException, IOException {
		
		//SC02TC02--> To test mispelled word gives suggestion or not.
		
		driver.get(url);
		logger.debug("test mispelled word ");
		// click on OK button
		i.okButton();
						
		// Enter Source station
		i.source(irctcdata[2][2]);	
		
		//Enter Destination Station
		i.destination(irctcdata[3][2]);

		// Click on Search Button
		i.searchButton();
		
		logger.debug("test mispelled word done ");
	}
	
	@Test(priority=6)
	public void searchtc03()throws InvalidFormatException, IOException, InterruptedException {
		
		//SC02TC03--> To test if the search operation is allowed with user login credentials
		driver.get(url);
		logger.debug("search operation is allowed with user login credentials");
		// click on OK button
		i.okButton();
				
		// Enter Source station
		i.source(irctcdata[0][2]);
		i.sourceList();
		
		//Enter Destination Station
		i.destination(irctcdata[1][2]);
		i.destinationList();
		
		// Click on Search Button
		i.searchButton();

		//Scroll Down to see list of trains available or not 
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,500)", "");
		logger.debug("search operation is allowed withuser login credentials done ");

	}
	
	@Test(priority=7)
	public void searchtc04()throws InvalidFormatException, IOException, InterruptedException {
		
		//SC02TC03--> To test if the search operation is allowed without user login credentials
		driver.get(url);
		logger.debug("search operation is allowed without user login credentials done ");

		// click on OK button
		i.okButton();
		
		Thread.sleep(5000);
		// Enter Source station
		i.source("");
		Thread.sleep(5000);	
		//Enter Destination Station
		i.destination("");
				
		// Click on Search Button
		i.searchButton();

		//GEt error msg
		i.error();
		System.out.println("Error For Empty Fields:"+i.error());
		logger.debug("search operation is allowed without user login credentials done ");

	}
	@Test(priority=8)
	public void bookingtc01() throws Exception {
		
		
		driver.get(url);
		logger.debug("Booking TC01 ");

		// click on OK button
		i.okButton();
				
		// Enter Source station
		i.source(irctcdata[0][2]);
		i.sourceList();
			
		//Enter Destination Station
		i.destination(irctcdata[1][2]);
		i.destinationList();
		
		// Click on Search Button
		i.searchButton();
		
		//After Entering Login we need to click  class type of train and then click on  BOOK button
		i.tierButton();
		i.clAvailableButton();
		i.bookButton();
		
		// click on I-Agree
		i.iAgreeButton();
		logger.debug("Booking TC01 done ");
		// WIll redirect to login page ..without login cannot book ticket..	
	}
	
	@Test(priority=9)
	public void bookingtc02() throws Exception {
		
		logger.debug("Booking TC02 ");
		driver.get(url);
		
		// click on OK button
		i.okButton();
				
		// Enter Source station
		i.source(irctcdata[0][2]);
		i.sourceList();
			
		//Enter Destination Station
		i.destination(irctcdata[1][2]);
		i.destinationList();
		
		// Click on Search Button
		i.searchButton();
		
		//After Entering Login we need to click  class type of train and then click on  BOOK button
		i.tierButton();
		i.clAvailableButton();
		i.bookButton();
		
		//click on I-Agree
		i.iAgreeButton();
		
		//Enter Username And password
		i.setUsername(irctcdata[0][0]);
		i.setPassword(irctcdata[0][1]);
		
		//To enter captcha manually we have given sleep of 10secs.
		Thread.sleep(20000);
				
		//Click on Sign in
		i.signin();
		
		//Enter Passenger Details
		i.passengerName(irctcdata[0][3]);
		i.passengerAge(irctcdata[1][3]);
		i.Gender();
		i.Birth();
		i.mobileNumber(irctcdata[2][3]);
		i.submitButton();
		
		js.executeScript("window.scrollBy(0,600)", "");
		
		//Entr Confirmation Captcha
		Thread.sleep(10000);
		
		i.reviewButton();
		js.executeScript("window.scrollBy(0,550)", "");
		logger.debug("Booking TC02 done ");
	}
	
	@Test(priority=10)
	public void bookingtc03() throws Exception {
		
		
		driver.get(url);
		logger.debug("Booking TC03 ");
		// click on OK button
		i.okButton();
				
		// Enter Source station
		i.source(irctcdata[0][2]);
		i.sourceList();
			
		//Enter Destination Station
		i.destination(irctcdata[1][2]);
		i.destinationList();
		
		// Click on Search Button
		i.searchButton();
		
		//After Entering Login we need to click  class type of train and then click on  BOOK button
		i.tierButton();
		i.clAvailableButton();
		i.bookButton();
		
		//click on I-Agree
		i.iAgreeButton();
		
		//Enter Username And password
		i.setUsername(irctcdata[0][0]);
		i.setPassword(irctcdata[0][1]);
		
		//To enter captcha manually we have given sleep of 10secs.
		Thread.sleep(20000);
				
		//Click on Sign in
		i.signin();
		
		//Enter Passenger Details
		i.passengerName(irctcdata[0][3]);
		i.passengerAge(irctcdata[1][3]);
		i.Gender();
		i.Birth();
		i.mobileNumber(irctcdata[2][3]);
		i.submitButton();
		
		js.executeScript("window.scrollBy(0,600)", "");
		
		i.reviewButton();
		js.executeScript("window.scrollBy(0,550)", "");
		
		i.withoutCaptcha();
		System.out.println("Error Message wihout Captcha Verification:"+i.withoutCaptcha());
		logger.debug("Booking TC03 done ");
	}
	

	@Test(priority=11)
	public void pnrtc01() throws Exception {
		
		
		driver.get(pnr_url);
		
		logger.debug("PNR tc01 ");
//		//Go to new Window and go by pnr url
//		i.tabSwitch();
//		driver.get(pnr_url);
//		i.tabSwitch1();
				
		// Click on Pnr input and enter the 10 digits pnr number 
		i.pnrInput(irctcdata[0][4]);
		
		// click on submit
		i.pnrSubmit();
		
		// for captcha  and submit
		Thread.sleep(10000);
		i.captchaSubmitButton();
		i.js250();
		
		//Get Confirm Message TExt
		i.confirmPnrMsg();
		System.out.println("Confirm Pnr Message:"+i.confirmPnrMsg());
		
		Thread.sleep(3000);

		ss.takeSnapShot(driver, "C:\\Users\\piyush_zope\\eclipse-workspace\\IRCTC-MINI-PROJECT\\src\\test\\resources\\Screenshot\\CONFIRMPNR1.png"); 
		logger.debug("PNR tc01 done ");

	}
	
	@Test(priority=12)
	public void pnrtc02() throws Exception {
		
		logger.debug("PNR tc02 ");

		//Click on PNR Enquiry Button Button
		i.pnrEnquiryButton();
				
		// Click on Pnr input and enter the 10 digits pnr number 
		i.pnrInput(irctcdata[1][4]);
		
		// click on submit
		i.captchaSubmitButton();
		
		
		//Get Waiting Message TExt
		i.WaitingPnrMsg();
		System.out.println("Waiting Pnr Message:"+i.WaitingPnrMsg());
		
		Thread.sleep(3000);
		ss.takeSnapShot(driver, "C:\\Users\\piyush_zope\\eclipse-workspace\\IRCTC-MINI-PROJECT\\src\\test\\resources\\Screenshot\\WAITINGPNR1.png");
		logger.debug("PNR tc02 done ");

	}
	
	@Test(priority=13)
	public void pnrtc03() throws InvalidFormatException, IOException, InterruptedException {
		logger.debug("PNR tc03 ");
	
		//Click on PNR Enquiry Button Button
		i.pnrEnquiryButton();
				
		// Click on Pnr input and enter the 10 digits pnr number 
		i.pnrInput(irctcdata[2][4]);
		
		// click on submit
		i.captchaSubmitButton();
		
		//Get Error Message TExt
		i.errorMsg();
		System.out.println("Error Pnr Message:"+i.errorMsg());
		logger.debug("PNR tc03 done ");

	}
	
	@Test(priority=14)
	public void canceltc() throws InterruptedException, InvalidFormatException, IOException {
		
		driver.get(url);
		logger.debug("Cancel ");

		//click on OK button
		i.okButton();
		
		// click on panel for login
		i.panelClick();
		
		// click on login button
		i.loginButton();
		
		//Enter username and password
		i.setUsername(irctcdata[0][0]);
		i.setPassword(irctcdata[0][1]);
		
		//To enter captcha manually we have given sleep of 10secs.
		Thread.sleep(10000);
		
		//click on login 
		i.signin();
		
		// click on panel again
		i.panelClick();
		
		// click on trains
		i.trains();
		// click on Cancel Ticket
		i.cTicket();
				
		// click on E-Ticket
		i.eTicket();
		logger.debug("Cancel done ");
		
		
		

	}
	@AfterTest
	
	public void tearDown() {
		driver.close();
	}
	
	
	
	
}
