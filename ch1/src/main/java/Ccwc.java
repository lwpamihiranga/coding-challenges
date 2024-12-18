import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

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
            long fineSize = file.length();
            System.out.println(fineSize + " " + fileName);
        } else if (commandLineFlag.equals("-l")) {
            LineNumberReader reader = new LineNumberReader(new FileReader(file));
            while (reader.readLine() != null) {
            }
            int lineCount = reader.getLineNumber();
            System.out.println(lineCount + " " + fileName);
            reader.close();
        }
    }
}