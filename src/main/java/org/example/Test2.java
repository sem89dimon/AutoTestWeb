package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test2 {


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://kazanexpress.ru");


        try {
            WebElement webElement1 = driver.findElement(By.name("q"));
            webElement1.sendKeys("пикачу", Keys.ENTER);

            Thread.sleep(3000);
            WebElement webElement2 = driver.findElement(By.xpath("//*[@id=\"category-products\"]/div[25]/a"));
            webElement2.click();

            Thread.sleep(5000);
            WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"product-info\"]/div[2]/div[5]/div/div/div[1]/button"));
            webElement3.click();
            WebElement webElement4 = driver.findElement(By.xpath("//*[@id=\"cart-button\"]"));
            webElement4.click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }





    }
}
