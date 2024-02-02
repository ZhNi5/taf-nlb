package by.itacademy.zhiznevskaya.ui;

import by.itacademy.zhiznevskaya.api.TestApiNlb;
import by.itacademy.zhiznevskaya.driver.Driver;
import by.itacademy.zhiznevskaya.pages.NlbPage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUINlb extends BaseTest {
    protected static final Logger logger = Logger.getLogger(TestUINlb.class.getName());
    @Test
    public void nlbAouthorizationtest() throws InterruptedException {

        NlbPage nlbPagePersonalCabinet = new NlbPage(Driver.getDriver());
        nlbPagePersonalCabinet.clickLinkPersonalCabinet();
        Thread.sleep(5000);
        boolean actual = nlbPagePersonalCabinet.isAuthorizationFormOpened();
        boolean expected = true;
        nlbPagePersonalCabinet.enterCorrectFieldsAuthorizationForm();
        Assertions.assertEquals(expected, actual);
        logger.info("nlbAouthorizationtest passed with the result " );

    }

    @Test
    public void redirectToECatalogNlb() throws InterruptedException {
        NlbPage nlbPagePersonalCabinet = new NlbPage(Driver.getDriver());
        nlbPagePersonalCabinet.getDriver().get("https://e-catalog.nlb.by/");
        Thread.sleep(5000);
    }

    @Test
    public void ecatalogNlbSearchField() throws InterruptedException {
        NlbPage nlbPageSearch = new NlbPage(Driver.getDriver());
        nlbPageSearch.getDriver().get("https://e-catalog.nlb.by/");
        Thread.sleep(5000);
        String searchParametrSendKey = "Якуб Колас";
        String searchResult = nlbPageSearch.enterSearchParametr(searchParametrSendKey);
        Boolean actual = true;
        Boolean expected = searchResult.contains(searchParametrSendKey);
        Assertions.assertEquals(expected, actual);
        logger.info("ecatalogNlbSearchField passed with the result " );
    }
}