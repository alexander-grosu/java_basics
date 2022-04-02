import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Slf4j
@DisplayName("Calculator tests")
public class CalculatorTest {
    private static List<String> digits;
    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        digits = new ArrayList<>();
        calculator = new Calculator();
    }

    @BeforeEach
    void init() {
        digits.add(" 17");
        digits.add("-3 ");
        digits.add(" 145.07");
        digits.add("-3.9 ");
        digits.add("abc");
        digits.add("");
        digits.add("34xyz");
        digits.add(null);
    }

    @Test
    @DisplayName("calculate sum of all int digits from list")
    void testCalculateIntSum() {
        int actual = calculator.calculateIntSum(digits);
        if (14 == actual) {
            log.info("test is successful");
        } else {
            log.info("test is wrong");
        }
        Assertions.assertEquals(14, actual);
    }

    @Test
    @DisplayName("calculate sum of all double digits from list")
    void testCalculateDoubleSum() {
        double actual = calculator.calculateDoubleSum(digits);
        if (141.17 == actual) {
            log.info("test is successful");
        } else {
            log.info("test is wrong");
        }
        Assertions.assertFalse(141.17 < actual);
        Assertions.assertFalse(141.17 > actual);
    }

    @Test
    @DisplayName("calculate sum of all double & int digits from list")
    void testCalculateAllDigitsSum() {
        double actual = calculator.calculateAllDigitsSum(digits);
        if (155.17 == actual) {
            log.info("test is successful");
        } else {
            log.info("test is wrong");
        }
        Assertions.assertTrue(155.17 == actual);
    }

    @AfterEach
    void tearDown() {
        digits.clear();
    }
}
