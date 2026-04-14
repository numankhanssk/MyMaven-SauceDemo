package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {

        // FIX 1: Auto-download correct ChromeDriver
        WebDriverManager.chromedriver().setup();

        // FIX 2: Stable Chrome options for Linux
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        // FIX 3: Start driver
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");
            System.out.println("Title: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}
