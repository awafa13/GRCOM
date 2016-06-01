package Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class IndividuvialAssertions extends AssertionsConfig{
	//private WebDriver driver;
	private String WAemail,url;
	public String agecheck75Years;
 
  @BeforeTest(enabled=true)
  public void beforeTest() {
	   //driver = new FirefoxDriver();
  }

	  
 @BeforeMethod(enabled=true)
 public void beforeMethod() throws IOException {
	  Properties prop = new Properties();
	  FileInputStream file2 = new FileInputStream(System.getProperty("user.dir")+"\\tc.properties");
	  prop.load(file2);
	  url = prop.getProperty("grcomurl");
	  driver.get(url);
	  driver.manage().window().maximize();
 }
 
 @Test(priority=0,enabled=false)
 public void EnrollPageSummaryAssertions() {
  
   String locationcheck= driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/span/div/div/div/div/span/div[1]/div[2]/h5")).getText();
   String location = "Worldwide";
   Assert.assertEquals(location, locationcheck);
   System.out.println("Location assertion passed");
   String coveragecheck= driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/span/div/div/div/div/span/div[2]/div[2]/h5")).getText();
   String coverage = "Medical Only";
   Assert.assertEquals(coverage, coveragecheck);
   System.out.println("Coverage Assertion Passed");
   //Reporter.log("coverage assertion passed",true);
   String TypeofPlancheck = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/span/div/div/div/div/span/div[3]/div[2]/h5")).getText();
   String Typeofplan ="Individual";
   Assert.assertEquals(Typeofplan, TypeofPlancheck);
   System.out.println("TypeofPlan assertion passed");
   String term = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/span/div/div/div/div/span/div[4]/div[2]/h5")).getText();
   String termcheck = "1 year";
   Assert.assertEquals(term, termcheck);
   System.out.println("term assertion passed");
   String singletripdurationcheck = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/span/div/div/div/div/span/div[5]/div[2]/h5")).getText();
   String singletripduration = "45 days";
   Assert.assertEquals(singletripduration, singletripdurationcheck);
   System.out.println("Single Trip duration assertion passed");
   String price = "$329.00";
   String pricecheck = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/span/div/div/div/div/span/span[1]/div/div/h2/b")).getText();
   Assert.assertEquals(price, pricecheck);
 }
 @Test(priority=1,enabled=false)
 public void AutoRenewAssertion() {
	 
  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[2]/div[3]/div/div[1]/div/div/div/input")).isSelected();
  System.out.println("Autorenew checkbox assertion passed");
  WebElement element = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[2]/div[3]/div/div[1]/div/div/div/img"));
  Actions builder = new Actions(driver);
  builder.moveToElement(element).build().perform();
  String tooltipcheck = driver.findElement(By.id("tiptip_content")).getText();
  String tooltip = "Uncheck this box if you do not wish your membership to be automatically renewed at the completion of the membership term.";
  System.out.println("Autorenew tooltip assertion passed");
  

 }
 
 @Test(priority=2)
 public void PrivacyPolicyAssertion() throws InterruptedException {
  driver.findElement(By.id("privacyPolicyLink")).click();
  String parenthandle = driver.getWindowHandle();
  driver.findElement(By.id("privacyPolicyLink")).click();
  java.util.Set<String> twohandles = driver.getWindowHandles();
 if(twohandles.size() == 2)
 {
	 System.out.println("Privacy policy popup assertion passed");
 }
 Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[1]/form/div[2]/div/div/div[1]/button")).click();
 }

@Test(priority=3)
public void emailassertion() throws InterruptedException{
	driver.findElement(By.id("signUpForm:emailTxtField")).sendKeys("test.@37377.com");
	driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	Thread.sleep(2000);
	String text = driver.findElement(By.cssSelector("span.error")).getText();
	text = text.replaceAll("×", "").trim();
	Assert.assertEquals("Email is not Valid.", text);
	System.out.println("Invalid email assertion passed");
	driver.findElement(By.id("signUpForm:emailTxtField")).clear();
	String existingemail = "receipt@changes.com";
	String handle = driver.getWindowHandle();
	driver.findElement(By.id("signUpForm:emailTxtField")).sendKeys(existingemail);
	driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	java.util.Set<String> handles = driver.getWindowHandles();
	if(handles.size()==2){
	System.out.println("System does not allow to purchase membership with an existing email address");
		}
	//Thread.sleep(8000);
	//driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[5]/div/div/div/span/div[2]/div[2]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	Thread.sleep(3000);
	String message = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/span")).getText();
	message= message.replaceAll("×", "").trim();
    Assert.assertEquals(message, "Email cannot be empty");
    System.out.println("System does not allow to create membership with empty email address");
}
@Test(priority=4)
public void AgeCheckandStartDate() throws InterruptedException{
	  int ran ;
	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("ind"+ran +"@yahoo.com");
	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	  Thread.sleep(6000);
	  driver.findElement(By.id("signUpForm:firstNameTxtField")).sendKeys("test");
	  driver.findElement(By.id("signUpForm:lastNameTxtField")).sendKeys("test");
	  driver.findElement(By.id("signUpForm:contactGenderRadioBtn:1")).click();
	  driver.findElement(By.id("signUpForm:membershipAddressZipTxtField")).sendKeys("12345");
	  driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
	  new Select(driver.findElement(By.id("signUpForm:membershipAddressStateDD"))).selectByVisibleText("Alabama");
	  driver.findElement(By.id("signUpForm:membershipAddressCityTxtField")).sendKeys("Abbeville");
	  driver.findElement(By.id("signUpForm:primaryPhoneNumberInput:primaryPhoneNumberInput")).sendKeys("(+1)777777");
	  driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1900");
	  Thread.sleep(2000);
	  driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("06/06/2016");
	  driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
	  WAemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
	  System.out.println("email of member having worldwide annual membership is " + WAemail);
	  Thread.sleep(7000);
	  String message=  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[2]/div[3]/div[2]/span")).getText();
      message = message.replaceAll("×", "").trim();
      Assert.assertEquals(message, "Age check failed. See Details");
      driver.findElement(By.linkText("See Details")).click();
      Thread.sleep(5000);
      String agecheck = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[2]/div[3]/div[2]/span/div/div/span/div/div[2]/div/div/h5")).getAttribute("innerHTML");
      agecheck = agecheck.replaceAll("", "").trim();
      String agemessage = "Global Rescue only covers individuals up to the age of 85.";
      Assert.assertEquals(agecheck, agemessage);
      System.out.println("System does not allow a member with age 85 to purchase a membership");
      driver.findElement(By.id("signUpForm:birthDateInputDate")).clear();
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[2]/div[3]/div[2]/span/div/div/span/div/div[1]/button")).click();
      driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1940");
      driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click(); 
      Thread.sleep(8000);
	  String message2=  driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[2]/div[3]/div[2]/span")).getText();
      message2 = message2.replaceAll("×", "").trim();
      Assert.assertEquals(message2, "Age check failed. See Details");
      driver.findElement(By.linkText("See Details")).click();
      String agecheck75 = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[2]/div[3]/div[2]/span/div/div/span/div/div[2]/div/div/h5")).getAttribute("innerHTML");
      agecheck75 = agecheck75.replaceAll("", "").trim();
      boolean agecheckdriver = agecheck75.contains("For individuals between the ages of 75 and 85, membership requires an application signed by your physician.");
      if(agecheckdriver == true)
      {
    	   agecheck75Years = "For individuals between the ages of 75 and 85, membership requires an application signed by your physician.";
      }
      String agemessage75 = "For individuals between the ages of 75 and 85, membership requires an application signed by your physician.";
	Assert.assertEquals(agecheck75Years, agemessage75);
    System.out.println("System opens popup for physician from when member age is greater than 75 and less than 85");
    Thread.sleep(3000);
    //Physcian form link code
    driver.findElement(By.linkText("here")).click(); 
    String handle = driver.getWindowHandle();
    java.util.Set<String> handles = driver.getWindowHandles();
    String handbefore = (String)handles.toArray()[0];
    String hand = (String) handles.toArray()[1];
    driver.switchTo().window(hand);
    String physicianformtitle = driver.getTitle();
    System.out.println(physicianformtitle);
    System.out.println("System opens physcian form in new window by clicking on here link");
    driver.close();
    driver.switchTo().window(handbefore);
    driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[2]/div[3]/div[2]/span/div/div/span/div/div[1]/button")).click();
    driver.findElement(By.id("signUpForm:birthDateInputDate")).clear();
    driver.findElement(By.id("signUpForm:birthDateInputDate")).sendKeys("02/02/1992");
    driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).clear();
    Thread.sleep(5000);
	driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("02/02/2016");
	Thread.sleep(10000);
	driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).clear();
	driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
	driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();
	Thread.sleep(5000);
	String name =driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[2]/div[4]/div[2]/span")).getText();
	name = name.replaceAll("×", "").trim();
	Assert.assertEquals(name, "Membership start date cannot be past date");
	System.out.println("System does not allow to purchase membership with past date");
	driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).clear();
	Thread.sleep(5000);
	driver.findElement(By.id("signUpForm:membershipStartDateInputDate")).sendKeys("02/02/2017");
	Thread.sleep(10000);
	driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).clear();
	driver.findElement(By.id("signUpForm:membershipAddressLine1TxtField")).sendKeys("address-373737");
	Thread.sleep(5000);
	driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();
	Thread.sleep(10000);
	driver.findElement(By.id("signUpForm:ccFirstNameTxtField")).clear();
	Thread.sleep(5000);
	driver.findElement(By.id("signUpForm:ccFirstNameTxtField")).sendKeys("Test");
	  Thread.sleep(10000);
	// driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("4111111111111111");
	  driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("411");
	  Select month = new Select(driver.findElement(By.id("signUpForm:ccExpiryMonthDD")));
	  month.selectByVisibleText("Mar");
	  Select year = new Select(driver.findElement(By.id("signUpForm:ccExpiryYearDD")));
	  year.selectByVisibleText("2025");
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  Thread.sleep(5000);
	  String ccnumber = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[2]/div[1]/div[1]/div[4]/div/span")).getText();
	  ccnumber = ccnumber.replaceAll("×", "").trim();
	  Assert.assertEquals(ccnumber, "Credit Card Number cannot be empty");
	  System.out.println("System does not allow to purchase membership without credit card information");
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("aaa4hhhh@#$%^&&&*");
	  Thread.sleep(5000);
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  Thread.sleep(3000);
	  String ccnumber2 = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[2]/div[1]/div[1]/div[4]/div/span")).getText();
	  ccnumber2 = ccnumber2.replaceAll("×", "").trim();
	  Assert.assertEquals(ccnumber2, "Invalid Credit Card Number");
	  System.out.println("System does not allow alphabets and special characters in credit card information field");
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).clear();
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("41111111111111111111");
	  Thread.sleep(5000);
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  Thread.sleep(3000);
	  String ccnumber3 = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[2]/div[1]/div[1]/div[4]/div/span")).getText();
	  ccnumber3 = ccnumber3.replaceAll("×", "").trim();
	  Assert.assertEquals(ccnumber3, "Credit Card Number cannot be longer than 16 characters");
	  System.out.println("System does not allow more than 16  digits in credit number field ");
	  Thread.sleep(2000);
	  driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("984984893849489");
	  String cvv = driver.findElement(By.id("signUpForm:cvvTxtField")).getText();
	  if(cvv.length()==4)
	  {
		  System.out.println("System does not allow cvv number greater than 4 digits");
	  }
	   driver.findElement(By.id("signUpForm:cvvTxtField")).clear();
	   driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("@@#DDDde");
	   String cvvnumber = driver.findElement(By.id("signUpForm:cvvTxtField")).getText();
	   if(cvv.length()==0)
		  {
			  System.out.println("System does not special characters and alphabets in cvv number field");
		  }  
		    driver.findElement(By.linkText("Add Referral Code")).click();
			System.out.println("Referal code link is clickable");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[4]/div/div/div/button")).click();
			driver.findElement(By.id("signUpForm:ccNumberTxtField")).clear();
			driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("4111111111111111");
			driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("112");
		    driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
			WebDriverWait waitr = new WebDriverWait(driver,15);
			waitr.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")));
			driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")).click();
			driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")).click();
		    
		    
}


 }

 


