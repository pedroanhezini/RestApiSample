package br.com.pedroanhezini.api.utils;

public class NumberUtils {

    public static Integer toInteger(String str, Integer defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException var3) {
                return defaultValue;
            }
        }
    }

}
