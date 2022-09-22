package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test1 {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://kazanexpress.ru");

        try {
            WebElement webElement1 = driver.findElement(By.xpath(".//*[@data-test-id=\"button__auth\"]"));
            webElement1.click();

            WebElement webElement2 = driver.findElement(By.xpath("//*[@data-test-id=\"input__login\"]"));
            // webElement2.click();
            webElement2.sendKeys("+79046605827");

            WebElement webElement3 = driver.findElement(By.xpath("//*[@data-test-id=\"input__password\"]"));
            webElement3.sendKeys("Password1234.", Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
