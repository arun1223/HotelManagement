package mwinteringham.pageobjects;

import mwinteringham.helpers.WebDriverHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseClass {
	public static WebDriver driver;


	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;

		PageFactory.initElements(driver,this);
	}


}
