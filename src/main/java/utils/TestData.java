package utils;

import com.github.javafaker.Faker;

public class TestData {

    private static final Faker faker = new Faker();

    public static String invalidEmail =
            ConfigReader.getProperty("user.invalidEmail");

    public static String validPassword =
            ConfigReader.getProperty("user.password");

    public static String invalidPassword =
            ConfigReader.getProperty("user.invalidPassword");

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static final String EMAIL =
            "emmy.byiringiro2023@kepler.org";

    public static final String PASSWORD =
            "0788840904";

    public static final String INVALID_EMAIL =
            "emmy.byiringiro2023@gmail.com";

    public static final String INVALID_PASSWORD =
            "wrong_password";
}