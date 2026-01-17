import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileArray {
    final String filePathName;

    //Costruttori
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

    //Metodi richiesti
    public void print() {
        int[] array = this.read();
    }
    public void incrementAll() {}

    //Metodi aggiuntivi
    private void write(int[] array) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePathName));
        for (int j : array) {
            dos.writeInt(j);
        }
        dos.close();
    }
    private int[] read() {
    }
}