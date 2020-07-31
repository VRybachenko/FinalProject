package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static Integer extractIntFromString(String items) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(items);
        Integer extractedInt = null;
        while (matcher.find()) {
            extractedInt = Integer.parseInt(matcher.group());
        }
        return extractedInt;
    }

    public static Double extractDoubleFromString(String price) {
        Pattern pattern = Pattern.compile("\\d+.\\d+");
        Matcher matcher = pattern.matcher(price);
        Double extractedDouble = null;
        while (matcher.find()) {
            extractedDouble = Double.parseDouble(matcher.group());
        }
        return extractedDouble;
    }

    public static String convertIntToString(int integerValue) {
        String stringValue = String.valueOf(integerValue);
        return stringValue;
    }
}
