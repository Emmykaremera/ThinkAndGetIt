package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestData;

public class AuthTest extends BaseTest {

    @Test
    public void positiveLoginTest(){

        LoginPage loginPage = new LoginPage(page);

        loginPage.login(
                TestData.EMAIL,
                TestData.PASSWORD
        );

        Assert.assertTrue(
                page.url().contains("login"),
                "Login Successful"
        );
    }

//    @Test
//    public void negativeLoginTest(){
//
//        LoginPage loginPage = new LoginPage(page);
//
//        loginPage.login(
//                TestData.INVALID_EMAIL,
//                TestData.INVALID_PASSWORD
//        );
//
//        page.waitForTimeout(2000);
//
//        String actualError = loginPage.getErrorMessage();
//
//        System.out.println("Actual error: " + actualError);
//
//        Assert.assertTrue(
//                actualError != null &&
//                        actualError.toLowerCase().contains("invalid"),
//                "Error message should indicate invalid login"
//        );
//    }
}