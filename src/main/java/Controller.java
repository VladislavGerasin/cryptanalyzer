import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
                launchEncodeFile();
                break;
            case "2":
                launchDecoderFile();
                break;
            case "3":
                doBreakCoder();
                break;

        }

    }

        public void launchEncodeFile() {

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
                int key;

                do {
                    System.out.println(menu.ENTER_KEY);
                    key = scanner.nextInt();

                    if (key <= 0) {
                        System.out.println(menu.NEGATIVE_ENTER_KEY);
                    }
                } while (key <= 0);

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
                int key;
                do{
                    System.out.println(menu.ENTER_KEY);
                    key = scanner.nextInt();
                    if (key <= 0) {
                        System.out.println(menu.NEGATIVE_ENTER_KEY);
                }
                }while (key <= 0);
                String encryptedTextNewKey = encoder.encryptCaesarCipher(read.readFileAsCharArray(read.setInput(Path.of(way))), key);
                encoder.writeToFile(encryptedTextNewKey);

        }
    }



    public void launchDecoderFile() {

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
                int key;
                do{
                    System.out.println(menu.ENTER_KEY);
                    key = scanner.nextInt();
                    if (key <= 0) {
                        System.out.println(menu.NEGATIVE_ENTER_KEY);
                    }
                }while (key <= 0);
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
                int key;
                do{
                    System.out.println(menu.ENTER_KEY);
                    key = scanner.nextInt();
                    if (key <= 0) {
                        System.out.println(menu.NEGATIVE_ENTER_KEY);
                    }

                }while (key <= 0);
                String decryptedTextNewKey = decoder.decodingCaesarCipher(read.readFileAsCharArray(read.setInput(Path.of(wayNew))), encoder.setKey(key));
                Decoder.writeToFileEncrypt(decryptedTextNewKey);
        }
    }

    public void doBreakCoder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(menu.INPUT_CODE_DECRYPT);
        String message = scanner.nextLine();
        switch (message){
            case "1":
                Path filePath = Path.of("X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\output.txt");
                List<String> encryptedText = read.readFileAsCharArray(read.setInput(filePath));
                String outputFileName = "X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\breaktext.txt";
                breakCoder.brutForceDecryptAndWriteToFile(encryptedText, Path.of(outputFileName));
                break;
            case "2":
                System.out.println("Введите путь к файлу");
                String way = scanner.nextLine();
                Path file = Path.of(way);
                List<String> encryptedTextCustom = read.readFileAsCharArray(read.setInput(file));
                String outputFile = "X:\\JDK\\projeck\\cryptanalyzer\\src\\main\\resources\\breaktext.txt";
                breakCoder.brutForceDecryptAndWriteToFile(encryptedTextCustom, Path.of(outputFile));
        }



    }



}



