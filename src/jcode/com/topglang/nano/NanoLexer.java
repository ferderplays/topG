package jcode.com.topglang.nano;

import jcode.com.topglang.util.PrinterUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NanoLexer {

    public static void lex(File file) { try { analizeFile(file); } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException ioException) { ioException.printStackTrace(); } }

    private static void analizeFile(File file) throws IOException, FileNotFoundException {
        List<String> classlist = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String code = br.readLine(), message = "", letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", classname = "";
        char[] alphabet = letters.toCharArray(), uppercase = UPPER.toCharArray();
        if (code == null) return;
        if (code.charAt(0) == 'p' && code.charAt(1) == '(' ) {
            boolean b = code.charAt(3) == ')' && code.charAt(4) == ';', b2 = code.charAt(4) == ')' && code.charAt(5) == ';';
            for (Character c : alphabet) {
                if (code.charAt(2) == c) {
                    message += code.charAt(2);
                    if (b) PrinterUtil.print(message);

                }

                if (code.charAt(2) == c && code.charAt(3) == c) {
                    message += code.charAt(2) + code.charAt(3);
                    if (b2) PrinterUtil.print(message);
                }
            }
        }

        if (code.charAt(0) == 'c' && code.charAt(1) == ' ') {
            for (Character c : alphabet) {
                for (char uc : uppercase) {
                    if (code.charAt(2) == uc && code.charAt(3) == '(') {
                        classname += code.charAt(2);
                        classlist.add(classname);
                        boolean b3 = code.charAt(3) == '(' && code.charAt(4) == ')' && code.charAt(5) == ':';
                        if (b3) {
                            String line2 = br.readLine();
                            if (line2 == null) return;
                            else if (line2.charAt(3) == 'i' && line2.charAt(4) == 'n' && line2.charAt(5) == 'i' && line2.charAt(6) == 't' && line2.charAt(7) == ' ' && line2.charAt(8) == '{') {
                                String line3 = br.readLine();
                                if (line3 == null) return;
                                if (line3.charAt(6) == 'p' && line3.charAt(7) == '(') {
                                    if (line3.charAt(8) == c) {
                                        message += line3.charAt(8);
                                        if (line3.charAt(9) == ')' && line3.charAt(10) == ';') PrinterUtil.print(message);
                                    }
                                } else if (line3.charAt(6) == 'p' && line3.charAt(7) == 'l' && line3.charAt(8) == 'n' && line3.charAt(9) == '(') {
                                    if (line3.charAt(10) == c) {
                                        message += line3.charAt(10);
                                        if (line3.charAt(11) == ')' && line3.charAt(12) == ';') PrinterUtil.println(message);
                                    }
                                }
                            }
                        }
                    } else if (code.charAt(2) == uc && code.charAt(3) == c) {
                        classname += code.charAt(2) + code.charAt(3);
                        classlist.add(classname);
                    } else if (code.charAt(2) == uc && code.charAt(3) == c && code.charAt(4) == c) {
                        classname += code.charAt(2) + code.charAt(3) + code.charAt(5);
                        classlist.add(classname);
                    }
                }
            }
        }
    }
}
