import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] digitsArray = {"3", "2.18769  ", "  259  ", null, "  75", "100", "245.01", "-2.5", "-3"};
        List<String> digitsList = new ArrayList<>(digitsArray.length);
        CollectionUtils.addAll(digitsList, digitsArray);

        Calculator calculator = new Calculator();
        calculator.calculateDoubleSum(digitsList);
        calculator.calculateIntSum(digitsList);
        calculator.calculateAllDigitsSum(digitsList);

    }
}
