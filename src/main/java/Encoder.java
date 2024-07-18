import java.io.*;
import java.util.List;

public class Encoder {
    Read read = new Read();
    private int key = 10;
    String encryptedText = encryptCaesarCipher(read.readFileAsCharArray(read.getInput()), key);

    public int getKey() {
        return key;
    }

    public int setKey(int key) {
        this.key = key;
        return key;
    }

    public String encryptCaesarCipher(List<String> buffer, int key) {
    StringBuilder cipherTextBuilder = new StringBuilder();
    for (String word : buffer) {
        for (char ch : word.toCharArray()) {
            if (CryptoAlphabet.ALPHABET.indexOf(ch) != -1) {
                int index = (CryptoAlphabet.ALPHABET.indexOf(ch) - key) % CryptoAlphabet.ALPHABET.length();
                if (index < 0) {
                    index += CryptoAlphabet.ALPHABET.length(); // Обработка отрицательных значений index
                }
                cipherTextBuilder.append(CryptoAlphabet.ALPHABET.charAt(index));
            } else {
                cipherTextBuilder.append(ch);
            }
        }
    }
    return cipherTextBuilder.toString();
}

    public void writeToFile(String data) {
        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            fileWriter.write(data);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }


}








