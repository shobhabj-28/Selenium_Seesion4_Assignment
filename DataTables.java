package com.ibm.seleniumconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataTables {
	
	public static void main(String[] args) {
				
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://datatables.net/");
		
		
		
		//xPath of the Table
	List<WebElement> rows= driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
	int noOfRows=rows.size();
	System.out.println(noOfRows);
	int total=0;
	for (int i=1;i<=noOfRows;i++)
	{
		WebElement nameEle = driver.findElement(By.xpath("//*[@id='example']/tbody/tr["+i+"]/td[1]"));
		nameEle.click();
		
		WebElement salEle = driver.findElement(By.xpath("//span[@class='dtr-data']"));
		String salary = salEle.getText().replace("$", "").replace(",","");
		total += Integer.parseInt(salary);
		nameEle.click();
		
		
	}
	System.out.println(total);
		}
	
}
