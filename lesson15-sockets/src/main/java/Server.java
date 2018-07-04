import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server {
    private List<Socket> list = new ArrayList<>();
    public Server(int port){
        try (ServerSocket serverSocket = new ServerSocket(port)) {

          //  new Thread(new ServerThread(serverSocket.accept())).start();

            while(true){
                ExecutorService service = Executors.newFixedThreadPool(2);
                for (int i = 0; i < 2; i++) {
                    Socket socket = serverSocket.accept();
                    service.execute(new ServerThread(socket));
                    list.add(socket);
                }

            }


        }catch (IOException exc){

        }
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}
