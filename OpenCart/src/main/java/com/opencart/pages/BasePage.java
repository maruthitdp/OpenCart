package com.opencart.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.opencart.base.BaseClass;

public class BasePage extends BaseClass {
	public BasePage() {
		super();
	}

	// to provide explicit wait for an element
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(properties.getProperty("wait"))));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// to provide data by send keys
	public void type(WebElement element, String text) {
		
		element.sendKeys(text);
	}

	public void click(WebElement element) {
		
		element.click();
	}

	public String getTitle() {
		
		return driver.getTitle();
	}

	public void verifyTitle(String title) {
		Assert.assertEquals(getTitle(), title);
	}

	public void getScreenshot(WebElement element) {
		
		
		 String elementName = element.getText(); // Fetch text from the element
         if (elementName.isEmpty()) {
             elementName = element.getAttribute("id"); 
         }

         // Clean up the name to avoid invalid characters in the file name
         elementName = elementName.replaceAll("[^a-zA-Z0-9]", "_");
		String style = "background-color: yellow; border: 2px solid red; color: blue; font-size: 20px;";
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				style);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String fileName = elementName + timestamp + ".png";
		File destinationFile = new File("src\\test\\resources\\screenshots\\" + fileName);
		try {
			FileUtils.copyFile(screenshot, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Screenshot saved successfully!");
	}
	
	public void mouseHover(WebElement element) {
		
		getScreenshot(element);
		Actions actions=new Actions(driver);
		
		actions.moveToElement(element).build().perform();
		element.click();
        System.out.println("Action performed successfully!");
	}

}
