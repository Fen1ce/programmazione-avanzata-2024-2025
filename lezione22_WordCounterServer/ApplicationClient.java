import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ApplicationClient {
    public static void main(String[] args) throws IOException {
        InetAddress serverInetAddress;
        if (args.length > 1) {
            serverInetAddress = InetAddress.getByName(args[0]);
        } else {
            serverInetAddress = InetAddress.getLocalHost();
        }
        Socket socket = new Socket(serverInetAddress, 10000);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        while (true) {
            Scanner sc = new Scanner(System.in);
            String sent = sc.nextLine();
            if (sent.equals("bye")) {
                bw.write("bye" + System.lineSeparator());
                bw.flush();
                break;
            }
            bw.write(sent + System.lineSeparator());
            bw.flush();
            String received = br.readLine();
            System.out.printf("Sent: %s%nReceived: %s%n", sent, received);
        }
        socket.close();
    }
}
