import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {

        try(BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            PrintWriter out =
                    new PrintWriter(
                            new BufferedWriter(
                                    new OutputStreamWriter(socket.getOutputStream())), true)){


//            while (true) {
                String strRead = in.readLine();
                System.out.println(strRead);
                //out.println(strRead);
                if (strRead.equals("exit")) {
                    return;
                    //break;
                }
 /*               if (strRead.equals("stop")) {
                    return;
                }*/
//            }

        }catch (IOException exc){

        }




    }
}
