import java.io.IOException;

public class ApplicationServer {
    public static void main(String[] args) throws IOException {
        SimpleLineProcessingServer serverSocket = new WordCounterServer(System.out);
        serverSocket.run();
    }
}
