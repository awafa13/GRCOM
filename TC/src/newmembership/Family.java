package newmembership;

import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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


public class Family {
	private WebDriver driver;
	private String WAemail;
	private String WSemail;
	private String DAemail;
	private String DMemail;
	private String firstname,lastname,addressline1,state,city;
	private String price,zipcode,country,phonenumber,birthdate,membershipdate;
	private String url2;
	
	
   @BeforeTest(enabled=true,alwaysRun=true)
   public void beforeTest() throws IOException {
	
	   Properties prop = new Properties();
	   FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "//tc.properties");
	   prop.load(file);
	   driver = new FirefoxDriver();
	   url2 = prop.getProperty("grcomurl");
	 
   }

	  
  @BeforeMethod(enabled=true,alwaysRun=true)
  public void beforeMethod() {
	  driver.manage().window().maximize();
	  driver.get(url2);
  }
  @Test(enabled=true,priority=0,groups={"worldwide"})
  public void WFamilyAnnual() throws InterruptedException {
	  int ran;
	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
      driver.findElement(By.xpath(".//*[@id='signUpForm:planFamilyBtn']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("fam"+ran+"@tc.com");
      Thread.sleep(3000);
      driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
      WebDriverWait wait2 = new WebDriverWait(driver,30);
	    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:firstNameTxtField")));
	    driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
	    firstname =  driver.findElement(By.id("signUpForm:firstNameTxtField")).getAttribute("value");
	    driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
	    lastname =  driver.findElement(By.id("signUpForm:lastNameTxtField")).getAttribute("value");
	    driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
	    driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
	    zipcode =  driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).getAttribute("value");
	    driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
	    addressline1 =  driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).getAttribute("value");
	    Select select = new Select(driver.findElement(By.id("signUpForm:membershipAddressStateDD")));
	    select.selectByVisibleText("Alabama");
	    driver.findElement(By.xpath(".//*[@id='signUpForm:membershipAddressCityTxtField']")).sendKeys("Abbeville");
	    city =  driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).getAttribute("value");
	    driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
	    phonenumber =  driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).getAttribute("value");
	    driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("2/2/1992");
	    birthdate =  driver.findElement(By.id("signUpForm:birthDateInputDate")).getAttribute("value");
	    driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("6/6/2016");
	    membershipdate =  driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).getAttribute("value");
	    WAemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
	    System.out.println("email of member having worldwide family annual membership is " + WAemail);
        driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
       // WebElement option = select.getFirstSelectedOption();
	   // state=option.getText();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='withoutFamilyMemberContinueBtn']")).click();
        WebDriverWait wait4 = new WebDriverWait(driver,15);
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")));
        driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dep");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("2/2/2005");
        driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();
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
  @Test(enabled=false,priority=2,groups={"Domestic"})
  public void DFamilyAnnual() throws InterruptedException {
  	  int ran;
  	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("fam"+ran+"@tc.com");
      WebDriverWait waitm = new WebDriverWait(driver,15);
  	  waitm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[2]/div[2]/div/div[1]/div/input[2]")));
  	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[2]/div[2]/div/div[1]/div/input[2]")).click();
  	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[1]/div/div[2]/div/div[2]/input")).click();
  	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[4]/div/div/span/div/div[1]/div/ul/li[4]/a")).click();
  	  Thread.sleep(3000);
      driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
      WebDriverWait wait2 = new WebDriverWait(driver,30);
      wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:firstNameTxtField")));
      driver.findElement(By.id("signUpForm:firstNameTxtField")).clear();
      driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
      driver.findElement(By.id("signUpForm:lastNameTxtField")).clear();
      driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
      driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
      driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
      driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
      driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("Abbeville");
      driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
      driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1992");
      driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2016");
      DAemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
      System.out.println("email of member having domestic family annual membership is " + DAemail);
      driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
      WebDriverWait wait3 = new WebDriverWait(driver,15);
      wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[6]/div/div/div[3]/div/div/button")));
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[6]/div/div/div[3]/div/div/button")).click();
      WebDriverWait wait4 = new WebDriverWait(driver,15);
      wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")));
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dep");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click(); 
  }
  @Test(enabled=false,priority=3,groups={"Domestic"})
  public void DFamilyMonthly() throws InterruptedException {
  	int ran;
  	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
    driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("fam"+ran+"@tc.com");
    WebDriverWait waitm = new WebDriverWait(driver,15);
  	waitm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[2]/div[2]/div/div[1]/div/input[2]")));
  	driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[2]/div[2]/div/div[1]/div/input[2]")).click();
  	driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[1]/div/div[2]/div/div[2]/input")).click();
  	driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[4]/div/div/span/div/div[1]/div/ul/li[4]/a")).click();
  	Thread.sleep(3000);
  	driver.findElement(By.id("signUpForm:termDomesticMonthlyBtn")).click();
  	Thread.sleep(3000);
    driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
    WebDriverWait wait2 = new WebDriverWait(driver,30);
    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:firstNameTxtField")));
    driver.findElement(By.id("signUpForm:firstNameTxtField")).clear();
    driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
    driver.findElement(By.id("signUpForm:lastNameTxtField")).clear();
    driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
    driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
    driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
    driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
    driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("Abbeville");
    driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
    driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1992");
    driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2016");
    DMemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
    System.out.println("email of member having domestic family monthly membership is " + DMemail);
    driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
    WebDriverWait wait3 = new WebDriverWait(driver,25);
    wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='withoutFamilyMemberContinueBtn']")));
    Thread.sleep(10000);
    driver.findElement(By.xpath(".//*[@id='withoutFamilyMemberContinueBtn']")).click();
    WebDriverWait wait4 = new WebDriverWait(driver,25);
    wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")));
    driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dep");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
    driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
    driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
    driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click(); 
    Thread.sleep(5000);
  }
  @Test(enabled=true,priority=1,groups={"worldwide"})
  public void WFamilyShortterm() throws InterruptedException {
  	  int ran;
  	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1)); 
      WebDriverWait fwait = new WebDriverWait(driver,15);
      fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='signUpForm:planFamilyBtn']")));
      driver.findElement(By.xpath(".//*[@id='signUpForm:planFamilyBtn']")).click();
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("fam"+ran+"@tc.com");
      WebDriverWait waitm = new WebDriverWait(driver,15);
  	  waitm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='signUpForm:termShortBtn']")));
      driver.findElement(By.xpath(".//*[@id='signUpForm:termShortBtn']")).click();
  	  Thread.sleep(5000);
      driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
      WebDriverWait wait2 = new WebDriverWait(driver,30);
      wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:firstNameTxtField")));
      driver.findElement(By.id("signUpForm:firstNameTxtField")).clear();
      driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
      driver.findElement(By.id("signUpForm:lastNameTxtField")).clear();
      driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
      driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
      driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
      driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
      new Select(driver.findElement(By.id("signUpForm:membershipAddressStateDD"))).selectByVisibleText("Alabama");
      driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("Abbeville");
      driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
      driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1992");
      driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2016");
      WSemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
      System.out.println("email of member having worldwide family shortterm membership is " + WSemail);
      driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
      Thread.sleep(5000);
      WebDriverWait wait3 = new WebDriverWait(driver,55);
      wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[6]/div/div/div[3]/div/div/button")));
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[6]/div/div/div[3]/div/div/button")).click();
      WebDriverWait wait4 = new WebDriverWait(driver,15);
      wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")));
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dep");
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
      Thread.sleep(6000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      Thread.sleep(4000);
      driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();
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
  @AfterMethod(enabled=true,alwaysRun=true)
  public void afterMethod() throws InterruptedException {
	 WebDriverWait wait = new WebDriverWait(driver,15);
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
  @AfterTest(enabled=true,alwaysRun=true)
  public void afterTest() throws IOException {
		FileOutputStream fileOut = new FileOutputStream(new File("D://FEmail.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet("Email Worksheet");
		Row row = worksheet.createRow(0);
		org.apache.poi.ss.usermodel.Cell cell =  row.createCell(0);
		cell.setCellValue(WAemail);
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
		country = "United States";
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
		Row row2 = worksheet.createRow(1);
		org.apache.poi.ss.usermodel.Cell cell21 =  row2.createCell(0);
		cell21.setCellValue(DAemail);
		Row row3 = worksheet.createRow(2);
		org.apache.poi.ss.usermodel.Cell cell31 = row3.createCell(0);
		cell31.setCellValue(WSemail);
		Row row4 = worksheet.createRow(3);
		org.apache.poi.ss.usermodel.Cell cell41 =  row4.createCell(0);
		cell41.setCellValue(DMemail);
		workbook.write(fileOut);
		workbook.close();
	    driver.quit();
  }
}
