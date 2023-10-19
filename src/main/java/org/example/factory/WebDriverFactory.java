package org.example.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver createWebDriver(String os, String browser) throws Exception {
        WebDriver driver;
        switch (os) {
            case "windows 10":
                driver = createDriverForWindows(browser);
                break;
            case "mac":
                driver = createDriverForMac(browser);
                break;
            case "linux":
                driver = createDriverForLinux(browser);
                break;
            default:
                throw new Exception("El sistema operativo " + os + " no es soportado");
        }
        return driver;
    }

    private static WebDriver createDriverForWindows(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new Exception("El navegador " + browser + " no es soportado");
        }
    }

    private static WebDriver createDriverForMac(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
                return new FirefoxDriver();
            default:
                throw new Exception("El navegador " + browser + " no es soportado");
        }
    }
    private static WebDriver createDriverForLinux(String browser) throws Exception {
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/Linux/chromedriver");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "resources/Linux/geckodriver");
                return new FirefoxDriver();
            default:
                throw new Exception("El navegador " + browser + " no es soportado");
        }
    }
}
