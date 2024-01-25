package by.itacademy.zhiznevskaya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NlbPage {
    public String personalCabinetXpath = "//*[contains(@title,'Вход / Регистрация')]";
    public String formAuthorizationXpath = "//div[contains(text(),'Вход в личный кабинет')]";
    public String authorizationFormLoginXpath = "//input[contains(@name,'USER_LOGIN')]";
    public String authorizationFormPasswordXpath = "//input[contains(@name,'USER_PASSWORD')]";

    public String authorizationFormEnterButtonXpath = "//input[contains(@value,'Войти')]";
    public String ecatalogNlbLinkXpath = "//span[contains(text(),'Электронный каталог')]";
    public String searchFieldEcalatalogXpath = "//input[contains(@name,'lookfor')]";
    public String buttonSearchEcalatalogXpath = "//button[contains(@class,'btn btn-primary')]";
    public String searchResultsMessageXpath = "//*[contains(@class,'hidden-print search-controls row')]";
    private WebDriver driver;

    public NlbPage(WebDriver driver) {
        this.driver = Driver.getDriver();
        this.driver.get("https://www.nlb.by/");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickLinkPersonalCabinet() {
        By personalCabinetBy = By.xpath(personalCabinetXpath);
        WebElement personalCabinetElement = driver.findElement(personalCabinetBy);
        personalCabinetElement.click();
    }

    public boolean isAuthorizationFormOpened() {
        boolean isFormOpened = false;
        By authorizationFormOpenedBy = By.xpath(formAuthorizationXpath);
        WebElement formAuthorizationXpathElement = driver.findElement(authorizationFormOpenedBy);

        if (formAuthorizationXpathElement.isDisplayed()) {
            isFormOpened = true;
        } else {
            isFormOpened = false;
        }
        return isFormOpened;
    }

    public void enterCorrectFieldsAuthorizationForm() {
        By authorizationFormLoginBy = By.xpath(authorizationFormLoginXpath);
        WebElement authorizationFormLoginElement = driver.findElement(authorizationFormLoginBy);
        authorizationFormLoginElement.sendKeys("NikaZhiznevskaya");
        By authorizationFormPasswordBy = By.xpath(authorizationFormPasswordXpath);
        WebElement authorizationFormPasswordElement = driver.findElement(authorizationFormPasswordBy);
        authorizationFormPasswordElement.sendKeys("AlexNika5");
        By authorizationFormEnterButtonBy = By.xpath(authorizationFormEnterButtonXpath);
        WebElement authorizationFormEnterButtonElement = driver.findElement(authorizationFormEnterButtonBy);
        authorizationFormEnterButtonElement.click();
    }

    public void redirectToECatalogNlb() {

        /*By ecatalogNlbLinkBy = By.xpath(ecatalogNlbLinkXpath);
        WebElement ecatalogNlbLinkElement = driver.findElement(ecatalogNlbLinkBy);
        ecatalogNlbLinkElement.click();
        */
    }

    public String enterSearchParametr(String searchParametrSendKey) {
        By searchFieldEcatalogBy = By.xpath(searchFieldEcalatalogXpath);
        WebElement searchFieldEcatalogElement = driver.findElement(searchFieldEcatalogBy);
        searchFieldEcatalogElement.sendKeys(searchParametrSendKey);

        By buttonSearchEcalatalogBy = By.xpath(buttonSearchEcalatalogXpath);
        WebElement buttonSearchEcalatalogElement = driver.findElement(buttonSearchEcalatalogBy);
        buttonSearchEcalatalogElement.click();
        return driver.findElement(By.xpath(searchResultsMessageXpath)).getText();
    }
}
