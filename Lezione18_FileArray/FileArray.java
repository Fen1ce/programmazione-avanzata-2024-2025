import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

public class FileArray {
    final String filePathName;

    //Constructors
    public FileArray(String filePathName) {
        this.filePathName = filePathName;
    }
    public FileArray(String filePathName, int n) throws IOException {
        this.filePathName = filePathName;
        int[] array = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(1025);
        }
        this.write(array);
    }

    //Required Methods
    public void print() throws IOException {
        int[] array = this.read();
        int width;
        if (Arrays.stream(array).max().getAsInt() < 10) {
            /*
            	Array.stream(int[] array) returns a sequential IntStream with the specified array as its source.
            	max() of the IntStream interface returns an OptionalInt describing the maximum element of this stream,
            	    or an empty optional if this stream is empty.
            	getAsInt() of the OptionalInt class returns the value if a value is present in the OptionalInt,
            	    otherwise throws NoSuchElementException.
             */
            width = 2;
        } else if (Arrays.stream(array).max().getAsInt() < 100) {
            width = 3;
        } else {
            width = 4;
        }
        for (int i = 0; i < array.length; i += 5) {
            System.out.printf("[%02d-%02d]", i, Math.min(i + 4, array.length - 1));
            for (int j = i; j < Math.min(i + 5, array.length); j++) {
                System.out.printf("%" + width + "d", array[j]);
            }
            System.out.println();
        }
    }
    public void incrementAll() throws IOException {
        int[] array = this.read();
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i] + 1;
        }
        /*
            It was used a temporary array to separate the read state from the written state, avoid side effects,
                make the operation safer in case of errors, and promote a clearer and more extensible design.
            The memory cost is negligible compared to file I/O operations.
         */
        this.write(temp);
    }

    //Inner Methods
    private void write(int[] array) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePathName));
        for (int j : array) {
            dos.writeInt(j);
        }
        dos.close();
    }
    private int[] read() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePathName));
        int[] array = this.fileToArray(dis);
        dis.close();
        return array;
    }
    private int[] fileToArray(DataInputStream dis) throws IOException {
        File file = new File(filePathName);
        Path filePath = file.toPath();
        int numberOfInt = Math.toIntExact(Files.size(filePath)) / 4;
        /*
            It is divided by 4 because each int in Java occupies 4 bytes and Files.size() returns the size of a file in bytes.
            Math.toIntExact(long value) returns the value of the long argument;
                throwing an exception if the value overflows an int.
         */
        int[] array = new int[numberOfInt];
        for (int i = 0; i < numberOfInt; i++) {
            array[i] = dis.readInt();
        }
        return array;
    }
}