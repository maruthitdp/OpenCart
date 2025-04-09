package com.opencart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static FileInputStream fs;
	public static Properties properties;
	public static WebDriver driver;
	
	public void readProperties() {
		try {
			fs=new FileInputStream("src/test/resources/properties/application.properties");
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please check the path again...");
			System.out.println(e.getMessage());
		}
		
		properties=new Properties();
		try {
			properties.load(fs);
		} catch (IOException e) {
			System.out.println("Could not load the properties...");
			System.out.println(e.getMessage());
		}
	}
	
	public void launchBrowser() {
		readProperties();
		String browserName=properties.getProperty("browser");
		switch (browserName) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "FireFox":
			driver=new FirefoxDriver();
			break;
		case "Edge":
			driver=new EdgeDriver();
			break;

		default:
			driver=new ChromeDriver();
			break;
		}
		
	}
	
	public void openUrl() {
		readProperties();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}

}
