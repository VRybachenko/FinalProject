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
        return Double.parseDouble(price.replaceAll("[^a-zA-Z0-9.]", ""));
    }

    public static String convertIntToString(int integerValue) {
        String stringValue = String.valueOf(integerValue);
        return stringValue;
    }
}
