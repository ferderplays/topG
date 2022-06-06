package jcode.com.topglang.util;

public class PrinterUtil {
    public static void println(Object message) {
        System.out.println(message);
    }

    public static void print(Object message) {
        System.out.print(message);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
