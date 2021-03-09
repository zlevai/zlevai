package first;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify {
	WebDriver driver;
	
  	@BeforeTest
  	public void setUp(){
		System.setProperty("webdriver.gecko.driver","C:\\tmp\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
  	}
	
	@Test
	public void registration() throws InterruptedException 
	{
		RegistrationPage registration = new RegistrationPage(driver);
		ConfirmationPage confirmation = new ConfirmationPage(driver);
		
		registration.typeName("Kiss Aladár");
		Thread.sleep(1000);
		
		registration.typeBirthDate("01021987");
		Thread.sleep(1000);
		
		registration.typeTestArea("Description");
		Thread.sleep(1000);
		
		registration.clickSubmit();
		Thread.sleep(2000);		
		
		System.out.println("Message: " + confirmation.successText());
		Assert.assertEquals(confirmation.successText(), "Information sent successfully!");
	}
	
	@Test
	public void errorMessage() throws InterruptedException 
	{
		RegistrationPage registration = new RegistrationPage(driver);
		
		registration.clickName();
		Thread.sleep(1000);		
		
		registration.clickSubmit();
		Thread.sleep(1000);	
		
		System.out.println("Message: " + registration.nameErrorText());
		Assert.assertEquals(registration.nameErrorText(), "This field is required.");
	}
	
  	@AfterTest
  	public void tearDown(){
        	driver.quit();
  	}
}
