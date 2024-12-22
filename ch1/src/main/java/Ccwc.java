import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Ccwc {
    public static void main(String[] args) throws IOException {
        System.out.println("Staring ccwc...");

        String commandLineFlag = "";
        String filePath = "";
        boolean isPiped = false;
        BufferedReader reader = null;

        if (System.console() != null) {
            isPiped = false;
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
            isPiped = true;
        }
        if (args.length > 1) {
            commandLineFlag = args[0];
            filePath = args[1];
        } else if (args.length == 1) {
            if (args[0].equals("-c")) {
                commandLineFlag = args[0];
                isPiped = true;
                reader = new BufferedReader(new InputStreamReader(System.in));
            } else if (args[0].equals("-l")) {
                commandLineFlag = args[0];
                isPiped = true;
                reader = new BufferedReader(new InputStreamReader(System.in));
            } else if (args[0].equals("-w")) {
                commandLineFlag = args[0];
                isPiped = true;
                reader = new BufferedReader(new InputStreamReader(System.in));
            } else if (args[0].equals("-m")) {
                commandLineFlag = args[0];
                isPiped = true;
                reader = new BufferedReader(new InputStreamReader(System.in));
            } else {
                filePath = args[0];
            }
        }

        System.out.println("Command line flag: " + commandLineFlag);
        System.out.println("File path: " + filePath);

        File file = new File(filePath);

        String fileName = file.getName();
        if (commandLineFlag.equals("-c")) {
            long fileSize;
            if (isPiped) {
                fileSize = getByteCount(reader);
            } else {
                fileSize = getByteCount(file);
            }
            System.out.println(fileSize + " " + fileName);
        } else if (commandLineFlag.equals("-l")) {
            int lineCount;
            if (isPiped) {
                lineCount = getLineCount(new InputStreamReader(System.in));
            } else {
                lineCount = getLineCount(file);
            }
            System.out.println(lineCount + " " + fileName);
        } else if (commandLineFlag.equals("-w")) {
            int wordCount;
            if (isPiped) {
                wordCount = getWordCount(reader);
            } else {
                wordCount = getWordCount(file);
            }
            System.out.println(wordCount + " " + fileName);
        } else if (commandLineFlag.equals("-m")) {
            long charCount;
            if (isPiped) {
                charCount = getCharCount(reader);
            } else {
                charCount = getCharCount(file);
            }
            System.out.println(charCount + " " + fileName);
        } else {
            int lineCount;
            int wordCount;
            long charCount;
            if (isPiped) {
                long[] result = getAllResult(reader);
                lineCount = (int) result[0];
                wordCount = (int) result[1];
                charCount = result[2];
            } else {
                lineCount = getLineCount(file);
                wordCount = getWordCount(file);
                charCount = getCharCount(file);
            }
            System.out.println(lineCount + " " + wordCount + " " + charCount + " " + fileName);
        }
    }

    private static long getByteCount(File file) {
        return file.length();
    }

    private static long getByteCount(BufferedReader reader) throws IOException {
        long count = 0;
        char[] buffer = new char[8192];
        int charsRead;
        while ((charsRead = reader.read(buffer)) != -1) {
            String chunk = new String(buffer, 0, charsRead);
            count += chunk.getBytes(StandardCharsets.UTF_8).length;
        }
        return count;
    }

    private static int getLineCount(File file) throws IOException {
        LineNumberReader reader = new LineNumberReader(new FileReader(file));
        while (reader.readLine() != null) {
        }
        int lineCount = reader.getLineNumber();
        reader.close();
        return lineCount;
    }

    private static int getLineCount(InputStreamReader inputStreamReader) throws IOException {
        LineNumberReader reader = new LineNumberReader(inputStreamReader);
        while (reader.readLine() != null) {
        }
        int lineCount = reader.getLineNumber();
        reader.close();
        return lineCount;
    }

    private static int getWordCount(File file) throws IOException {
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
        reader.close();
        return wordCount;
    }

    private static int getWordCount(BufferedReader reader) throws IOException {
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
        reader.close();
        return wordCount;
    }

    private static long getCharCount(File file) throws IOException {
        InputStream inputStream = Files.newInputStream(file.toPath());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        long charCount = 0;
        while ((reader.read()) != -1) {
            charCount++;
        }
        reader.close();
        return charCount;
    }

    private static long getCharCount(BufferedReader reader) throws IOException {
        long charCount = 0;
        while ((reader.read()) != -1) {
            charCount++;
        }
        reader.close();
        return charCount;
    }

    private static long[] getAllResult(BufferedReader reader) {
        long[] counts = {0, 0, 0};
        return counts;
    }
}
