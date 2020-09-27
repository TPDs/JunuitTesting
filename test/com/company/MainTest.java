package com.company;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    HashMap<String, String> kodeList = new HashMap<>();

    @Test
    void main() {

        //int input = (int) (Math.random() * 4) * 2;
        int input = 0;
        while (input == 0) {
            input = (int) (Math.random() * 4) * 2;
        }

        System.out.println(input);
        for (int i = 0; i < letters.length; i++) {

            if (i + input > letters.length - 1) {


                kodeList.put(letters[i], letters[(i + input) - letters.length]);

            } else kodeList.put(letters[i], letters[i + input]);

        }

    }

    @Test
    void read() throws IOException {
        main();
        File copy = new File("src/com/company/copy.txt");
        copy.delete();
        copy.createNewFile();
        String test = null;
        try {
            File file = new File("src/com/company/test.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String word = sc.next();
                String copyword = "";

                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    String b = String.valueOf(c);
                    b = b.toLowerCase();

                    copyword = copyword + kodeList.getOrDefault(b, b);
                }
                File file2 = new File("src/com/company/copy.txt");
                FileWriter fr = new FileWriter(file2, true);
                BufferedWriter br = new BufferedWriter(fr);
                br.write(copyword);
                br.write(" ");
                if (test == null) {
                    test = copyword;
                }
                br.close();
                fr.close();

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(test);

        char code = test.charAt(0);
        System.out.println(code);

    }

    @Test
    void unread() throws IOException {

        try {
            File file = new File("src/com/company/test.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String word = sc.next();
                String copyword = "";

                if (word.length() == 1) {

                    int pValue = 0;
                    int iValue = 0;
                    int aValue = 0;
                    for (int i = 0; i < letters.length; i++) {
                        if (word.equals(letters[i])) {
                            pValue = i;
                            System.out.println(pValue);
                            for (int j = 0; j < letters.length; j++) {

                                if (letters[pValue + j - letters.length].equals(letters[0])) {
                                    aValue = pValue + j;
                                } else if (letters[pValue + j- letters.length].equals(letters[9]) || letters[pValue + j].equals(letters[9])) {
                                    if (pValue+j > letters.length) {
                                        iValue = pValue+j - letters.length;
                                    }
                                    else iValue = j;

                                }

                            }
                        }

                    }


                }

                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    String b = String.valueOf(c);
                    b = b.toLowerCase();

                    copyword = copyword + kodeList.getOrDefault(b, b);
                }


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}