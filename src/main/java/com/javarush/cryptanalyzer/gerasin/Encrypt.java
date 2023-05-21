package com.javarush.cryptanalyzer.gerasin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Encrypt {

    public static String encrypt(String plainText, int shift) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i); // Получаем очередной символ
            // Если символ является буквой русского алфавита, то шифруем его
            if (Character.isLetter(ch) && Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.CYRILLIC) {
                char shiftedCh = (char) ('а' + (ch - 'а' + shift) % 32);
                cipherText.append(shiftedCh);
            } else {
                cipherText.append(ch);
            }
        }
        return cipherText.toString();
    }

    public static void encryptFile () throws Exception {
        // путь к файлу
//        ReadingFile fileInput = (ReadingFile) Path.of("input.txt");
        String fileName = "X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\input.txt";
        File inputFile = new File(fileName);
        File outputFile = new File("X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\encrypt.txt");


        FileInputStream inputStream = new FileInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(inputStreamReader);


        FileWriter writer = new FileWriter(outputFile, StandardCharsets.UTF_8);

        String line;
        while ((line = reader.readLine()) != null) {
            String encryptedLine = encrypt(line, 3); // Здесь 3 - это ключ шифрования
            writer.write(encryptedLine + "\n");
        }


        reader.close();
        writer.close();
        inputStream.close();
    }
}
