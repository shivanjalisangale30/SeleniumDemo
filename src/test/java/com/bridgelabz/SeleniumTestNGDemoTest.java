package com.bridgelabz;

import org.testng.annotations.Test;

public class SeleniumTestNGDemoTest {

    @Test(description = "Set the  setup method", priority = 1)
    public void setup() {
        System.out.println("This is setup Test.");
    }

    @Test(description = "Login method",priority = 2)
    public void login() {
        System.out.println("This is login Test.");
    }

    @Test(description = "Logout method",priority = 3)
    public void logout() {
        System.out.println("This is closing browser");
    }
}
