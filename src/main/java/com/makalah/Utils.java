package com.makalah;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> getItemList(String textBox) {
        return Arrays.asList(textBox.split("\n"));
    }

    public static int getPrice(String string) {
        try {
            return Integer.parseInt(string.substring(string.indexOf(",")+1));
        }
        catch (NumberFormatException e) {
            return Integer.parseInt(string.substring(string.indexOf(",")+2));
        }
    }
}