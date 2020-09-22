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
    void main() throws IOException {

        //int input = (int) (Math.random() * 4) * 2;
        int input=0;
        while (input==0) {input = (int) (Math.random() * 4) * 2;}

        System.out.println(input);
        for (int i = 0; i < letters.length; i++) {

            if (i + input > letters.length-1) {


                kodeList.put(letters[i],letters[(i + input) - letters.length]);

            } else kodeList.put(letters[i],letters[i + input]);

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
                String copyword ="";

                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    String b = String.valueOf(c);
                    b= b.toLowerCase();

                    copyword = copyword + kodeList.getOrDefault(b, b);
                }
                File file2 = new File("src/com/company/copy.txt");
                FileWriter fr = new FileWriter(file2, true);
                BufferedWriter br = new BufferedWriter(fr);
                br.write(copyword);
                br.write(" ");
                if (test == null) { test = copyword;}
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


}