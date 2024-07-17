import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BreakCoder {
    CryptoAlphabet cryptoAlphabet = new CryptoAlphabet();

    public void brutForceDecryptAndWriteToFile(List<String> encryptedText, Path outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            String bestDecryptedText = "";
            int bestShift = 0;
            for (int shift = 1; shift < 32; shift++) {
                String decryptedText = decrypt(encryptedText, shift);
                if (checkForPopularWords(decryptedText)) {
                    bestShift = shift;
                    bestDecryptedText = decryptedText;
                }
            }
            writer.write("Ключ " + bestShift + ": " + bestDecryptedText);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + e.getMessage());
        }
    }

    private boolean checkForPopularWords(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            for (PopularWords popularWord : PopularWords.values()) {
                if (word.equalsIgnoreCase(popularWord.name())) {
                    return true;
                }
            }
        }
        return false;
    }

    private String decrypt(List<String> encryptedText, int shift) {
        if (shift >= cryptoAlphabet.ALPHABET.length()) {

            return "Неверный ключ";
        }

        StringBuilder decryptedText = new StringBuilder();
        for (String line : encryptedText) {
            for (char symbol : line.toCharArray()) {
                if (cryptoAlphabet.ALPHABET.contains(String.valueOf(symbol))) {
                    int charIndex = cryptoAlphabet.ALPHABET.indexOf(symbol);
                    int newIndex = (charIndex - shift + cryptoAlphabet.ALPHABET.length()) % cryptoAlphabet.ALPHABET.length();
                    decryptedText.append(cryptoAlphabet.ALPHABET.charAt(newIndex));
                } else {
                    decryptedText.append(symbol);
                }
            }
            decryptedText.append("\n");
        }
        return decryptedText.toString();
    }
}