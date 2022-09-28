package integration.factory.web.enums;

import io.github.bonigarcia.wdm.WebDriverManager;
import integration.factory.interfaces.ApplicationWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;

public enum Web implements ApplicationWeb {


    CHROME {
        @Override
        public WebDriver getDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1920,1200");
            return new ChromeDriver(options);
        }
    },

    FIREFOX {
        @Override
        public WebDriver getDriver() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },

    EDGE {
        @Override
        public WebDriver getDriver() {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("mac")) {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/mac/msedgedriver");
            }
            return new EdgeDriver();
        }
    },

    SAFARI {
        @Override
        public WebDriver getDriver() {
            return new SafariDriver();
        }
    },

    TOR {
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/mac/geckodriver");
            FirefoxProfile profile = new FirefoxProfile(new File("/Users/guilhermeteixeira/Library/Application Support/TorBrowser-Data/Browser/52km4pup.default"));
            FirefoxBinary binary = new FirefoxBinary(new File("/Applications/Tor Browser.app/Contents/MacOS/firefox"));
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(binary);
            options.setProfile(profile);
            return new FirefoxDriver(options);
        }
    },

    BRAVE {
        @Override
        public WebDriver getDriver() {
            String os = System.getProperty("os.name").toLowerCase();
            ChromeOptions options;
            if (os.contains("mac")) {
                options = new ChromeOptions().setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
            } else {
                options = new ChromeOptions().setBinary(System.getProperty("user.dir") + "/windows/drivers/BraveBrowserSetup.exe");
            }
            return new ChromeDriver(options);
        }
    },

}
