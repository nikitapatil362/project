package test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AmazonWebDriverScripting {
	public static WebDriver driver;
	public static Properties prop;
	public static String sAppURL;
	public static String username;
	public static String password;
	
	@Test
	public void test() {

		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		
		//driver.findElement(By.id("password")).sendKeys("Nikitapatil@362");
		driver.findElement(By.id("#ap_email")).sendKeys("nikitapatil362@gmail.com");
		driver.findElement(By.id("#continue")).click();
	}
	
	
	@Before
	public void setUp() throws FileNotFoundException,IOException{
		try {
			prop = new Properties();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		prop.load(new FileInputStream("C:\\Users\\nikit\\eclipse-workspace\\AmazonAppAutomation\\Configuration\\Amazon_Confiduration.properties"));
		sAppURL = prop.getProperty("sAppURL");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
	

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().minimize();
	}
	@After
	public void tearDown() throws Exception {
	//driver.quit();
	}
	
	}

}
