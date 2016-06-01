package Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

public class AssertionsConfig {
	public static WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeSuite
  public void beforeSuite() {
	  driver = new FirefoxDriver();
	  
  }

}
