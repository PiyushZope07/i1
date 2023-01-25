package combindTEst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import combined.*;

import utilities.ScreenShot;
import utilities.ShipmentTest;

public class FlightsLoginPageTest {
	public static WebDriver driver;
	public static Sheet sh;
	public static JavascriptExecutor js;
	FlightsLoginPage fl;
	public static String url="https://irctc.co.in";
	ShipmentTest ft;
	String[][] bookingdata;
	ScreenShot ss;
	String sshot;
	//Logger log = LogManager.getLogger(FlightsloginPageTest.class.getName());

	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\IRCTC\\Persistent\\IRCTC\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
		ft=new ShipmentTest();
		fl=new FlightsLoginPage(driver);
	}

	
	
	//Airline page login with empty fields
	@Test(priority=1)
	public void Flightstc01(){
		
		try {
			bookingdata=ft.getData();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		driver.get(url);
		
		// click on OK button
		fl.okbutton();
		//click on menu tab
		fl.panel();
		//click on advertise x
		fl.add();
		//click on flights
		fl.flight();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
		//click on later
        fl.later();
        driver.switchTo().window(newTb.get(0));
        driver.close();
        driver.switchTo().window(newTb.get(1));
		
		//click on login link
        fl.Flogin();
		//enter username
		fl.Funame(" ");
		//enter password
		fl.Fpass(" ");
		//click login
		fl.Flogin2();
		
	}
	
	
	 //Airline page login with invalid credentials
	@Test(priority=2)
	public void Flightstc02(){
		
		try {
			bookingdata=ft.getData();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//load URL
		driver.get(url);
		
		// click on OK button
		fl.okbutton();
		//click on menu tab
		fl.panel();
		//click on advertise x
		fl.add();
		//click on flights
		fl.flight();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        driver.switchTo().window(newTb.get(0));
        driver.close();
        driver.switchTo().window(newTb.get(1));
		
		
        //fl.later();
        fl.Flogin();
		//enter username
		fl.Funame(bookingdata[2][0]);
		//enter password
		fl.Fpass(bookingdata[3][0]);
		//click login
		fl.Flogin2();
		
	}
	
	//Airline page login with valid credentials
	
		@Test(priority=3)
		public void Flightstc03() {
			
			try {
				bookingdata=ft.getData();
			} catch (InvalidFormatException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			//load URL
			driver.get(url);
			
			// click on OK button
			fl.okbutton();
			//click on menu tab
			fl.panel();
			//click on advertise x
			fl.add();
			//click on flights
			fl.flight();
			
			ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	        //switch to new tab
	        driver.switchTo().window(newTb.get(1));
	        driver.switchTo().window(newTb.get(0));
	        driver.close();
	        driver.switchTo().window(newTb.get(1));
			
	        //click on later
	       // fl.later();
	        //click on login link
			fl.Flogin();
			//enter username
			fl.Funame(bookingdata[0][0]);
			//enter password
			fl.Fpass(bookingdata[1][0]);
			//click login
			fl.Flogin2();
			
		}
		
	//Airline page search flights
	@Test(priority=4)
	public void Flightstc04() {
		
		try {
			bookingdata=ft.getData();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//load URL
		driver.get(url);
		
		// click on OK button
		fl.okbutton();
		//click on menu tab
		fl.panel();
		//click on advertise x
		fl.add();
		//click on flights
		fl.flight();
		ArrayList<String> newTb2 = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb2.get(1));
        driver.switchTo().window(newTb2.get(0));
        driver.close();
        driver.switchTo().window(newTb2.get(1));
        //Click on source city dropdown
		fl.from(bookingdata[0][1]);
		//select city
		fl.fromclick();
		//Click on destination dropdown
		fl.to(bookingdata[1][1]);
		//select city
		fl.toclick();
		//Click on date
		fl.date();
		//select date
		fl.dateclick();
		//click on search button
		fl.search();
		//validate displayed flight
		fl.disp();
		
	}
	
	//Airline page book flights
	@Test(priority=5)
	public void Flightstc05(){
		
		try {
			bookingdata=ft.getData();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//load URL
		driver.get(url);
		
		// click on OK button
		fl.okbutton();
		//click on menu tab
		fl.panel();
		//click on advertise x
		fl.add();
		//click on flights
		fl.flight();
		ArrayList<String> newTb5 = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb5.get(1));
        driver.switchTo().window(newTb5.get(0));
        driver.close();
        driver.switchTo().window(newTb5.get(1));
        //click on login link
        fl.Flogin();
        //enter username
        fl.Busername(bookingdata[0][0]);
		//enter password
		fl.Fpass(bookingdata[1][0]);
		//click login
		fl.Flogin2();
		
        
        //click on source city dropdown
        fl.from(bookingdata[0][1]);
        //select city 
		fl.fromclick();
		//click on destination city		
		fl.to(bookingdata[1][1]);
		//select city
		fl.toclick();
		//Click on date
		fl.date();
		//select date
		fl.dateclick();
		//click on search
		fl.search();
		//validate displayed flight
		fl.disp();
		//click on book button
		fl.book();
		//load new tab
		ArrayList<String> newTb1 = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb1.get(1));
        driver.switchTo().window(newTb1.get(0));
        driver.close();
        driver.switchTo().window(newTb1.get(1));
        //enter firstname
		fl.Bfname(bookingdata[0][2]);
		//enter lastname
		fl.Blname(bookingdata[1][2]);
		//click on name salutation dropdown
		fl.nselec1();
		//select salutation
		fl.nselec2();
		//scroll down the webpage
		js.executeScript("window.scrollBy(0,2400)", "");
		//click on gender dropdown
		fl.sselec1();
		//select gender
		fl.sselec2();
		
		
	}
	
	//Airline page Ticket Status
	@Test(priority=6)
	public void Flightstc06() {
		
		try {
			bookingdata=ft.getData();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		driver.get(url);
		
		// click on OK button
		fl.okbutton();
		//click on menu tab
		fl.panel();
		//click on advertise x
		fl.add();
		//click on flights
		fl.flight();
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        driver.switchTo().window(newTb.get(0));
        driver.close();
        driver.switchTo().window(newTb.get(1));
        //click on later
        //fl.later();
        //click on login link
		fl.Flogin();
		//enter username
		fl.Funame(bookingdata[0][0]);
		//enter password
		fl.Fpass(bookingdata[1][0]);
		//click login
		fl.Flogin2();
		//Click on profile icon
        fl.profile();
        //click on my account option
        fl.myacc();
        //click on Myjourny tab
        fl.bookedticket();
        //Click on profile 
        fl.profile();
        //click on logout
        fl.logout();
         
	}
 
	//Airline page Ticket Cancellation
	@Test(priority=7)
	public void Flightstc07(){
		
		try {
			bookingdata=ft.getData();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		driver.get(url);
		
		// click on OK button
		fl.okbutton();
		//click on menu tab
		fl.panel();
		//click on advertise x
		fl.add();
		//click on flights
		fl.flight();
		ArrayList<String> newTb3 = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb3.get(1));
        driver.switchTo().window(newTb3.get(0));
        driver.close();
        driver.switchTo().window(newTb3.get(1));
        //click on later
        //fl.later();
        //click on login link
		fl.Flogin();
		//enter username
		fl.Funame(bookingdata[0][0]);
		//enter password
		fl.Fpass(bookingdata[1][0]);
		//click login
		fl.Flogin2();
		//click on profile
       fl.profile();
       //click on my account tab
        fl.myacc();
       //click on ticket cancellation tab
        fl.cancelation();
        //click on profile icon
        fl.profile();
        //click on logout option
        fl.logout();
    }    
       

	//Airline page view full profile
	@Test(priority=8)
	public void Flightstc08() {
		
		try {
			bookingdata=ft.getData();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		driver.get(url);
		
		// click on OK button
		fl.okbutton();
		//click on menu tab
		fl.panel();
		//click on advertise x
		fl.add();
		//click on flights
		fl.flight();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        driver.switchTo().window(newTb.get(0));
        driver.close();
        driver.switchTo().window(newTb.get(1));
        //click on later
		
		//fl.later();
		//click on login
		
		fl.Flogin();
		
		//enter username
		fl.Funame(bookingdata[0][0]);
		//enter password
		fl.Fpass(bookingdata[1][0]);
		//click login
		fl.Flogin2();
		//click on profile
        fl.profile();
        //click on my account option
        fl.myacc();
        //click on profile panel
        fl.fullprofile();
        
        
        
       
	}

	@AfterTest
	public void tearDown() 
	{
		driver.close();
	}
	

}
