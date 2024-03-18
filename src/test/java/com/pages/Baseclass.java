package com.pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	public WebDriver getdriver() {
		return driver;
	}

	public void setup() throws IOException {
		if (driver == null) {

			System.out.println("the project path is:" + System.getProperty("user.dir"));

			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "//src//test//resources//config files//config.properties");
			FileReader fr1 = new FileReader(
					System.getProperty("user.dir") + "//src//test//resources//config files//loc.properties");
			prop.load(fr);
			loc.load(fr1);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("testurl"));
			String cuurentURL = driver.getCurrentUrl();
			String expectedURL = "https://medsolbuffer.in/login";
			Assert.assertEquals(cuurentURL, expectedURL);

		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("testurl"));
			String cuurentURL = driver.getCurrentUrl();
			String expectedURL = "https://medsolbuffer.in/login";
			Assert.assertEquals(cuurentURL, expectedURL);

		}
	}

	public void teardown() {

		driver.close();
		System.out.println("tear down succeessful");

	}

}
