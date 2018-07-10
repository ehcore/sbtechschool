import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public Server(){
    }

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
        for(PrintWriter writer: clientOutputStream){
            try{
                writer.println(message);
            }catch(Exception exc){
                exc.printStackTrace();
            }
        }
    }
}


