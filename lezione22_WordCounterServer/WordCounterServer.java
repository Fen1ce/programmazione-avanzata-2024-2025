import java.io.*;
import java.net.Socket;

public class WordCounterServer extends SimpleLineProcessingServer {
    //Constructor
    public WordCounterServer(OutputStream loggingOs) {
        super(10000, "bye", loggingOs);
    }

    //Methods
    @Override
    protected void handleClient(Socket socket) throws IOException {
        getLoggingOs().printf(logString(true, socket, 0));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        int requestsCounter = 0;
        while (true) {
            String line = br.readLine();
            if (line.equals(getQuitCommand())) {
                break;
            }
            bw.write("Word counter: " + process(line) + System.lineSeparator());
            bw.flush();
            requestsCounter = requestsCounter + 1;
        }
        socket.close();
        getLoggingOs().printf(logString(false, socket, requestsCounter));
    }
    @Override
    protected String process(String input) {
        String[] processedInput = input.split(" ");
        return String.valueOf(processedInput.length);
    }
    protected String logString(boolean flag, Socket socket, int requestsCounter) {
        if (flag) {
            return String.format("[%1$tY-%1$tm-%1$td %1$tT] Connection from %2$s.%n", System.currentTimeMillis(), socket.getInetAddress());
        } else {
            return String.format("[%1$tY-%1$tm-%1$td %1$tT] Disconnection of %2$s after %3$d requests.%n", System.currentTimeMillis(), socket.getInetAddress(), requestsCounter);
        }
    }
}
