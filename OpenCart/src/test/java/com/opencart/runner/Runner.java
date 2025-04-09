package com.opencart.runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\features",
								glue="com.opencart.stepDefinations",
								stepNotifications=true,
								dryRun=false,
								tags="@abc143",
								plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
										"html:target/cucumber-reports/reports.html"},
								monochrome = true)
public class Runner {

}