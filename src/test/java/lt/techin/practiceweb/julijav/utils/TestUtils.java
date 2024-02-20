package lt.techin.practiceweb.julijav.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;


public class TestUtils {

    public static String getRandomEmail() {
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";

        return RandomStringUtils.random(1, upperLetters)
                + RandomStringUtils.random(9, lowerLetters)
                + RandomStringUtils.random(2, numbers)
                + System.currentTimeMillis()
                + "@yahoo.co.uk";
    }

    public static String getRandomEmailSimple() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        return ("Julija" + randomInt + "@yahoo.co.uk");
    }

    public static String getRandomName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String getRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public static String getRandomTwoNumber() {
        return RandomStringUtils.randomNumeric(1, 2);
    }

    public static String getRandomNumberFrom1To20() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 21));
    }
}
