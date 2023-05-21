package com.javarush.cryptanalyzer.gerasin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFile {
        public static void app() throws Exception {
            InputStream inputStream = ReadingFile.class.getClassLoader().getResourceAsStream("input.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            inputStream.close();
        }
    }

