package newmembership;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Individuvial {
	private WebDriver driver;
	private String WAemail;
	private String WSemail;
	private String DAemail;
	private String DMemail;
	private String firstname,lastname,addressline1,state,city;
	private String price,zipcode,country,phonenumber,birthdate,membershipdate;
	private String url;
	
   @BeforeTest(enabled=true, description = "This method initialize Firefox driver" ,alwaysRun = true)
   public void beforeTest() throws IOException {
	  Properties prop = new Properties();
	  FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "//tc.properties");
	  prop.load(file);
	  driver = new FirefoxDriver();
	  url = prop.getProperty("grcomurl");
	  
   }

	  
  @BeforeMethod(enabled=true, description = "This method open grcom select plan page",alwaysRun = true)
  public void beforeMethod() {
	  driver.get(url);
	  driver.manage().window().maximize();
  }
  @Test(enabled=true,priority=0,groups={"worldwide"})
  public void WorldwideAnnual() throws InterruptedException {
	  int ran;
	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("test"+ran +"@yahoo.com");
	//   price = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/span/div/div/div/div/span/span[1]/div/div/h2/b")).getText();
	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	   WebDriverWait wait = new WebDriverWait(driver,50);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				 .id("signUpForm:firstNameTxtField")));
	    driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
	    Thread.sleep(2000);
	    firstname =  driver.findElement(By.id("signUpForm:firstNameTxtField")).getAttribute("value");
	    System.out.println(firstname);
	    driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
	    lastname =  driver.findElement(By.id("signUpForm:lastNameTxtField")).getAttribute("value");
	    System.out.println(lastname);
	    driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
	    driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
	    zipcode =  driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).getAttribute("value");
	    System.out.println(zipcode);
	    driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
	    addressline1 =  driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).getAttribute("value");
	    System.out.println(addressline1);
	    Select select=  new Select(driver.findElement(By.id("signUpForm:membershipAddressStateDD")));
	    select.selectByVisibleText("Alabama");
	   // WebDriverWait waits = new WebDriverWait(driver,15);
	  //  waits.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("signUpForm:membershipAddressStateDD"))));
	   // WebElement option = select.getFirstSelectedOption();
	   // state=option.getText();
        driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("Abbeville");
        city =  driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).getAttribute("value");
	    System.out.println(city);
	    driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
	    phonenumber =  driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).getAttribute("value");
	    System.out.println(phonenumber);
	    driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("2/2/1992");
	    birthdate =  driver.findElement(By.id("signUpForm:birthDateInputDate")).getAttribute("value");
	    System.out.println(birthdate);
	    driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("6/6/2016");
	    membershipdate =  driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).getAttribute("value");
	    System.out.println(membershipdate);
	    driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
	   WAemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
	   System.out.println("email of member having worldwide annual membership is " + WAemail);
	   Thread.sleep(4000);
	   country=  driver.findElement(By.xpath(".//*[@id='signUpForm:membershipAddressCountryDD']")).getAttribute("value");
	   System.out.println(country);
	   Thread.sleep(5000);
	   driver.findElement(By.id("signUpForm:submitTravelInsuranceYesBtn")).click();
	   Thread.sleep(5000);
	   driver.findElement(By.xpath(".//*[@id='signUpForm:returnDateInputDate']")).sendKeys("06/10/2016");
	   driver.findElement(By.id("signUpForm:tipCostTxtField")).sendKeys("100");
	   Thread.sleep(4000);
	   driver.findElement(By.id("signUpForm:membershipTravelInsuranceBtn")).click();
	   Thread.sleep(8000);
	   driver.findElement(By.id("signUpForm:membershipTravelInsuranceBtn")).click();
	  }
	      
  
  @Test(enabled=true,priority=1,groups={"worldwide"})
  public void Shortterm() throws InterruptedException {
	  int ran;
	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  WebDriverWait waitm = new WebDriverWait(driver,15);
	  waitm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='signUpForm:termShortBtn']")));
	  driver.findElement(By.id("signUpForm:termShortBtn")).click(); 
	  Thread.sleep(2000);
	  WebDriverWait waitt = new WebDriverWait(driver,15);
	  waitt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("test"+ran +"@yahoo.com");
	  WebDriverWait waitc = new WebDriverWait(driver,15);
	  waitc.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:planSelectionContinueBtn")));
	  Thread.sleep(2000);
	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	   WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:firstNameTxtField")));
	    driver.findElement(By.id("signUpForm:firstNameTxtField")).clear();
	    driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
	    driver.findElement(By.id("signUpForm:lastNameTxtField")).clear();
	    driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
	    driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
	    driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
	    driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
	    Select select = new Select(driver.findElement(By.id("signUpForm:membershipAddressStateDD")));
	    select.selectByVisibleText("Alabama");
	    driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("Abbeville");
	    driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
	    driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1992");
	    driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2023");
	    driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
	    Thread.sleep(5000);
	     WSemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
	     System.out.println("email of member having worldwide shortterm membership is " + WSemail);
	     driver.findElement(By.id("signUpForm:submitTravelInsuranceYesBtn")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//*[@id='signUpForm:returnDateInputDate']")).sendKeys("06/10/2023");
		 driver.findElement(By.id("signUpForm:tipCostTxtField")).sendKeys("100");
		 Thread.sleep(4000);
		 driver.findElement(By.id("signUpForm:membershipTravelInsuranceBtn")).click();
		 Thread.sleep(8000);
		 driver.findElement(By.id("signUpForm:membershipTravelInsuranceBtn")).click();
  }
  @Test(enabled=false,priority=2,groups={"Domestic"})
  public void DomesticAnnual() throws InterruptedException {
	  int ran;
	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  WebDriverWait waitem = new WebDriverWait(driver,25);
	  waitem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("test"+ran +"@yahoo.com");
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[1]/div/div[2]/div/div[2]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[4]/div/div/span/div/div[1]/div/ul/li[4]/a")).click();
	  WebDriverWait waitv = new WebDriverWait(driver,15);
	  waitv.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:planSelectionContinueBtn")));
	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	  WebDriverWait wait = new WebDriverWait(driver,50);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By
				 .id("signUpForm:firstNameTxtField")));
	    driver.findElement(By.id("signUpForm:firstNameTxtField")).clear();
	    driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
	    driver.findElement(By.id("signUpForm:lastNameTxtField")).clear();
	    driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
	    driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
	    driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
	    driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
	  //  new Select(driver.findElement(By.id("signUpForm:membershipAddressStateDD"))).selectByVisibleText("Alabama");
	    Thread.sleep(3000);
	    driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("city");
	    driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
	    driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1992");
	    driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2016");
	    driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
	    DAemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
	     System.out.println("email of member having domestic annual membership is " + DAemail);
	    
  }
  @Test(enabled=false,priority=3,groups={"Domestic"})
  public void DomesticMonthly() throws InterruptedException { 
	  int ran;
	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  WebDriverWait waitem = new WebDriverWait(driver,25);
	  waitem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("test"+ran +"@yahoo.com");
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[1]/div/div[2]/div/div[2]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[4]/div/div/span/div/div[1]/div/ul/li[4]/a")).click();
	  WebDriverWait waitd = new WebDriverWait(driver,15);
	  waitd.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:termDomesticMonthlyBtn")));
	  driver.findElement(By.id("signUpForm:termDomesticMonthlyBtn")).click();
	  WebDriverWait waitv = new WebDriverWait(driver,25);
	  Thread.sleep(2000);
	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	  WebDriverWait wait = new WebDriverWait(driver,50);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By
				 .id("signUpForm:firstNameTxtField")));
	    driver.findElement(By.id("signUpForm:firstNameTxtField")).clear();
	    driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
	    driver.findElement(By.id("signUpForm:lastNameTxtField")).clear();
	    driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
	    driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
	    driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
	    driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
	  //  new Select(driver.findElement(By.id("signUpForm:membershipAddressStateDD"))).selectByVisibleText("Alabama");
	    driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("city");
	    driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
	    driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1992");
	    driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2016");
	    driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click(); 
	     DMemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
	     System.out.println("email of member having domestic monthly membership is " + DMemail);
  }
  @AfterMethod(enabled=true,description = "This method fills credit card information in checkout page.",alwaysRun = true)
  public void afterMethod() throws InterruptedException {
	 WebDriverWait wait = new WebDriverWait(driver,25);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:ccNumberTxtField")));
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("4012888888881881");
	  driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("411");
	  Select month = new Select(driver.findElement(By.id("signUpForm:ccExpiryMonthDD")));
	  month.selectByVisibleText("Mar");
	  Select year = new Select(driver.findElement(By.id("signUpForm:ccExpiryYearDD")));
	  year.selectByVisibleText("2025");
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath(".//*[@id='signUpForm:msaConsentCheckbox']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='signUpForm:travelInsuranceConsentCheckbox']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath(".//*[@id='signUpForm:consentFormAgreeBtn']")).click();
	  Thread.sleep(20000);
  }
  @AfterTest(enabled=true, description = "This method write data to excel sheet and close firefox driver",alwaysRun = true)
  public void afterTest() throws IOException, InterruptedException {
		FileOutputStream fileOut = new FileOutputStream(new File("D://IEmail.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("Email Worksheet");
		Row row = worksheet.createRow(0);
		org.apache.poi.ss.usermodel.Cell cell =  row.createCell(0);
		cell.setCellValue(WAemail);
		worksheet.autoSizeColumn(0);
		//Code to write member's data value in first row of excel
		org.apache.poi.ss.usermodel.Cell cell1 =  row.createCell(1);
		cell1.setCellValue(firstname);
		worksheet.autoSizeColumn(1);
		org.apache.poi.ss.usermodel.Cell cell2 =  row.createCell(2);
		cell2.setCellValue(lastname);
		worksheet.autoSizeColumn(2);
		org.apache.poi.ss.usermodel.Cell cell3 =  row.createCell(3);
		cell3.setCellValue(birthdate);
		worksheet.autoSizeColumn(3);
		org.apache.poi.ss.usermodel.Cell cell4 =  row.createCell(4);
		cell4.setCellValue(membershipdate);
		worksheet.autoSizeColumn(4);
		org.apache.poi.ss.usermodel.Cell cell5 =  row.createCell(5);
		cell5.setCellValue(country);
		worksheet.autoSizeColumn(5);
		org.apache.poi.ss.usermodel.Cell cell6 =  row.createCell(6);
		worksheet.autoSizeColumn(6);
		cell6.setCellValue(city);
		org.apache.poi.ss.usermodel.Cell cell7 =  row.createCell(7);
		cell7.setCellValue(zipcode);
		org.apache.poi.ss.usermodel.Cell cell8 =  row.createCell(8);
		cell8.setCellValue("Alabama");
		org.apache.poi.ss.usermodel.Cell cell9 =  row.createCell(9);
		cell9.setCellValue(addressline1);
		org.apache.poi.ss.usermodel.Cell cell10 =  row.createCell(10);
		cell10.setCellValue(phonenumber);
		org.apache.poi.ss.usermodel.Cell cell11 =  row.createCell(11);
		cell11.setCellValue(price);
		//End of code to write member's data in excel
	    Row row2 = worksheet.createRow(1);
		org.apache.poi.ss.usermodel.Cell cell21 =  row2.createCell(0);
		cell21.setCellValue(DAemail);
		Row row3 = worksheet.createRow(2);
		org.apache.poi.ss.usermodel.Cell cell31 = row3.createCell(0);
		cell31.setCellValue(WSemail);
		Row row4 = worksheet.createRow(3);
		org.apache.poi.ss.usermodel.Cell cell41=  row4.createCell(0);
		cell41.setCellValue(DMemail);
		workbook.write(fileOut);
		workbook.close();
	    driver.quit();
  }
}
