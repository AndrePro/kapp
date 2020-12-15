import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double value = 000001.1237;
        System.out.println(formatRate(value, 2));
    }


    public static String formatRate(double value, int numberOfDecimals) {
        return getNumberFieldFormat(value, getPattern(numberOfDecimals));
    }


    private static String getPattern(int numberOfDecimals) {
        String patternFormat = "#0".concat(".");
        char[] fractionPattern = new char[numberOfDecimals];
        Arrays.fill(fractionPattern, '0');
        patternFormat = patternFormat.concat(new String(fractionPattern));
        return patternFormat;
    }


    private static String getNumberFieldFormat(Object value, String pattern) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');


        double amount = (Double) value;
        if (pattern.startsWith("0")) {
            if (amount < 0.0D) {
                pattern = pattern.substring(1);
            }

            if (symbols.getDecimalSeparator() == 0) {
                pattern = "0" + pattern;
            }
        }

        if (pattern == null) {
            return null;
        } else {
            if (symbols.getGroupingSeparator() == 0) {
                StringBuilder res = new StringBuilder(pattern);

                for (int i = res.length() - 1; i >= 0; --i) {
                    if (res.charAt(i) == ',') {
                        res.deleteCharAt(i);
                    }
                }
            }
            return new DecimalFormat(pattern, symbols).format(value);
        }
    }
}