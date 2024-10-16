package org.example.assignment02.util;

import java.util.regex.Pattern;

public class Regex {
    public static boolean checkPhoneNumber(String phoneNumber) {
        String regexForNumber = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(regexForNumber);
        return pattern.matcher(phoneNumber).matches();
    }
}
