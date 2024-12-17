import java.io.File;

public class Ccwc {
    public static void main(String[] args) {
        System.out.println("Staring ccwc...");

        String commandLineFlag = args[0];
        String filePath = args[1];

        System.out.println("Command line flag: " + commandLineFlag);
        System.out.println("File path: " + filePath);

        File file = new File(filePath);

        String fileName = file.getName();
        long fineSize = file.length();

        System.out.println(fineSize + " " + fileName);
    }
}
