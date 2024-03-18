package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_login extends Baseclass {
	public Page_login(WebDriver driver) {
		this.driver = driver;
	}

	public void login() throws InterruptedException {

		driver.findElement(By.id(loc.getProperty("email"))).sendKeys(prop.getProperty("user"));

		driver.findElement(By.id(loc.getProperty("password"))).sendKeys(prop.getProperty("pass"));

		driver.findElement(By.xpath(loc.getProperty("login"))).click();

	}
}
