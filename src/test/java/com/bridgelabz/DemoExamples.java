package com.bridgelabz;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class DemoExamples extends BaseClass {
    @Test
    public void CaptureScreenshot_ActiTIMEPage() throws IOException {
        Date date = new Date();
        String date1 = date.toString();
        String date2 = date.toString().replaceAll(":", "-");
        System.out.println("Date:" + date1);
        System.out.println("Replacement" + date2);
        driver.get("https://fundoopush-dev.bridgelabz.com/login");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File desFile = new File("/home/admin1/Desktop/Selenium/ScreenShots/" + date2 + "LoginScreenshot.jpg");
        FileUtils.copyFile(srcFile, desFile);
    }

    @Test
    public void browserNavigationExample() throws InterruptedException {
        driver.get("https://fundoopush-dev.bridgelabz.com/login");
        driver.navigate().to("https://www.gmail.com");
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
    }

    @Test
    public void upcastingToWebDriver_LaunchBrowser() throws InterruptedException {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Title is " + title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Url is " + currentUrl);
        String pageSource = driver.getPageSource();
        System.out.println("PageSource" + pageSource);
        Thread.sleep(2000);
    }

    @Test
    public void Keyboard_Mouse_Operations() throws InterruptedException, AWTException {
        driver.navigate().to("https://fundoopush-dev.bridgelabz.com/login");
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.mouseMove(300, 500);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_ALT);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        Thread.sleep(2000);
    }


    @Test
    public void LocatorsExample_ById() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement user = driver.findElement(By.id("email"));
        user.clear();
        user.sendKeys("shivanjali");
        WebElement pass = driver.findElement(By.name("pass"));
        pass.clear();
        Thread.sleep(2000);
        pass.sendKeys("147859623");
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(2000);
    }

    @Test
    public void LocatorsExample_ByName() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement user = driver.findElement(By.name(""));
        user.clear();
        user.sendKeys("shivanjali");
        WebElement pass = driver.findElement(By.name("pass"));
        pass.clear();
        Thread.sleep(2000);
        pass.sendKeys("147859623");
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(2000);
    }
}
