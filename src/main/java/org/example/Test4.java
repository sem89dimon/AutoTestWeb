package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test4 {
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
            WebElement webElement1 = driver.findElement(By.xpath("//*[@id=\"category-9\"]"));
            webElement1.click();

            Thread.sleep(3000);
            WebElement webElement2 = driver.findElement(By.xpath("//*[@id=\"category-header\"]/div[2]/div/div"));
            webElement2.click();

            Thread.sleep(3000);
            WebElement webElement3 = driver.findElement(By.xpath("//*[@id=\"category-header\"]/div[2]/div/div/div[1]/ul/li[4]"));
            webElement3.click();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
