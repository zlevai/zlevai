package first;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	WebDriver driver;
	
	By nameField = By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/input");
	By birthDate = By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/input[1]");
	By testArea = By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/textarea");
	By submit = By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[2]/button");
	By nameError = By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/div/div");
	
	public RegistrationPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void typeName(String name) 
	{
		driver.findElement(nameField).sendKeys(name);
	}
	
	public void clickName() 
	{
		driver.findElement(nameField).click();
	}
	
	public void typeBirthDate(String birthOfDate) 
	{
		driver.findElement(birthDate).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, birthOfDate);		
	}
	
	public void typeTestArea(String testAreaText) 
	{
		driver.findElement(testArea).sendKeys(testAreaText);
	}
	
	public void clickTestArea() 
	{
		driver.findElement(testArea).click();
	}
	
	public void clickSubmit() 
	{
		driver.findElement(submit).click();
	}
	
	public String nameErrorText() 
	{
		String nameErrorMessage = driver.findElement(nameError).getText();
		return nameErrorMessage;
	}
}
