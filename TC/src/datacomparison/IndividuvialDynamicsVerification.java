package datacomparison;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class IndividuvialDynamicsVerification {
	private WebDriver driver;
	private String Firstname,Lastname,Addressline1,State,City,Zipcode,Country,Phonenumber,Birthdate,Membershipdate;
	private String WAemail;
	private String url;
  @BeforeTest
  public void beforeTest() throws IOException, InterruptedException {
	  System.setProperty("webdriver.ie.driver", "C:/IE/IEDriverServer.exe");
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);   
	  cap.setJavascriptEnabled(true);
	  driver = new InternetExplorerDriver(cap); 
	  driver.manage().window().maximize();
	  Properties prop = new Properties();
	  FileInputStream file2 = new FileInputStream(System.getProperty("user.dir")+"\\tc.properties");
	  prop.load(file2);
	  url = prop.getProperty("cmmurl");
	  driver.get(url);
	  FileInputStream file = new FileInputStream(new File("D:\\IEmail.xls"));
	  HSSFWorkbook workbook = new HSSFWorkbook(file);
	  HSSFSheet sheet = workbook.getSheet("Email Worksheet");
	  int rowcount = sheet.getLastRowNum()- sheet.getFirstRowNum();
	  Row row = sheet.getRow(0);
	  DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
	  //Code to read member's data from excel sheet
	  Cell cell = sheet.getRow(0).getCell(0);
	   WAemail = formatter.formatCellValue(cell);
	  System.out.println(WAemail);
	  Cell cell1 = sheet.getRow(0).getCell(1);
	   Firstname = formatter.formatCellValue(cell1);
	  System.out.println(Firstname);
	  Cell cell2 = sheet.getRow(0).getCell(2);
	  Lastname = formatter.formatCellValue(cell2);
	  Cell cell3 = sheet.getRow(0).getCell(3);
	   Birthdate = formatter.formatCellValue(cell3);
	  Cell cell4 = sheet.getRow(0).getCell(4);
	  Membershipdate = formatter.formatCellValue(cell4);
	  Cell cell5 = sheet.getRow(0).getCell(5);
	  Country = formatter.formatCellValue(cell5);
	  Cell cell6 = sheet.getRow(0).getCell(6);
	   City = formatter.formatCellValue(cell6);
	  Cell cell7 = sheet.getRow(0).getCell(7);
	  Zipcode = formatter.formatCellValue(cell7);
	  Cell cell8 = sheet.getRow(0).getCell(8);
	  State = formatter.formatCellValue(cell8);
	//End of code to read data from excel sheet
	  driver.findElement(By.id("Tab1")).click();
	  Thread.sleep(8000);
	  driver.findElement(By.id("CMM")).click();
	  driver.switchTo().frame("contentIFrame1");
	  driver.switchTo().frame("dashboardFrame");
	  driver.switchTo().frame("WebResource_ConsumerSearch");
	  driver.findElement(By.id("TXT_Email")).sendKeys(WAemail);
	  WebDriverWait wait = new WebDriverWait(driver,15);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("Search")));
	  driver.findElement(By.id("Search")).click();
	  WebDriverWait waite = new WebDriverWait(driver,15);
	  waite.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[4]/div[2]/div/table/tbody/tr[2]/td[2]/a")));
	  driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/table/tbody/tr[2]/td[2]/a")).click();
	  String parent=driver.getWindowHandle();
	  java.util.Set<String> hand = driver.getWindowHandles();
	  String windbefore = (String)hand.toArray()[0];
      String windafter = (String)hand.toArray()[1];
	  driver.switchTo().window(windafter);
	  driver.manage().window().maximize();
	  driver.switchTo().frame("contentIFrame0");
  }
  @Test(priority=0)
  public void datacomparison() throws InterruptedException {
	  Thread.sleep(5000);
	  String firstname = driver.findElement(By.xpath(".//*[@id='firstname']/div[1]/span")).getText();
	    Assert.assertEquals(firstname, Firstname);
	     System.out.println(Firstname);
		 System.out.println("first name of member is " + firstname);
		 Thread.sleep(3000);
		 String lastname = driver.findElement(By.xpath(".//*[@id='lastname']/div[1]/span")).getText();
	     Assert.assertEquals(lastname, Lastname);
		 System.out.println("last name of member is " + lastname);
		 String birthdate = driver.findElement(By.xpath(".//*[@id='birthdate']/div[1]/span")).getText();
		 Assert.assertEquals(birthdate, Birthdate);
		 System.out.println("birth date of member is" + birthdate);
		 String parentaccount = driver.findElement(By.xpath(".//*[@id='parentcustomerid']/div[1]/span[1]")).getText();
		 System.out.println("parent account of member is " + parentaccount);
		 String lifetimevalue = driver.findElement(By.xpath(".//*[@id='gr_lifetimedollarvalue']/div[1]/span")).getText();
		 System.out.println("lifetime value  is "+ lifetimevalue);
		 String phonenumber = driver.findElement(By.xpath(".//*[@id='telephone1']/div[1]/span/a")).getText();
		 System.out.println("phonenumber of member is "+ phonenumber);
		 String membershiptitle = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[2]/nobr")).getText();
		 System.out.println("membership title is" + membershiptitle);
		 String membershipstatus = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[3]/div")).getText();
		 System.out.println("membershipstatus is " + membershipstatus);
		 String membershipstartdate = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[4]/div")).getText();
		 System.out.println("membership startdate is " + membershipstartdate);
		 Assert.assertEquals(membershipstartdate, Membershipdate);
		 System.out.println("First name,last name,dob,membership date,birth date fields in dynamics contains data which user entered from grcom");
		 String membershipenddate = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[5]/div")).getText();
		 System.out.println("membership end date is " + membershipenddate);
		 String membershipcreatedon = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[7]/div")).getText();
		 System.out.println("membership is created on " + membershipcreatedon);
		 String amountcharged = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[4]/div")).getText();
		 System.out.println("amount charged for membership is " + amountcharged);
		 String source = driver.findElement(By.xpath(".//*[@id='footer_gr_source1']/div/span")).getText();
		 System.out.println("source of memberhip is " + source);
		 String mcountry = driver.findElement(By.xpath(".//*[@id='gr_address1_country']/div[1]/span")).getText();
		 Assert.assertEquals(mcountry, Country);
		 System.out.println("mailing country is " + mcountry);
		 String mcity = driver.findElement(By.xpath(".//*[@id='address1_city']/div[1]/span")).getText();
		 System.out.println("mailing city is " + mcity);
		 Assert.assertEquals(mcity, City);
		 String mstate = driver.findElement(By.xpath(".//*[@id='gr_address1_state']/div[1]/span[1]")).getText();
		 Assert.assertEquals(mstate, State);
		 System.out.println("mailing state is "  + mstate);
		 String mzipcode = driver.findElement(By.xpath(".//*[@id='address1_postalcode']/div[1]/span")).getText();
		 Assert.assertEquals(mzipcode, Zipcode);
         System.out.println("mailing address zipcode is"  + mzipcode);
		 String maddressline1 = driver.findElement(By.xpath(".//*[@id='address1_line1']/div[1]/span")).getText();
		// Assert.assertEquals(maddressline1, Addressline1);
		 System.out.println("mailing address line1 is" + maddressline1);
		 System.out.println("Mailing Address fields in dynamics contains data which user entered from grcom");
  }
  @Test(priority=1,enabled=false)
  public void ResidentialAddress() throws InterruptedException {
	Thread.sleep(10000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/table/tbody/tr[2]/td/div/span/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]/nobr/a")).click();
	Thread.sleep(10000);
	driver.switchTo().frame("contentIFrame0");
	String residentialaddressline1 = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[2]/div")).getText();
	//Assert.assertEquals(residentialaddressline1, Addressline1);
	System.out.println("Residential address line1 is " + residentialaddressline1);
	String residentialaddresscity = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[4]/div")).getText();
	//Assert.assertEquals(residentialaddresscity, City);
	System.out.println("Residential address city is" + residentialaddresscity);
	String residentialaddressstate = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[5]/nobr")).getText();
	Assert.assertEquals(residentialaddressstate, State);
	System.out.println("Residential address state is "+ residentialaddressstate);
	String residentialaddresscountry = driver.findElement(By.xpath(".//*[@id='gridBodyTable']/tbody/tr/td[7]/nobr")).getText();
	Assert.assertEquals(residentialaddresscountry, Country);
	System.out.println("Residential address country is " +residentialaddresscountry);
	System.out.println("Residential Address fields in dynamics contains data which user entered from grcom");
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
