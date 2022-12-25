package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegUser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web-driver.chrome.driver", "C:\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            driver.get("http://localhost:5000/");
            Thread.sleep(2000);

            WebElement signup = driver.findElement(By.xpath("//a[@href='/signup']"));
            signup.click();

            WebElement emailinput = driver.findElement(By.xpath("//input[@name='email']"));
            emailinput.sendKeys("mail@mail.com");

            WebElement nameinput = driver.findElement(By.xpath("//input[@name='name']"));
            nameinput.sendKeys("Andrew");

            WebElement passinput = driver.findElement(By.xpath("//input[@name='password']"));
            passinput.sendKeys("qwerty");

            WebElement signupbut = driver.findElement(By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']"));
            signupbut.click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }

}