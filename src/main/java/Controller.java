import java.nio.file.Path;
import java.util.Scanner;


public class Controller {
    Menu menu = new Menu();
    Encoder encoder = new Encoder();
    Decoder decoder = new Decoder();
    BreakCoder breakCoder = new BreakCoder();
    Read read = new Read();

    public void launch(){
        System.out.println(menu.INPUT);
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        switch (message) {
            case "1":
                LaunchEncodeFile();
                break;
            case "2":
                LaunchDecoderFile();

        }

    }

        public void LaunchEncodeFile() {

            Scanner scanner = new Scanner(System.in);
            String message;

            System.out.println(menu.INPUT_CODE_ENCRYPT);
            message = scanner.nextLine();

            switch (message) {
                case "1":
                    encodeFileDefault();
                    break;
                case "2":
                    encodeFileCustom();

            }
        }

    public void encodeFileDefault() {

        Scanner scanner = new Scanner(System.in);
        String message;

        System.out.println(menu.ENTER_TEXT);
        message = scanner.nextLine();

        switch (message) {
            case "1":
                String encryptedText = encoder.encryptCaesarCipher(read.readFileAsCharArray(read.getInput()), encoder.getKey());
                encoder.writeToFile(encryptedText);
                break;
            case "2":
                System.out.println(menu.ENTER_KEY);
                int key = scanner.nextInt();
                String encryptedTextNewKey = encoder.encryptCaesarCipher(read.readFileAsCharArray(read.getInput()), key);
                encoder.writeToFile(encryptedTextNewKey);

        }
    }



    public void encodeFileCustom() {

        Scanner scanner = new Scanner(System.in);
        String message;

        System.out.println(menu.ENTER_TEXT);
        message = scanner.nextLine();

        switch (message) {
            case "1":
                System.out.println(menu.ENTER_WAY);
                String wayNew = scanner.nextLine();
                String encryptedText = encoder.encryptCaesarCipher(read.readFileAsCharArray(read.setInput(Path.of(wayNew))), encoder.getKey());
                encoder.writeToFile(encryptedText);
                break;
            case "2":
                System.out.println(menu.ENTER_WAY);
                String way = scanner.nextLine();
                System.out.println(menu.ENTER_KEY);
                int key = scanner.nextInt();
                String encryptedTextNewKey = encoder.encryptCaesarCipher(read.readFileAsCharArray(read.setInput(Path.of(way))), key);
                encoder.writeToFile(encryptedTextNewKey);

        }
    }



    public void LaunchDecoderFile() {

        Scanner scanner = new Scanner(System.in);
        String message;

        System.out.println(menu.INPUT_CODE_DECRYPT);
        message = scanner.nextLine();

        switch (message) {
            case "1":
                decoderFileDefault();
                break;
            case "2":
                decoderFileCustom();

        }
    }

    public void decoderFileDefault() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(menu.ENTER_TEXT_DECRYPT);
        String message = scanner.nextLine();
        switch (message){
            case "1":
                String decoderText = decoder.decodingCaesarCipher(read.readFileAsCharArray(read.setInput(Path.of("X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\output.txt"))), encoder.getKey());
                decoder.writeToFileEncrypt(decoderText);
                break;
            case "2":
                System.out.println(menu.ENTER_KEY);
                int key = scanner.nextInt();
                String decryptedTextNewKey = decoder.decodingCaesarCipher(read.readFileAsCharArray(read.setInput(Path.of("X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\output.txt"))), encoder.setKey(key));
                Decoder.writeToFileEncrypt(decryptedTextNewKey);
        }
    }

    public void decoderFileCustom() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(menu.ENTER_TEXT_DECRYPT);
        String message = scanner.nextLine();
        switch (message){
            case "1":
                System.out.println(menu.ENTER_WAY );
                String way = scanner.nextLine();
                String decoderText = decoder.decodingCaesarCipher(read.readFileAsCharArray(read.setInput(Path.of(way))), encoder.getKey());
                decoder.writeToFileEncrypt(decoderText);
                break;
            case "2":
                System.out.println(menu.ENTER_WAY );
                String wayNew = scanner.nextLine();
                System.out.println(menu.ENTER_KEY);
                int key = scanner.nextInt();
                String decryptedTextNewKey = decoder.decodingCaesarCipher(read.readFileAsCharArray(read.setInput(Path.of(wayNew))), encoder.setKey(key));
                Decoder.writeToFileEncrypt(decryptedTextNewKey);
        }
    }



}



