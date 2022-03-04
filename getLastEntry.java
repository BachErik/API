package de.bacherik.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class getLastEntry {
    public String getLastEntry(String configDestination){
        String file = "test.txt";
        BufferedReader breader = null;
        try {
            breader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        String line = null;
        String merke = null;

        try {
            while ((line = breader.readLine()) != null) {
                merke = line;
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            breader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String entry = merke.toString();
        return entry;
    }
}
