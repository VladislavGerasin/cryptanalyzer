import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Read {
    Path input = Path.of("src\\main\\resources\\input.txt");


    public Path getInput() {
        return input;
    }

    public Path setInput(Path input) {
        this.input = input;
        return input;
    }


    public List<String> readFileAsCharArray(Path path) {
        try (FileReader fileReader = new FileReader(String.valueOf(input));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            List<String> buffer = new ArrayList<>();
            while (bufferedReader.ready()){
                String line = bufferedReader.readLine();
                buffer.add(line);
            }
            return buffer;

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return null;
    }
// добавить метод, который просто читает файл
}



