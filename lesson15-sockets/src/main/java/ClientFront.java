import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class ClientFront extends Application {

    Label lbl1;
    TextField txtF1;
    Button btn1;
    TextArea txtA1;

    Label lbl2;
    TextField txtF2;
    Button btn2;

    private PrintWriter writer;
    private BufferedReader reader;

    Socket socket;

    public ClientFront(){
    }

    static void go(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane root = new FlowPane(10,10);

        root.setAlignment(Pos.CENTER);



        lbl1 = new Label("Логин:");

        txtF1 = new TextField();

        btn1 = new Button("Войти");
        btn1.setOnAction((event -> {

            if("Войти".equals(btn1.getText())){
                setUpNetworking();

                Thread thread = new Thread(new IncomingReader());
                thread.start();

                txtF1.setDisable(true);
                btn1.setText("Выйти");
            }else if("Выйти".equals(btn1.getText())){
                closeNetworking();
                txtF1.setDisable(false);
                btn1.setText("Войти");
            }
        }));

        txtA1 = new TextArea();
        txtA1.setMaxSize(380,300);


        lbl2 = new Label("Сообщение:");

        txtF2 = new TextField();

        btn2 = new Button("Отправить");

        btn2.setOnAction((event -> {
            writer.println(txtF2.getText());
            txtF2.clear();
        }));

        root.getChildren().addAll(lbl1,txtF1,btn1,txtA1,lbl2,txtF2,btn2);

        Scene scene;
        scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Клиент для чата");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();



    }


    private void setUpNetworking(){

        try{
            socket = new Socket("localhost",5000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println(txtF1.getText());
        }catch(IOException exc){
            exc.printStackTrace();
        }

    }

    private void closeNetworking(){

        try{
            writer.close();
            reader.close();
            socket.close();
        }catch(IOException exc){
            exc.printStackTrace();
        }
    }

    class IncomingReader implements Runnable{

        @Override
        public void run() {
            String message;
            try{

                while((message = reader.readLine()) != null){
                    txtA1.appendText(message + "\n");
                }
                System.out.println("Thread stoped");

            }catch(Exception exc){
                exc.printStackTrace();
            }
        }
    }
}





