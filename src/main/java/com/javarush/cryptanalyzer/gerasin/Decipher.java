package com.javarush.cryptanalyzer.gerasin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Decipher{

    public static void decipher() {


        String inFileName = "X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\encrypt.txt";
        File inFile = new File(inFileName);


        String outFileName = "X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\output.txt";
        File outFile = new File(outFileName);

        // ключ
        int offset = 3;

        try {
            Scanner scanner = new Scanner(inFile, "UTF-8");

            // записываю расшифрованный текст в outFileName
            FileWriter writer = new FileWriter(outFile);

            // Считываю каждую строку и расшифровываем ее
            while (scanner.hasNextLine()) {
                String encryptedLine = scanner.nextLine();
                StringBuilder decryptedLine = new StringBuilder();

                for (int i = 0; i < encryptedLine.length(); i++) {
                    char c = encryptedLine.charAt(i);

                    // Декодирую только буквы русского алфавита
                    if (Character.isLetter(c) && ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я'))) {
                        char firstChar = Character.isLowerCase(c) ? 'а' : 'А';
                        c = (char) (((c - firstChar - offset + 32) % 32) + firstChar);
                    }
                    decryptedLine.append(c);
                }

                // Записываю расшифрованную строку в файл
                writer.write(decryptedLine + "\n");
            }
            scanner.close();
            writer.close();


        } catch (FileNotFoundException e) {
        } catch (IOException e) {

        }
    }
}