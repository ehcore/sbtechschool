import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server {
    private List<Socket> list = new ArrayList<>();
    public Server(/*int port*/){
  /*      try (ServerSocket serverSocket = new ServerSocket(port)) {

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

        }*/
    }
/*

    public static void main(String[] args) {
        Server server = new Server(5000);
    }

*/


    ArrayList<PrintWriter> clientOutputStream;
    Map<String,Socket> map;

    class ClientHandler implements Runnable{

        private BufferedReader reader;
        private Socket socket;
        private String login;

        public ClientHandler(Socket clientSocket, String login){

            try{
                this.login = login;
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);

            }catch(Exception exc){
                exc.printStackTrace();
            }

        }

        @Override
        public void run() {
            String message;

            try{
                while((message = reader.readLine()) != null){
                    tellEveryone(login +">>>" + message);
                }

            }catch(Exception exc){
                exc.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        new Server().go();
    }

    public void go(){

        clientOutputStream = new ArrayList<>();
        map = new HashMap<>();

        try{

            ServerSocket serverSocket = new ServerSocket(5000);

            while(true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                clientOutputStream.add(writer);
                String login = null;
                if((login = reader.readLine()) != null)
                    //map.put(login,clientSocket);
                {Thread t = new Thread(new ClientHandler(clientSocket,login));
                t.start();}
            }


        }catch(Exception exc){
            exc.printStackTrace();
        }

    }

    public void tellEveryone(String message){

/*
        for (HashMap.Entry<Integer,Integer> e : map.entrySet()){
            int curIntMap = e.getValue();
*/


/*
        for(HashMap.Entry<String,Socket> set: map.entrySet() ){
            String login = set.getKey();
            Socket socket =  set.getValue();
            try {
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
                writer.println(login + ">>>" + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
        for(PrintWriter writer: clientOutputStream){
            try{
                writer.println(message);
            }catch(Exception exc){
                exc.printStackTrace();
            }
        }


        }



    }


