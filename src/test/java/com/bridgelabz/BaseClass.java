package com.bridgelabz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;



public class BaseClass {

    enum DriverType {CHROMEDRIVER, MOZILLA_FIREFOX}

    ;
    public WebDriver driver;


//    public String userChoice() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Select the driver\n1.ChormeDriver\n2.Mozilla Firefox");
//        String choice = sc.nextLine();
//        return choice;
//    }

//    @BeforeMethod
//    @Parameters("browser")
//    public void setUp(String browser) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
//            driver = new ChromeDriver();
//        }
//        else if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.geckodriver.driver", "./Drivers/firefox-geckodriver_72.0.1+build1-0ubuntu0.18.04.1_amd64-1.deb");
//            driver = new FirefoxDriver();
//        }
//    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
