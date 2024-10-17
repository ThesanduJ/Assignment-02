package org.example.assignment02.util;

import java.util.UUID;

public class AppUtil {
    public static String generateOrderID(){
        return "O-"+ UUID.randomUUID();
    }
}
