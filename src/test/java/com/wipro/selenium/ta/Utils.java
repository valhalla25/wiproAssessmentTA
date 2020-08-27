package com.wipro.selenium.ta;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public void highLighter(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	
	public void waitElementBeVisible(WebDriver driver, String element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
	}
	
	public void mouseMove(WebDriver driver, String elementString) {
		WebElement element = driver.findElement(By.cssSelector(elementString));		//For sure it is not good to search elements by CSS, it was just a pattern found for those test
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
	}
	
}
