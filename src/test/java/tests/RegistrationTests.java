package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.TestData;

public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage;

    @BeforeMethod
    public void navigateToRegistrationPage() {

        registrationPage = new RegistrationPage(page);
        registrationPage.navigateToRegistrationPage();
        page.waitForSelector("input[placeholder='John']");
    }

    @Test
    public void successfulRegisterTest() {

        registrationPage.createAccount(
                TestData.generateFirstName(),
                TestData.generateLastName(),
                TestData.generateEmail(),
                TestData.validPassword
        );

        Assert.assertFalse(registrationPage.getCurrentUrl().contains("home"));
    }

    @Test
    public void duplicateEmailTest() {

        String email = ConfigReader.getProperty("admin.email");

        registrationPage.createAccount(
                TestData.generateFirstName(),
                TestData.generateLastName(),
                email,
                TestData.validPassword
        );



        Assert.assertTrue(registrationPage.getCurrentUrl().contains("register"));
        Assert.assertTrue(registrationPage.isMessageVisible("Email already registered"));
    }

    @Test
    public void invalidEmailFormatTest() {

        registrationPage.createAccount(
                TestData.generateFirstName(),
                TestData.generateLastName(),
                TestData.invalidEmail,
                TestData.validPassword
        );

        Assert.assertTrue(registrationPage.getCurrentUrl().contains("register"));
    }

    @Test
    public void missingFirstNameTest() {

        registrationPage.createAccount(
                "",
                TestData.generateLastName(),
                TestData.invalidEmail,
                TestData.validPassword
        );
        page.waitForTimeout(30000);

        Assert.assertTrue(registrationPage.getCurrentUrl().contains("register"));
    }

    @Test
    public void missingAllFieldsTest() {

        registrationPage.createAccount("", "", "", "");

        Assert.assertTrue(registrationPage.getCurrentUrl().contains("register"));
    }
}