import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;

public class Ccwc {
    public static void main(String[] args) throws IOException {
        System.out.println("Staring ccwc...");

        String commandLineFlag = args[0];
        String filePath = args[1];

        System.out.println("Command line flag: " + commandLineFlag);
        System.out.println("File path: " + filePath);

        File file = new File(filePath);

        String fileName = file.getName();

        if (commandLineFlag.equals("-c")) {
            long fileSize = file.length();
            System.out.println(fileSize + " " + fileName);
        } else if (commandLineFlag.equals("-l")) {
            LineNumberReader reader = new LineNumberReader(new FileReader(file));
            while (reader.readLine() != null) {
            }
            int lineCount = reader.getLineNumber();
            System.out.println(lineCount + " " + fileName);
            reader.close();
        } else if (commandLineFlag.equals("-w")) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int wordCount = 0;
            String content;
            while ((content = reader.readLine()) != null) {
                content = content.trim();
                if (content.isBlank()) {
                    continue;
                }
                String[] words = content.split("\\s+");
                wordCount += words.length;
            }
            System.out.println(wordCount + " " + fileName);
            reader.close();
        } else if (commandLineFlag.equals("-m")) {
            InputStream inputStream = Files.newInputStream(file.toPath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            long charCount = 0;
            while ((reader.read()) != -1) {
                charCount++;
            }
            System.out.println(charCount + " " + fileName);
            reader.close();
        }
    }
}
