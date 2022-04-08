package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
		    try
		    {
		        String RESULT_PATH = "c:\\nikita\\output.txt";
				String mysearchresult1 = "";
				String mysearchresult2 = "";
				String mysearchresult3 = "";
				String mysearchresult4 = "";
				String mysearchresult5 = "";
				
				File file = new File(RESULT_PATH);
				if (!file.exists()){
				file.createNewFile();
				}		
				{
				System.setProperty("webdriver.chrome.driver", "E:\\geckodriver-v0.29.0-win64\\chromedriver.exe");
		        ChromeDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://www.amazon.com");
		        
				
				driver.findElement(By.id("twotabsearchtextbox")).click();
		        driver.findElement(By.id("twotabsearchtextbox")).clear();
		        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("charger");
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        driver.findElement(By.id("nav-search-bar-form")).submit();
		   
		driver.findElement(By.id("a-autoid-0-announce")).click();
		        System.out.println("I have reached search results click!");

		        driver.findElement(By.id("s-result-sort-select_2")).click();
		        
		        WebDriverWait we = new WebDriverWait(driver,60);
		        		we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Related searches']")));
				//WebElement we = new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Related searches']")));
		        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS).;
				List<WebElement> resultsList = driver.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
				
		int size = resultsList.size();
		        System.out.println("Size of list = " + size);
		        
				//resultsList.get(1).click();
				mysearchresult1 = resultsList.get(1).toString();
				//mysearchresult2 = resultsList.get(2).toString();
				//mysearchresult3 = resultsList.get(3);
				//mysearchresult4 = resultsList.get(4);
				//mysearchresult5 = resultsList.get(5);
				
		System.out.println("search result 1 = " + mysearchresult1);
				//System.out.println("search result 2 = " + mysearchresult2);
				//System.out.println("search result 3 = " + mysearchresult3);
				//System.out.println("search result 4 = " + mysearchresult4);
				//System.out.println("search result 5 = " + mysearchresult5);

		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(mysearchresult1);
			//os.writeObject(mysearchresult2);
			//os.writeObject(mysearchresult3);
			//os.writeObject(mysearchresult4);
			//os.writeObject(mysearchresult5);
			os.close();
				
		}
				catch(TimeoutException e) 
			
		    {
		        System.out.println(e);
		        }   
	}

}
	
