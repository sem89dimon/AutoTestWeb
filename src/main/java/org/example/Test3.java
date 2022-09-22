package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://kazanexpress.ru");


        try {
            WebElement webElement4 = driver.findElement(By.xpath("//*[@id=\"cart-button\"]"));
            webElement4.click();

            Thread.sleep(3000);
            WebElement webElement5 = driver.findElement(By.cssSelector("div[class=social] a:nth-child(1)"));
            webElement5.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}

