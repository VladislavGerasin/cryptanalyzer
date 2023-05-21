package com.javarush.cryptanalyzer.gerasin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BruteForce {

    public static void bruteForce() {
        String inputFilePath = "X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\encrypt.txt";

        for (int key = 0; key < 32; key++) {
            String decryptedText = decrypt(getInputText(inputFilePath), key);
            if (decryptedText.matches("[а-яА-Я]+")) {
// Создаем новый файл
                String outputFilePath = String.format("X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\output.txt", key);
                saveToFile(decryptedText, outputFilePath);

            }
        }
    }

    private static String getInputText(String inputFilePath) {
        File file = new File(inputFilePath);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static String decrypt(String cipherText, int key) {
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = (char) ('А' + (ch - 'А' - key + 32) % 32);
            } else if (Character.isLowerCase(ch)) {
                ch = (char) ('а' + (ch - 'а' - key + 32) % 32);
            }
            plainText.append(ch);
        }
        return plainText.toString();
    }


// записываем в файл
    private static void saveToFile(String text, String outputFilePath) {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
