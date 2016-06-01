package Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FamilyAssertions extends AssertionsConfig{
	private String url;
	
	IndividuvialAssertions ia = new IndividuvialAssertions();

  @BeforeTest
  public void beforeTest() throws IOException {
	//driver = new FirefoxDriver();
	  Properties prop = new Properties();
	  FileInputStream file2 = new FileInputStream(System.getProperty("user.dir")+"\\tc.properties");
	  prop.load(file2);
	  url = prop.getProperty("grcomurl");
	  driver.get(url);
	driver.manage().window().maximize();
  }
 
  @Test(priority=0, description = "Enroll page assertions")
  public void family() throws InterruptedException {
	   
	/*	ia.AutoRenewAssertion();
		Thread.sleep(2000);
		driver.navigate().refresh();
		ia.PrivacyPolicyAssertion();
		driver.navigate().refresh();
		ia.emailassertion(); */
		
  }
  @Test(priority=1, description = "Fill Membership Data")
  public void MembershipData() throws InterruptedException {
	  int ran;
  	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
  	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[1]/span/div[2]/div[2]/div/div[1]/div/input[2]")).click();
      Thread.sleep(3000);
  	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/span/div/div/div/div/span/span[2]/div/div[2]/input")).sendKeys("family"+ran +"@yahoo.com");
  	  driver.findElement(By.id("signUpForm:planSelectionContinueBtn")).click();
	  Thread.sleep(6000);
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
      String WSemail = driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[2]/div[1]/div[1]/div[2]/h5")).getText();
      System.out.println("email of member having worldwide family shortterm membership is " + WSemail);
      driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click();  
     
     
  }
  @Test(priority=2, description = "Family Assertions")
  public void familymembersassertion() throws InterruptedException {

	  WebDriverWait wait3 = new WebDriverWait(driver,15);
      wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[6]/div/div/div[3]/div/div/button")));
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[6]/div/div/div[3]/div/div/button")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      Thread.sleep(5000);
      System.out.println("Add Family Member popup appears when user try to purchase family membership without adding family members");
      //Assertion for first name message
     String firstname = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/span")).getText();
     String  firstnametrim= firstname.replaceAll("×","").trim();
     Assert.assertEquals(firstnametrim, "First Name cannot be empty");
     //Assertion for Last name message
     String lastname = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/span")).getText();
     String  lastnametrim= lastname.replaceAll("×","").trim();
     Assert.assertEquals(lastnametrim, "Last Name cannot be empty");
     //Assertion for Birth Date message
     String birthdate = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/span")).getText();
     String  birthdatetrim= birthdate.replaceAll("×","").trim();
     Assert.assertEquals(birthdatetrim, "Birth Date cannot be empty");
     System.out.println("System does not allow to add family member without filling mandatory fields information");
  
  }
  @Test(priority=3, description = "This method checks Family Members Age Check/App Access and Email information.")
  public void familymembersagecheck() throws InterruptedException {
	  int ran;
  	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  WebDriverWait wait4 = new WebDriverWait(driver,25);
      wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")));
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("spouse");
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/1992");
      Thread.sleep(2000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      Thread.sleep(5000);
      String message = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[1]/div/span")).getText();
      message= message.replaceAll("×","").trim();
      Assert.assertEquals(message, "Individuals with ages 23 and older are not eligible to be dependents in a family membership and require their own individual membership. You may enroll at the conclusion of this membership.");
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[1]/div/span/i")).click();
      Select select = new Select(driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[5]/div[2]/select")));
      select.selectByVisibleText("Spouse");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).clear();
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/1940");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      Thread.sleep(6000);
      String check = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[1]/div/span")).getText();
      check= check.replaceAll("×","").trim();
      Assert.assertEquals(check, "For individuals between the ages of 75 and 85, membership requires an application signed by your physician. Click here to download the application.");
      Thread.sleep(8000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[1]/div/span/a/b")).click();
      String handle = driver.getWindowHandle();
      java.util.Set<String> handles = driver.getWindowHandles();
      String handbefore = (String)handles.toArray()[0];
      String hand = (String) handles.toArray()[1];
      driver.switchTo().window(hand);
      System.out.println("System opens physcian form in new window by clicking on here link");
      driver.close();
      driver.switchTo().window(handbefore);
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).clear();
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/1992");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click(); 
      Thread.sleep(6000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/span/div[1]/div/div[1]/div[1]/a")).click();
      System.out.println("System opens Add Family Members pop up by clicking on Add Family Member link");
      Thread.sleep(15000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      Thread.sleep(8000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[6]/div[2]/table/tbody/tr/td[1]/input")).click();
      Thread.sleep(10000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dep");
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
      Thread.sleep(2000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).clear();
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      Thread.sleep(8000);
      String appaccess = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[6]/div[2]/span")).getText();
      appaccess= appaccess.replaceAll("×","").trim();
      Assert.assertEquals(appaccess,"Provide email address for mobile login");
      System.out.println("System does not allow to give mobile access without providing email for dependent/spouse");
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/input")).sendKeys("dependent"+ran+".@gr.com");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      Thread.sleep(4000);
      String emailmessage = driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/span")).getText();
      emailmessage= emailmessage.replaceAll("×","").trim();
      Assert.assertEquals(emailmessage,"Email is not Valid.");
      System.out.println("System does not allow invalid email address format for dependents/spouse");
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/input")).clear();
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/input")).sendKeys("dependent"+ran+"@gr.com");
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
  }
  
  @Test(priority=4, enabled =false, description = "This method checks family members data in grid")
  public void FamilyMembersGRIDData() throws InterruptedException {
    
	  int ran;
  	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  Thread.sleep(12000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/span/div[1]/div/div[1]/div[1]/a")).click();
      Thread.sleep(9000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      Thread.sleep(12000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("grcom");
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/input")).sendKeys("dependent"+ran+"@grcom.com");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
	  
	 
  }
  @Test(priority=5, enabled = true, description = "This method checks family members deduplication rules")
  public void DuplicateFamilyMembers() throws InterruptedException {
	  int ran;
  	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  Thread.sleep(15000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/span/div[1]/div/div[1]/div[1]/a")).click();
      Thread.sleep(8000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      Thread.sleep(8000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
      Thread.sleep(12000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dep");
      Thread.sleep(8000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/input")).sendKeys("dependent"+ran+"@gr.com");
      driver.findElement(By.xpath(".//*[@id='signUpForm:saveAndAddAnotherFamilyMemberBtn']")).click();
      Thread.sleep(10000);
      System.out.println("System does not close add family member popup by clicking on Save and add another button");
      Thread.sleep(10000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      Thread.sleep(10000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dep");
      Thread.sleep(10000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
      Thread.sleep(10000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/input")).sendKeys("dependent"+ran+"@gr.com");
      Thread.sleep(12000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      Thread.sleep(6000);
      String message = driver.findElement(By.xpath(".//*[@id='signUpForm:editFamilyMemberPanel']/div[2]/div[1]/div/span")).getText();
      message= message.replaceAll("×","").trim();
      Assert.assertEquals(message, "Entered family member is already a part of this membership");
      System.out.println("Family Members Deduplication rules are working fine");
      driver.findElement(By.xpath(".//*[@id='cancelFamilyMemberBtn']")).click();
	
	  
  }
  @Test(priority=6, enabled = true, description = "This method checks email uniqueness for family members")
  public void EmailUniquenessCheck() throws InterruptedException {
	  int ran;
  	  ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	  Thread.sleep(5000);
      driver.findElement(By.xpath(".//*[@id='signUpForm:addFamilyMemberLink']")).click();
      Thread.sleep(20000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      Thread.sleep(8000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dependentone");
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/input")).sendKeys("dependent"+ran+"@gr.com");
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
      Thread.sleep(8000);
      driver.findElement(By.xpath(".//*[@id='signUpForm:saveAndAddAnotherFamilyMemberBtn']")).click();
      Thread.sleep(10000);
      System.out.println("System does not close add family member popup by clicking on Save and add another button");
      Thread.sleep(9000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys(ran+"tc");
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[1]/div[2]/input")).sendKeys("dependenttwo");
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[4]/div[2]/input")).sendKeys("dependent"+ran+"@gr.com");
      Thread.sleep(4000);
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[2]/div[2]/div/div[3]/div[2]/div/span[1]/input[1]")).sendKeys("02/02/2005");
      driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[2]/span/div/div[5]/div/div/span/div[3]/div/div/input[1]")).click();
      Thread.sleep(5000);
      String message = driver.findElement(By.xpath(".//*[@id='signUpForm:editFamilyMemberPanel']/div[2]/div[2]/div/div[4]/div[2]/span")).getText();
      message= message.replaceAll("×","").trim();
      Assert.assertEquals(message, "Entered email address already exists");
      System.out.println("System does not allow to add two family members with same email address");
      driver.findElement(By.xpath(".//*[@id='cancelFamilyMemberBtn']")).click();
  }

  @Test(priority=7, enabled =true, description = "This method checks Edit family members functionality")
  public void EditFamilyMembers() throws InterruptedException {
	  //WebDriverWait wait = new WebDriverWait(driver,25);
	//  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='signUpForm:familyMembersLoop:0:editFamilyMemberLink']")));
	  Thread.sleep(10000);
	  driver.findElement(By.xpath(".//*[@id='signUpForm:familyMembersLoop:0:editFamilyMemberLink']")).click();
	  System.out.println("Sytsem opens edit family member form by clicking on Edit link");
	  WebDriverWait wait2 = new WebDriverWait(driver,25);
	  wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='signUpForm:familyMemberFirstNameTxtField']")));
	  driver.findElement(By.xpath(".//*[@id='signUpForm:familyMemberFirstNameTxtField']")).clear();
	  driver.findElement(By.xpath(".//*[@id='signUpForm:familyMemberFirstNameTxtField']")).sendKeys("edit");
	  WebDriverWait wait3 = new WebDriverWait(driver,25);
	  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='signUpForm:saveFamilyMemberBtn']")));
	  driver.findElement(By.xpath(".//*[@id='signUpForm:saveFamilyMemberBtn']")).click();
	  System.out.println("System successfully saves family member information after editing");
	  Thread.sleep(15000);
	 String name =  driver.findElement(By.xpath(".//*[@id='signUpForm:familyMemberPanel']/div[1]/div/div[2]/div/table/tbody/tr/td[1]")).getText();
	 name= name.replaceAll("×","").trim();
	 if(name.contains("edit")){
      System.out.println("Sytsem successfully saves changes in family member grid after editing");
  }}
  @Test(priority=8, enabled = true, description = "This method checks remove family members functionality")
  public void Removefamilymembers() throws InterruptedException {
      Thread.sleep(10000);
	  WebDriverWait wait = new WebDriverWait(driver,35);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='signUpForm:familyMembersLoop:0:removeFamilyMemberLink']")));
	  WebDriverWait waitclick = new WebDriverWait(driver,35);
	  waitclick.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='signUpForm:familyMembersLoop:0:removeFamilyMemberLink']")));
	  driver.findElement(By.xpath(".//*[@id='signUpForm:familyMembersLoop:0:removeFamilyMemberLink']")).click();
	  System.out.println("Sytsem opens remove family member pop up by clicking on REMOVE LINK");
	  WebDriverWait wait2 = new WebDriverWait(driver,25);
	  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='noRemoveFamilyMemberBtn']")));
	  driver.findElement(By.xpath(".//*[@id='noRemoveFamilyMemberBtn']")).click();
	  System.out.println("Sytsem does not remove family member when user clicks on No button in Remove Family Member Popup.");
	  WebDriverWait wait3 = new WebDriverWait(driver,25);
	  wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='signUpForm:yesRemoveFamilyMemberBtn']")));
	  driver.findElement(By.xpath(".//*[@id='signUpForm:yesRemoveFamilyMemberBtn']")).click();
	  System.out.println("System remove family members when user clicks on Yes button in Remove Family Members popup");
  }
  @AfterTest(enabled=true)
  public void afterTest() {
	  WebDriverWait waitc = new WebDriverWait(driver,15);
	  waitc.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:memberDetailContinueBtn")));
	  driver.findElement(By.id("signUpForm:memberDetailContinueBtn")).click(); 
	  WebDriverWait wait = new WebDriverWait(driver,15);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpForm:ccNumberTxtField")));
	  driver.findElement(By.id("signUpForm:ccNumberTxtField")).sendKeys("4111111111111111");
	  driver.findElement(By.id("signUpForm:cvvTxtField")).sendKeys("411");
	  Select month = new Select(driver.findElement(By.id("signUpForm:ccExpiryMonthDD")));
	  month.selectByVisibleText("Mar");
	  Select year = new Select(driver.findElement(By.id("signUpForm:ccExpiryYearDD")));
	  year.selectByVisibleText("2025");
	  driver.findElement(By.id("signUpForm:membershipBuyBtn")).click();
	  WebDriverWait waitr = new WebDriverWait(driver,15);
	  waitr.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")));
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[1]/table/tbody/tr/td[1]/input")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[3]/span/div[6]/div/div/div[3]/span/div/div[2]/input")).click();
      WebDriverWait waite = new WebDriverWait(driver,25);
      waite.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form[1]/div[1]/div/div/span/div/div/div/span/div/div[4]/span/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div[2]/label")));
      driver.quit();
  }

}
