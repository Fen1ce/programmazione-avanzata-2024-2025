import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPFileArray  extends FileArray {
    //Constructors
    public GZIPFileArray(String filePathName) {
        super(filePathName);
    }
    public GZIPFileArray(String filePathName, int numberOfInt) throws IOException {
        super(filePathName, numberOfInt);
    }

    //Overrided Methods
    void write(int[] array) throws IOException {
        DataOutputStream dos = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(filePathName)));
        for (int j : array) {
            dos.writeInt(j);
        }
        dos.close();
    }
    int[] read() throws IOException {
        DataInputStream dis = new DataInputStream(new GZIPInputStream(new FileInputStream(filePathName)));
        int[] array = this.fileToArray(dis);
        dis.close();
        return array;
    }
    int[] fileToArray(DataInputStream dis) throws IOException {
        /*
            In GZIPFileArray è necessario ridefinire fileToArray() perché il metodo della superclasse assume una
                corrispondenza diretta tra dimensione del file e numero di int, ipotesi che non vale più in presenza
                di compressione.
            Il file .gz ha dimensione compressa, mentre lo stream restituisce dati decompressi.
            Di conseguenza il numero di elementi va determinato leggendo fino a fine stream o memorizzando esplicitamente
            la dimensione.
         */
        //Solution A
        List<Integer> list = new ArrayList<>();

        try {
            while (true) {
                list.add(dis.readInt());
            }
        } catch (EOFException e) {
            // fine dello stream
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
        /*Solution B
            Memorizzare il numero di int all’inizio del file (prima dei dati) per sapere quanti readInt() fare.
            Richiede che anche write() sia modificato.
         */
    }
}
