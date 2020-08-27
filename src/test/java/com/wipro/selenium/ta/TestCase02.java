package com.wipro.selenium.ta;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class TestCase02 {
	
	
	private WebDriver driver;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A474106\\eclipse-workspace\\seleniumFiles\\exeFiles\\chromedriver_win32\\chromedriver.exe"); //TODO Create Properties file
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void test02() {
		Utils helper = new Utils();
		driver.manage().window().maximize();
		driver.get("https://www.netshoes.com.br/");
		driver.findElement(By.linkText("Entrar")).click();
		helper.mouseMove(driver, "#header-user-anonymous .ns-icon-user-ico");
		driver.findElement(By.linkText("Login")).click();
		helper.waitElementBeVisible(driver, "username", 30);
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("valhallen.hero@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Asd123!.");
		driver.findElement(By.id("login-button")).click();
		helper.waitElementBeVisible(driver, "username-logged", 30);
		helper.mouseMove(driver, "#header-user-logged .ns-icon-user-ico");
		driver.findElement(By.linkText("Minha conta")).click();
		driver.findElement(By.linkText("Seus dados")).click();
		{
			helper.waitElementBeVisible(driver, "fullname", 30);
			String value = driver.findElement(By.id("fullname")).getAttribute("value");
			assertThat(value, is("Valhallen Hero"));
			helper.highLighter(driver, driver.findElement(By.id("fullname")));
		}
		driver.findElement(By.linkText("Sair")).click();
		helper.waitElementBeVisible(driver, "header-user-anonymous", 30);
		helper.mouseMove(driver, "#header-user-anonymous .ns-icon-user-ico");
		assertThat(driver.findElement(By.linkText("Login")).getText(), is("Login"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
