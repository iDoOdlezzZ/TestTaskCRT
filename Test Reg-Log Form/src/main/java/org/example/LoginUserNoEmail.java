package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginUserNoEmail {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web-driver.chrome.driver", "C:\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            driver.get("http://localhost:5000/");
            Thread.sleep(2000);

            WebElement loginuser = driver.findElement(By.xpath("//a[@href='/login']"));
            loginuser.click();

            WebElement passinput = driver.findElement(By.xpath("//input[@type='password']"));
            passinput.sendKeys("qwerty");

            WebElement loginuserbut = driver.findElement(By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']"));
            loginuserbut.click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }

}