import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public Server(int port){
        try (ServerSocket serverSocket = new ServerSocket(port)) {

          //  new Thread(new ServerThread(serverSocket.accept())).start();

            while(true){
                ExecutorService service = Executors.newFixedThreadPool(2);
                for (int i = 0; i < 2; i++) {
                    service.execute(new ServerThread(serverSocket.accept()));
                }

            }


        }catch (IOException exc){

        }
    }

    public static void main(String[] args) {
        Server server = new Server(2044);
    }
}
