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
    HashMap<String, String> dekodeList = new HashMap<>();

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
            File file = new File("src/com/company/whale2.txt");
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
    void unread() {
        int pValue = 0;
        int iValue = 0;
        int aValue = 0;
        try {
            File file = new File("src/com/company/copy.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String word = sc.next();


                if (word.length() == 1) {


                    for (int i = 0; i < letters.length; i++) {
                        if (word.equals(letters[i])) {
                            pValue = i;
                            System.out.println(pValue);
                        }
                    }
                    aValue =  letters.length - (letters.length + pValue) ;
                    System.out.println("A er  " + aValue);

                   if (pValue >8) {
                    iValue = 8-pValue;
                    System.out.println("I er  " + iValue);
                   break;
                   }
                   else
                    iValue = (8-pValue ) -letters.length;
                    System.out.println("I2 er  " + iValue);
                    break;

                }



            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int input;
        System.out.println(letters[2] +letters[15] +letters[5]);

        String testAndForA = letters[aValue+2] +letters[aValue+15] +letters[aValue+5];
        String testAndForI = letters[iValue+2+letters.length] +letters[iValue+15+letters.length] +letters[iValue+5+letters.length];


        if (testAndForA.equals("and")) {
            input = aValue;
        }
        else input=iValue;

        for( int i=0; i < letters.length;i++) {

            if (i < ((input) * (-1))) {
                dekodeList.put(letters[i],letters[letters.length - ((input) * (-1))+i]);

            }
            else {
        dekodeList.put(letters[i],letters[(input)+i]);

             }

        }

    }

    @Test
    void deRead() throws IOException {
        unread();
        File copy = new File("src/com/company/detest.txt");
        copy.delete();
        copy.createNewFile();
        String test = null;
        try {
            File file = new File("src/com/company/copy.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String word = sc.next();
                String copyword = "";

                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    String b = String.valueOf(c);
                    b = b.toLowerCase();

                    copyword = copyword + dekodeList.getOrDefault(b, b);
                }
                File file2 = new File("src/com/company/detest.txt");
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

    }



}