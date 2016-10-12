/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removepingdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author mad_r
 */
public class RemovePingData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        File inputFile = new File("pingTime.Txt");
        File tempFile = new File("justPings.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = "Client";
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            //trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (!trimmedLine.startsWith(lineToRemove)) {
                // if current line not start with lineToRemove then write to file
                writer.write(currentLine +"\n");
            }
        }
        writer.close();
        reader.close();

        if (!inputFile.delete()) {
            JOptionPane.showMessageDialog(null, "Could not rename file");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            JOptionPane.showMessageDialog(null, "Could not rename file");
        }
        
        
        

    }
}
