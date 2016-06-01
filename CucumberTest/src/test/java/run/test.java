package run;

import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class test {
	         WebDriver driver;
	         private java.util.List<Integer> numbers;
	         private int sum;

	       @Given("^Initialize driver$")
	       public void InitializeDriver() {
	    	   driver = new FirefoxDriver();
	       }
	       @When("^Open Website$")
	       public void OpenWebsite() {
	           // Write code here that turns the phrase above into concrete actions
	    	   driver.get("http://softwaretestingsite.blogspot.com");
	       }

	       @Then("^Close Browser and print \"(.*?)\"$")
	       public void CloseBrowser(String arg1)  {
	    	   System.out.println(arg1);
	    	   driver.close();  
	       }  
	       @Given("^a list of numbers$")
	       public void a_list_of_numbers(java.util.List<Integer> numbers) throws Throwable {
	           this.numbers = numbers;
	       }

	       @When("^I summarize them$")
	       public void i_summarize_them() throws Throwable {
	           for (Integer number : numbers) {
	               sum += number;
	           }
	       }

	       @Then("^should I get (\\d+)$")
	       public void should_I_get(int expectedSum) throws Throwable {
	           assertThat(sum, is (expectedSum));
	           System.out.println(expectedSum);
	       }

	}



