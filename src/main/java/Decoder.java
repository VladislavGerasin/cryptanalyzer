import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Decoder {
    Read read = new Read();
    Encoder encoder = new Encoder();
    int key = encoder.getKey();
    String encryptedText = decodingCaesarCipher(read.readFileAsCharArray(read.getInput()), key);

    public String decodingCaesarCipher(List<String> buffer, int key) {
        StringBuilder cipherTextBuilder = new StringBuilder();
        for (String word : buffer) {
            for (char ch : word.toCharArray()) {
                if (CryptoAlphabet.ALPHABET.indexOf(ch) != -1) {
                    int index = (CryptoAlphabet.ALPHABET.indexOf(ch) + key) % CryptoAlphabet.ALPHABET.length();
                    cipherTextBuilder.append(CryptoAlphabet.ALPHABET.charAt(index));
                } else {
                    cipherTextBuilder.append(ch);
                }
            }
        }
        return cipherTextBuilder.toString();
    }

    public static void writeToFileEncrypt(String data) {
        try (FileWriter fileWriter = new FileWriter("X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\encrypt.txt")) {
            fileWriter.write(data);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }


}
