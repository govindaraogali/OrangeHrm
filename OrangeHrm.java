package nageswarao;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class OrangeHrm {
	public static WebDriver driver;
	Workbook wb;
	Sheet sh;
	int numrow;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\eclipse-workspace\\TejaKkd\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

}
	
	@Test(dataProvider = "testdata")
		public void loginhrms(String uname, String pass1) {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.findElement(By.name("username")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(pass1);
			driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a")).click();
			WebElement eName=  driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[1]/div/div[2]/div/div/input"));
			eName.sendKeys("Govind");
			
			 Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/i")));

		        // Select the desired option by visible text.
		        String optionToSelect = "Option 1";
		        dropdown.selectByVisibleText(optionToSelect);
			
			driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a")).click();
	
	}
			
			
			
			
			
		
	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() {
		try {
			wb = Workbook.getWorkbook(new File("C:/Users/ACER/Desktop/Book1.xls"));
			sh = wb.getSheet(0);
			numrow = sh.getRows();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Object[][] orangedata = new Object[numrow][sh.getColumns()];
		int i;
		for (i = 0; i < numrow; i++) {
			orangedata[i][0] = sh.getCell(0, i).getContents();
			orangedata[i][1] = sh.getCell(1, i).getContents();
			
		}
		return orangedata;
	}
	
	public void empForm() {
		// for job title
	WebElement jobTitle =	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[2]/div/div[1]/label"));
	jobTitle.getText();
	
	// for job subUnit
	WebElement subUnit =	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[3]/div/div[1]/label"));
	subUnit.getText();
	
	//// for job Include
	WebElement include =	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[4]/div/div[1]/label"));
	include.getText();
	
	// for job Review Status
		WebElement review =	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[5]/div/div[1]/label"));
		review.getText();
		
		// From Date
		WebElement fDate =	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[6]/div/div[1]/label"));
		fDate.getText();
		
		// for job To Date
		WebElement tDate =	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[3]/div/div[1]/label"));
		tDate.getText();
	 
		// for Reset
				WebElement reset =	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[3]/div/div[1]/label"));
				reset.getText();
	
	// for Search
				WebElement search =	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div[3]/div/div[1]/label"));
				search.getText();
				
				
				
				
				
	}
	
	 
@AfterMethod
public void aftermethod() {
driver.quit();

	
}}

