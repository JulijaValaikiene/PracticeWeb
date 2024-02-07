package lt.techin.practiceweb.julijav.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;


public class TestUtils {

    private static final Logger log = getLogger(lookup().lookupClass());



    public static String getRandomEmail() {
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";

        return RandomStringUtils.random(1, upperLetters)
                + RandomStringUtils.random(5, lowerLetters)
                + RandomStringUtils.random(3, numbers)
                + System.currentTimeMillis()
                + "@gmail.com";
    }
}
