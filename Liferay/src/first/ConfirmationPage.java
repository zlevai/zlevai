package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	
	WebDriver driver;	
	By successMessage = By.xpath("/html/body/div[1]/div/div/div/div/div/div/div/div/h5");
	
	public ConfirmationPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String successText() 
	{
		String messageText = driver.findElement(successMessage).getText();
		return messageText;
	}
}
