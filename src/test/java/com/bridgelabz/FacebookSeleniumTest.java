package com.bridgelabz;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;


public class FacebookSeleniumTest extends BaseClass {

    String facebookURL = "https://www.facebook.com";

    @Test
    public void CaptureScreenshot_ActiTIMEPage() throws IOException{
        Date date = new Date();
        String date1 = date.toString();
        String date2 = date.toString().replaceAll(":", "-");
        System.out.println("Date:" + date1);
        System.out.println("Replacement" + date2);
        driver.get(facebookURL);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = new Object() {}.getClass().getEnclosingMethod().getName();
        File desFile = new File("/home/admin1/Desktop/SeleniumDemo/Screenshotes/" + date2 + imageName + ".jpg");
        FileUtils.copyFile(srcFile, desFile);
    }

    @Test
    public void browserNavigationExample() throws InterruptedException {
        driver.get(facebookURL);
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
        driver.get(facebookURL);
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
        driver.navigate().to(facebookURL);
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
        driver.get(facebookURL);
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
        driver.get(facebookURL);
        WebElement user = driver.findElement(By.name("email"));
        user.clear();
        user.sendKeys("shivanjali");
        WebElement pass = driver.findElement(By.name("pass"));
        pass.clear();
        Thread.sleep(2000);
        pass.sendKeys("147859623");
        driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
        Thread.sleep(2000);
    }


    @Test
    public void LocatorsExample_Bycssselector() throws InterruptedException {
        driver.get(facebookURL);
        WebElement user = driver.findElement(By.cssSelector(" #email"));
        user.clear();
        user.sendKeys("shivanjali");
        WebElement pass = driver.findElement(By.name("pass"));
        pass.clear();
        Thread.sleep(2000);
        pass.sendKeys("147859623");
        driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void LocatorsExample_Byxpath() throws InterruptedException {
        driver.get(facebookURL);
        //xPath for user
        String xpUser = "//input[@id='email']";
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpUser)).sendKeys("9869191658");
        Thread.sleep(2000);
        //xPath for pwd
        String xpPWD = "//input[@id='pass']";
        driver.findElement(By.xpath(xpPWD)).sendKeys("sonu&12345");
        Thread.sleep(2000);
        //xPath for image
        String xpImage = "//div[@class='_5iyy']//img[@class='img']";
        WebElement image = driver.findElement(By.xpath(xpImage));
        String widthImage = image.getAttribute("width");
        System.out.println("Width of the image is " + widthImage);
        String heightImage = image.getAttribute("height");
        System.out.println("Height of the image is " + heightImage);
        //xPath for login
        String xpLogin = "//input[@id='u_0_b']";
        driver.findElement(By.xpath(xpLogin)).click();
        Thread.sleep(2000);
    }

    @Test
    public void LocatorsExample_For_Alert() throws InterruptedException, IOException {
        driver.get(facebookURL);
        //xPath for user
        String xpUser = "//input[@id='email']";
        driver.findElement(By.xpath(xpUser)).sendKeys("9869191658");
        //xPath for pwd
        String xpPWD = "//input[@id='pass']";
        driver.findElement(By.xpath(xpPWD)).sendKeys("sonu&12345");
        //xPath for login
        String xpLogin = "//input[@id='u_0_b']";
        driver.findElement(By.xpath(xpLogin)).click();
//        WebElement permission = driver.findElement(By.cssSelector("#permissionHeader"));
        Actions action = new Actions(driver);
        WebElement block = driver.findElement(By.xpath("//input[@id'permissionHeader']"));
        action.click(block).perform();

//        System.out.println("Permissiion Header"+permissionHeader);
//        driver.switchTo().alert().dismiss();
    }

}
//md-select
//    //xPath for image
//    String xpImage = "//div[@class='_5iyy']//img[@class='img']";
//    WebElement image = driver.findElement(By.xpath(xpImage));
//    String widthImage = image.getAttribute("width");
//        System.out.println("Width of the image is " + widthImage);
//                String heightImage = image.getAttribute("height");
//                System.out.println("Height of the image is " + heightImage);

//        Thread.sleep(5000);
//        TakesScreenshot captueIamge = (TakesScreenshot) driver;
//        File srcFile = captueIamge.getScreenshotAs(OutputType.FILE);
//        String imageCapture = new Object() {}.getClass().getEnclosingMethod().getName();
//        File desFile = new File("/home/admin1/Desktop/SeleniumDemo/Screenshotes/"+imageCapture+".jpg");
//        FileUtils.copyFile(srcFile,desFile);