package by.itacademy.zhiznevskaya.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Driver {
        private static WebDriver driver;
        public static WebDriver getDriver(){
            if(driver ==null){
                driver =new ChromeDriver();
            }
            return driver;
        }
        public static void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
            public static void redirectUrlDriver() {
                if (driver != null) {
                    driver.get("https://e-catalog.nlb.by/");
                }
            }
        }

