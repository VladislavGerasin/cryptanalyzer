package com.javarush.cryptanalyzer.gerasin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFile {
    public static void readingFiles() {
        String src = "input.txt";

        try(FileReader in = new FileReader(src);
            BufferedReader reader = new BufferedReader(in))
        {
            while (reader.ready())
            {
                String line = reader.readLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
