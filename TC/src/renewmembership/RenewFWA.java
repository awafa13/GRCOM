package renewmembership;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class RenewFWA {
	private WebDriver driver;
	public String WAemail;
	private String url1,url2;

  @BeforeTest(enabled=true,alwaysRun=true)
  public void beforeTest() throws IOException {
	  System.setProperty("webdriver.ie.driver", "C:/IE/IEDriverServer.exe");
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);   
	  cap.setJavascriptEnabled(true);
	  driver = new InternetExplorerDriver(cap); 
	  driver.manage().window().maximize();
	  Properties prop = new Properties();
	  FileInputStream file2 = new FileInputStream(System.getProperty("user.dir") +"//tc.properties");
	  prop.load(file2);
	  url1= prop.getProperty("cmmurl");
	  url2 = prop.getProperty("grcomurl");
	  driver.get(url1);
  }
  @Test(priority=0, enabled=true,alwaysRun=true)
  public void GetPassword() throws IOException, InterruptedException, AWTException {
	  FileInputStream file = new FileInputStream(new File("D:\\FEmail.xls"));
	  HSSFWorkbook workbook = new HSSFWorkbook(file);
	  HSSFSheet sheet = workbook.getSheet("Email Worksheet");
	  int rowcount = sheet.getLastRowNum()- sheet.getFirstRowNum();
		Row row = sheet.getRow(0);
	     DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		 Cell cell = sheet.getRow(0).getCell(0);
		 String WAemail = formatter.formatCellValue(cell);
		 System.out.println(WAemail);
		  driver.findElement(By.id("Tab1")).click();
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
	       System.out.println(parent);
	       java.util.Set<String> hand = driver.getWindowHandles();
	 	   String windbefore = (String)hand.toArray()[0];
           String windafter = (String)hand.toArray()[1];
	 	   System.out.println(windbefore);
	 	   System.out.println(windafter);
	 	   driver.switchTo().window(windafter);
	 	   driver.manage().window().maximize();
	 	   Thread.sleep(5000);
	 	   driver.switchTo().frame("contentIFrame0");
	 	  WebDriverWait waitx = new WebDriverWait(driver,15);
		  waitx.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div/div/div[7]/div[2]/div[1]/div/table/tbody/tr[3]/td/div/span/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]/nobr/a")));
		  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div/div/div[7]/div[2]/div[1]/div/table/tbody/tr[3]/td/div/span/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/div/div/div[1]/table/tbody/tr/td[2]/nobr/a")).click();
		  Thread.sleep(8000);
		  driver.switchTo().frame("contentIFrame0");
		  String password= driver.findElement(By.id("gr_password")).getText();
		  System.out.println(password);
		  /*  Robot r=new Robot();
	 	  r.delay(3000);
	 	  r.mouseMove(330, 340);
	     r.mousePress(InputEvent.BUTTON1_MASK);
	     r.mouseRelease(InputEvent.BUTTON1_MASK);
	     r.keyPress(KeyEvent.VK_CONTROL);
	     r.keyPress(KeyEvent.VK_C);
	     r.keyRelease(KeyEvent.VK_CONTROL);
	     r.keyRelease(KeyEvent.VK_C);
	      driver = new FirefoxDriver();
	      driver.get(url2);
	      WebDriverWait wait1 = new WebDriverWait(driver,25);
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/nav/div/div[1]/div[2]/form/ul/li[2]/a/h6")));
	      driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/div[2]/form/ul/li[2]/a/h6")).click();
	      r.mouseMove(458, 350);
	      r.delay(3000);
	      r.mousePress(InputEvent.BUTTON1_MASK);
		  r.mouseRelease(InputEvent.BUTTON1_MASK);
	      r.keyPress(KeyEvent.VK_CONTROL);
		  r.keyPress(KeyEvent.VK_V);
		  r.keyRelease(KeyEvent.VK_CONTROL);
		  r.keyRelease(KeyEvent.VK_V);*/
		  driver = new FirefoxDriver();
	      driver.get(url2);
	      WebDriverWait wait1 = new WebDriverWait(driver,25);
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/nav/div/div[1]/div[2]/form/ul/li[2]/a/h6")));
	      driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/div[2]/form/ul/li[2]/a/h6")).click();
	      WebDriverWait wait2 = new WebDriverWait(driver,50);
	      wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("topHeaderLinksForm:usernameTxtField")));
	      driver.findElement(By.id("topHeaderLinksForm:usernameTxtField")).sendKeys(WAemail);
		  driver.findElement(By.id("topHeaderLinksForm:passwordTxtField")).sendKeys(password);
		  driver.findElement(By.id("topHeaderLinksForm:loginPopupBtn")).click();
		  driver.manage().window().maximize();
  }
  
  @Test(priority=1,enabled=true,groups={"worldwide"})
  public void RenewASIS() throws InterruptedException{
	  
	  WebDriverWait waitrenew = new WebDriverWait(driver,15);
	  waitrenew.until(ExpectedConditions.visibilityOfElementLocated(By.id("selfCareForm:membershipsLoop:0:renewMembershipBtn")));
	  driver.findElement(By.id("selfCareForm:membershipsLoop:0:renewMembershipBtn")).click();
	  WebDriverWait waitrenewpopup = new WebDriverWait(driver,15);
	  waitrenewpopup.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[4]/div/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[4]/div/input")).click();
	  WebDriverWait waitcc2 = new WebDriverWait(driver,16);
	  waitcc2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("signUpForm:ccNumberTxtField")));
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("4111111111111111");
	  driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("112");
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  Thread.sleep(12000);
	  WebDriverWait waitMSA2 = new WebDriverWait(driver,55);
	  waitMSA2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")).click();
	  WebDriverWait waitbuy2 = new WebDriverWait(driver,15);
	  waitbuy2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")).click();
	  Thread.sleep(20000);
  }
  
  @Test(priority=2, enabled=true,groups={"worldwide"})
  public void RenewWAWS() throws InterruptedException{
	
      driver.get(url2);
	  WebDriverWait waitrenew = new WebDriverWait(driver,15);
	  waitrenew.until(ExpectedConditions.visibilityOfElementLocated(By.id("selfCareForm:membershipsLoop:0:renewMembershipBtn")));
	  driver.findElement(By.id("selfCareForm:membershipsLoop:0:renewMembershipBtn")).click();
	  WebDriverWait waitrenewpopup = new WebDriverWait(driver,15);
	  waitrenewpopup.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[2]/div/div/div/table/tbody/tr[2]/td/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[2]/div/div/div/table/tbody/tr[2]/td/input")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[4]/div/input")).click();
      WebDriverWait waitst = new WebDriverWait(driver,15);
      waitst.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:termShortBtn")));
	  driver.findElement(By.id("signUpForm:termShortBtn")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	  WebDriverWait membershipstartdate = new WebDriverWait(driver,15);
	  membershipstartdate.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:membershipStartDateInputDate")));
	  driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2020");
	  WebDriverWait waitct = new WebDriverWait(driver,15);
	  waitct.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:memberDetailContinueBtn")));
	  driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();
	  WebDriverWait waitcc = new WebDriverWait(driver,16);
	  waitcc.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:ccNumberTxtField")));
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("4111111111111111");
	  driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("112");
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  Thread.sleep(12000);
	  WebDriverWait waitMSA = new WebDriverWait(driver,15);
	  waitMSA.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")).click();
	  WebDriverWait waitbuy = new WebDriverWait(driver,15);
	  waitbuy.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")).click(); 		  
	  Thread.sleep(20000);
  }
  
  @Test(priority=3,enabled=false,groups={"Domestic"})
  public void RenewWADA() throws InterruptedException{

      driver.get(url2);
	  WebDriverWait waitrenew = new WebDriverWait(driver,15);
	  waitrenew.until(ExpectedConditions.visibilityOfElementLocated(By.id("selfCareForm:membershipsLoop:0:renewMembershipBtn")));
	  driver.findElement(By.id("selfCareForm:membershipsLoop:0:renewMembershipBtn")).click();
	  WebDriverWait waitrenewpopup = new WebDriverWait(driver,15);
	  waitrenewpopup.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[2]/div/div/div/table/tbody/tr[2]/td/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[2]/div/div/div/table/tbody/tr[2]/td/input")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[4]/div/input")).click();
      WebDriverWait waitda = new WebDriverWait(driver,15);
      waitda.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationDomesticBtn")));
	  driver.findElement(By.id("locationDomesticBtn")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div/div/span/div/div[1]/div/ul/li[4]/a/div")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	  WebDriverWait membershipstartdate = new WebDriverWait(driver,15);
	  membershipstartdate.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:membershipStartDateInputDate")));
	  driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2019");
	  driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("addresss-3939393");
	  driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("city");
	  WebDriverWait waitct = new WebDriverWait(driver,15);
	  waitct.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:memberDetailContinueBtn")));
	  driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();
	  WebDriverWait waitcc = new WebDriverWait(driver,16);
	  waitcc.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:ccNumberTxtField")));
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("4111111111111111");
	  driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("112");
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  System.out.println("MSA button");
	  Thread.sleep(5000);
	  WebDriverWait waitMSA = new WebDriverWait(driver,15);
	  waitMSA.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")).click();
	  WebDriverWait waitbuy = new WebDriverWait(driver,15);
	  waitbuy.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")).click(); 		  
  }

  @Test(priority=4,enabled=false,groups={"Domestic"})
  public void RenewWADM() throws InterruptedException{
	  driver.get(url2);
	  WebDriverWait waitrenew = new WebDriverWait(driver,15);
	  waitrenew.until(ExpectedConditions.visibilityOfElementLocated(By.id("selfCareForm:membershipsLoop:0:renewMembershipBtn")));
	  driver.findElement(By.id("selfCareForm:membershipsLoop:0:renewMembershipBtn")).click();
	  WebDriverWait waitrenewpopup = new WebDriverWait(driver,15);
	  waitrenewpopup.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[2]/div/div/div/table/tbody/tr[2]/td/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[2]/div/div/div/table/tbody/tr[2]/td/input")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div/div[2]/div/div/div[1]/span/div/div/div/div/span/div[4]/div/input")).click();
      WebDriverWait waitda = new WebDriverWait(driver,15);
      waitda.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationDomesticBtn")));
	  driver.findElement(By.id("locationDomesticBtn")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div/div/span/div/div[1]/div/ul/li[4]/a/div")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("signUpForm:termDomesticMonthlyBtn")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	  WebDriverWait membershipstartdate = new WebDriverWait(driver,15);
	  membershipstartdate.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:membershipStartDateInputDate")));
	  driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2019");
	  driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("addresss-3939393");
	  driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("city");
	  WebDriverWait waitct = new WebDriverWait(driver,15);
	  waitct.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:memberDetailContinueBtn")));
	  driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();
	  WebDriverWait waitcc = new WebDriverWait(driver,16);
	  waitcc.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:ccNumberTxtField")));
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("4111111111111111");
	  driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("112");
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  WebDriverWait waitMSA = new WebDriverWait(driver,15);
	  waitMSA.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")).click();
	  WebDriverWait waitbuy = new WebDriverWait(driver,15);
	  waitbuy.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div[1]/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")).click(); 		  
  }

  @AfterTest(alwaysRun=true)
  public void afterTest() {
   driver.quit();
  }


}
