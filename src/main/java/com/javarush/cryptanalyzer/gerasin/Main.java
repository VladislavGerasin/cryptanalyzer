package com.javarush.cryptanalyzer.gerasin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;
import com.javarush.cryptanalyzer.gerasin.Interface;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println(Interface.HELLO);
        System.out.println(Interface.SELECT_BUTTON);
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
        }else if(user == 3){
            Decipher.decipher();
        }else if(user == 4){
            BruteForce.bruteForce();
        }





    }
}