import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class BreakCoder {
    CryptoAlphabet cryptoAlphabet = new CryptoAlphabet();
    private final int MAX_KEY = cryptoAlphabet.ALPHABET.length();

    public void decryptAndWriteToFile(List<String> encryptedText, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String line : encryptedText) {
                String decryptedLine = decryptWithAutoKey(line);
                writer.write(decryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String decryptWithAutoKey(String encrypted) {
        int bestKey = findBestKey(encrypted);
        return decrypt(encrypted, bestKey);
    }

    private int findBestKey(String encrypted) {
        int maxWordsMatched = 0;
        int bestKey = 0;

        for (int key = 0; key < MAX_KEY; key++) {
            String decrypted = decrypt(encrypted, key);
            int wordsMatched = countMatchingWords(decrypted);
            if (wordsMatched > maxWordsMatched) {
                maxWordsMatched = wordsMatched;
                bestKey = key;
            }
        }

        return bestKey;
    }


    private String decrypt(String encrypted, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (char ch : encrypted.toCharArray()) {
            int index = (cryptoAlphabet.ALPHABET.indexOf(ch) - key + cryptoAlphabet.ALPHABET.length()) % cryptoAlphabet.ALPHABET.length();
            decryptedText.append(cryptoAlphabet.ALPHABET.charAt(index));
        }
        return decryptedText.toString();
    }

    private int countMatchingWords(String text) {
        String[] words = text.split("\\s+");
        int matchedWords = 0;

        for (String word : words) {
            if (isInDictionary(word)) {
                matchedWords++;
            }
        }

        return matchedWords;
    }


    private boolean isInDictionary(String word) {
        try {
            PopularWords popularWord = PopularWords.valueOf(word.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }



    }

}