


import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    private PrintWriter out;
    private BufferedReader in;


    public Client() {
        System.out.println("11");
 /*       while (true) {
            String ip = "localhost";
            try (Socket socket = new Socket(ip, 2044)) {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(System.in*//*socket.getInputStream()*//*));

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


        }*/
    }



    public static void main(String[] args) {
        //Client client = new Client();
        //ClientFront front = new ClientFront(args);
        ClientFront.go(args);

    }

/*
    ArrayList<Object> clientOutputStream;

    class ClientHandler implements Runnable{

        BufferedReader reader;
        Socket sock;

        public ClientHandler(Socket clientSocket){

            try{

                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
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
                    tellEveryone(message);
                }

            }catch(Exception exc){
                exc.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        new Client().go();
    }

    public void go(){

        clientOutputStream = new ArrayList<>();

        try{

            ServerSocket serverSocket = new ServerSocket(5000);

            while(true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStream.add(writer);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }


        }catch(Exception exc){
            exc.printStackTrace();
        }

    }

    public void tellEveryone(String message){

        Iterator it = clientOutputStream.iterator();

        while(it.hasNext()){

            try{
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();

            }catch(Exception exc){
                exc.printStackTrace();
            }

        }

    }
*/


}
