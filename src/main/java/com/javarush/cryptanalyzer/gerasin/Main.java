package com.javarush.cryptanalyzer.gerasin;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Вы можете прочитать содержимое файла и зашифровать его");
        System.out.println("нажмите 1 чтобы прочитать или 2 чтобы зашифровать");
        int user = console.nextInt();
        if(user == 1){
        try {
            ReadingFile.app();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }else if(user == 2){
            try {
                Encrypt.encryptFile();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }




    }
}