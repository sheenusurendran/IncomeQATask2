package com.test.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public Base(WebDriver driver, WebDriverWait wait) {
        Base.driver = driver;
        Base.wait = wait;
    }

    // Fluent wait if any of the elements requires extra time to load
    protected void WaitUntilElementVisible(WebElement element) {
        try {
            PropertyReader prop = new PropertyReader();
            wait = new WebDriverWait(driver, prop.getTimeout());
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
