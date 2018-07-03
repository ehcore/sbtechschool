import java.io.*;
import java.net.*;

public class Client {

    private PrintWriter out;
    private BufferedReader in;


    public Client() {

        while (true) {
            String ip = "localhost";
            try (Socket socket = new Socket(ip, 2044)) {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(System.in/*socket.getInputStream()*/));

                try {
                    String strRead = in.readLine();
                    if (strRead == null) {
                        break;
                    } else {
                        out.println(strRead);
                    }
                } catch (SocketException sockExc) {
                    break;
                }

            } catch (ConnectException connExc) {
            } catch (IOException ioExc) {
            }


        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }

}
