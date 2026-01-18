import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application  {
    public static void main(String[] args) throws IOException {
        //1) Minimal Control over the Arguments
        if (args.length < 1) {
            System.out.println("Error: Missing command line argument!");
            System.exit(1);
        }

        String filePathName = args[0];
        Path filePath = Paths.get(filePathName); //Pseudo-Constructor Method: converts a path string to a Path
        FileArray fileArray;

        //2) FileArray Creation or Loading
        if (Files.exists(filePath)) {
            if (filePathName.endsWith(".gz")) {
                fileArray = new GZIPFileArray(filePathName);
            } else {
                fileArray = new FileArray(filePathName);
            }
        }  else {
            int n = 10; //number of random integers
            if (filePathName.endsWith(".gz")) {
                fileArray = new GZIPFileArray(filePathName, n);
            } else {
                fileArray = new FileArray(filePathName, n);
            }
        }

        //3) Command Interpretation
        for (int i = 1; i < args.length; i++) {
            //Control over the Length of Commands
            if (args[i].length() != 1) {
                System.out.println("Invalid command: " + args[i]);
                continue;
            }
            char command = args[i].charAt(0);
            switch (command) {
                case 'i':
                    fileArray.incrementAll();
                    break;
                case 'p':
                    fileArray.print();
                    break;
                default:
                    System.out.println("Unknown command: " + args[i]);
            }
        }
    }
}