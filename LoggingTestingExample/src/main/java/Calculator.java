import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Calculator {
    public Double calculateDoubleSum(@NotNull List<String> list) {
        list.removeAll(Collections.singletonList(null));
        double sum = 0.0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String digit = it.next().trim();
            Pattern pattern = Pattern.compile("[-]?[0-9]+\\.[0-9]+");
            Matcher matcher = pattern.matcher(digit);
            if (matcher.matches()) {
                sum += Double.parseDouble(digit);
            }
        }
        log.info("sum of all double digits from list: " + sum);
        return sum;
    }

    public Integer calculateIntSum(@NotNull List<String> list) {
        list.removeAll(Collections.singletonList(null));
        int sum = 0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String digit = it.next().trim();
            Pattern pattern = Pattern.compile("[-]?[0-9]+");
            Matcher matcher = pattern.matcher(digit);
            if (matcher.matches()) {
                sum += Integer.parseInt(digit);
            }
        }
        log.info("sum of all int digits from list: " + sum);
        return sum;
    }

    public Double calculateAllDigitsSum(@NotNull List<String> list) {
        list.removeAll(Collections.singletonList(null));
        double sum = 0.0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String digit = it.next().trim();
            Pattern pattern = Pattern.compile("([-]?[0-9]+\\.[0-9]+)|([-]?[0-9]+)");
            Matcher matcher = pattern.matcher(digit);
            if (matcher.matches()) {
                sum += Double.parseDouble(digit);
            }
        }
        log.info("sum of all int & double digits from list: " + sum);
        return sum;
    }
}
