package by.itacademy.zhiznevskaya.ui;
import by.itacademy.zhiznevskaya.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

        WebDriver driver;

        @AfterEach
        public void finish() {
            Driver.quitDriver();
        }
    }

