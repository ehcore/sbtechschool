import java.io.*;
import java.net.Socket;
import java.util.*;

public class ServerThread implements Runnable {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;


    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {

   /*     try(reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(new BufferedWriter(
                                    new OutputStreamWriter(socket.getOutputStream())), true)){


//            while (true) {
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
//                String strRead = in.readLine();
                System.out.println(Thread.currentThread().getName() + ":" + strRead);
                writer.println(strRead);
                if (strRead.equals("exit")) {
                    return;
                    //break;
                }
*//*               if (strRead.equals("stop")) {
                return;
            }*//*
            }

        }catch (IOException exc){

        }
*/



    }
}
