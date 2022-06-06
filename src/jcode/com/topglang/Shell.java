package jcode.com.topglang;

import jcode.com.topglang.nano.NanoLexer;
import jcode.com.topglang.util.PrinterUtil;

import java.io.*;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        PrinterUtil.println("Execute command");
        String command = reader.nextLine();
        switch (command) {
            case ".topg -type file":
                PrinterUtil.println("Enter file path:");
                String filepath = reader.nextLine();
                File file = new File(filepath);
                NanoLexer.lex(file);
                break;
        }
    }
}
