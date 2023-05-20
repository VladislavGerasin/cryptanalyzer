package com.javarush.cryptanalyzer.gerasin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFile {
        public static void app() throws Exception {
            // Получаем InputStream для файла из папки resources
            InputStream inputStream = ReadingFile.class.getClassLoader().getResourceAsStream("input.txt");

            // Создаем BufferedReader для чтения содержимого файла
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Читаем содержимое файла построчно
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Закрываем потоки
            reader.close();
            inputStream.close();
        }
    }

