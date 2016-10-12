/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removepingdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mad_r
 */
public class OnlyPingInt {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("pingTime.Txt");
        File tempFile = new File("justPings.txt");

        Scanner scan = null;

        File f = new File("pingTime.txt");
        try {
            scan = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        int total = 0;
        boolean foundInts = false; //flag to see if there are any integers

        while (scan.hasNextLine()) { //Note change
            String currentLine = scan.nextLine();
            //split into words
            String words[] = currentLine.split(" ");

            //For each word in the line
            for (String str : words) {
                try {
                    int num = Integer.parseInt(str);
//                    total += num;
                    foundInts = true;
                    System.out.println("Found: " + num);
                    writer.write(num +"\n");
                } catch (NumberFormatException nfe) {
                }; //word is not an integer, do nothing
            }
        } //end while 

        if (!foundInts) {
            System.out.println("No numbers found.");
        }

        // close the scanner
        scan.close();
        writer.close();
        reader.close();
    }
}
