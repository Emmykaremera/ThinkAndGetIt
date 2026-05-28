package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestData;

public class AuthTest extends BaseTest {

    @Test
    public void positiveLoginTest(){

        LoginPage loginPage =
                new LoginPage(page);

        loginPage.login(
                TestData.EMAIL,
                TestData.PASSWORD
        );

        Assert.assertTrue(
                page.url().contains("login"),
                "Login sucessful"
        );
    }
}

