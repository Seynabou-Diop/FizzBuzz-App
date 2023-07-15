import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FizzBuzzTest {

    @Test
    public void testGetFizzBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> results = fizzBuzz.getFizzBuzz();

        Assertions.assertEquals(100, results.size());

        // Test for numbers not divisible by 3 or 5
        for (int i = 1; i <= 100; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                Assertions.assertEquals(String.valueOf(i), results.get(i - 1));
            }
        }

        // Test for numbers divisible by 3 but not 5
        for (int i = 3; i <= 100; i += 3) {
            if (i % 5 != 0) {
                Assertions.assertEquals("Fizz", results.get(i - 1));
            }
        }

        // Test for numbers divisible by 5 but not 3
        for (int i = 5; i <= 100; i += 5) {
            if (i % 3 != 0) {
                Assertions.assertEquals("Buzz", results.get(i - 1));
            }
        }

        // Test for numbers divisible by both 3 and 5
        for (int i = 15; i <= 100; i += 15) {
            Assertions.assertEquals("FizzBuzz", results.get(i - 1));
        }

        // Test for numbers containing 3 but not divisible by 5
        for (int i = 13; i <= 100; i += 10) {
            if (i % 5 != 0 && !Integer.toString(i).contains("3")) {
                Assertions.assertEquals("Fizz", results.get(i - 1));
            }
        }

        // Test for numbers containing 5 but not divisible by 3
        for (int i = 52; i <= 100; i += 10) {
            if (i % 3 != 0 && !Integer.toString(i).contains("5")) {
                Assertions.assertEquals("Buzz", results.get(i - 1));
            }
        }

    }
}
