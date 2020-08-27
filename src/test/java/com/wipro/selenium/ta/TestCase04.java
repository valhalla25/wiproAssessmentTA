package com.wipro.selenium.ta;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class TestCase04 {
	private WebDriver driver;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A474106\\eclipse-workspace\\seleniumFiles\\exeFiles\\chromedriver_win32\\chromedriver.exe"); //TODO Create Properties file
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void test04() {
		Utils helper = new Utils();
		driver.manage().window().maximize();
		driver.get("https://www.netshoes.com.br/");
		driver.findElement(By.linkText("Entrar")).click();
		helper.mouseMove(driver, "#header-user-anonymous .ns-icon-user-ico");
		driver.findElement(By.linkText("Login")).click();
		helper.waitElementBeVisible(driver, "username", 30);
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("valhallen.hero@gmail.com");
		driver.findElement(By.id("password")).sendKeys("FakePassword");
		driver.findElement(By.id("login-button")).click();
		helper.waitElementBeVisible(driver, "errors-wrapper", 30);
		helper.highLighter(driver, driver.findElement(By.id("errors-wrapper")));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
