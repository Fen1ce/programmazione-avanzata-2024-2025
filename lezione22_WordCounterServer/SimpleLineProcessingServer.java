import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleLineProcessingServer {
    private final int port;
    private final String quitCommand;
    private final PrintStream ps;

    //Constructor
    public SimpleLineProcessingServer(int port, String quitCommand, OutputStream loggingOs) {
        this.port = port;
        this.quitCommand = quitCommand;
        ps = new PrintStream(loggingOs);
    }

    //Methods
    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            handleClient(socket);
        }
    }
    protected void handleClient(Socket socket) throws IOException {
        ps.printf("[%1$tY-%1$tm-%1$td %1$tT] Connection from %2$s.%n", System.currentTimeMillis(), socket.getInetAddress());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        int requestsCounter = 0;
        while (true) {
            String line = br.readLine();
            if (line.equals(quitCommand)) {
                break;
            }
            bw.write(process(line) + System.lineSeparator());
            bw.flush();
            requestsCounter = requestsCounter + 1;
        }
        socket.close();
        ps.printf("[%1$tY-%1$tm-%1$td %1$tT] Disconnection of %2$s after %3$d requests.%n", System.currentTimeMillis(), socket.getInetAddress(), requestsCounter);
    }
    protected String process(String input) {
        return input;
    }
}
