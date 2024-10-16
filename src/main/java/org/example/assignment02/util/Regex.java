package org.example.assignment02.util;

import java.util.regex.Pattern;

public class Regex {
    public static boolean checkPhoneNumber(String phoneNumber) {
        String regexForNumber = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(regexForNumber);
        return pattern.matcher(phoneNumber).matches();
    }
    public static boolean checkItemCode(String itemId) {
        String regexForItemId="^[A-Za-z0-9]{6,10}$\n";
        Pattern pattern = Pattern.compile(regexForItemId);
        return pattern.matcher(itemId).matches();
    }
}
