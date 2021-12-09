package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

   public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;
        String osName= System.getProperty("os.name");
       //System.out.println(osName);
       if (osName.toLowerCase().startsWith("windows") && browserType.equalsIgnoreCase("safari")) {
           return null;
       }else if (osName.toLowerCase().startsWith("mac") && browserType.equalsIgnoreCase("edge")) {
           return null;
       } else {
           switch (browserType.toLowerCase()) {
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
                   break;
               case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                   break;
               case "safari":
                   WebDriverManager.safaridriver().setup();
                   driver = new SafariDriver();
                   break;
               default:
                   return null;
           }

           return driver;
       }


   }
}
