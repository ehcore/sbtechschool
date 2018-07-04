import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

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

    public ClientFront(/*String[] args*/){




        /*launch(args);*/
    }

    static void go(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
/*
        TextField txtAr = new TextField();

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                txtAr.setText("Hello World!");
            }
        });
*/

        setUpNetworking();


        FlowPane root = new FlowPane(10,10);

        root.setAlignment(Pos.CENTER);



        lbl1 = new Label("Логин:");

        txtF1 = new TextField();

        btn1 = new Button("Войти");

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
        /*root.getChildren().add(txtAr);*/

        Scene scene;
        scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Клиент для чата");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        Thread thread = new Thread(new IncomingReader());
        thread.start();


    }


    private void setUpNetworking(){

        try{
            socket = new Socket("localhost",5000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);
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

            }catch(Exception exc){
                exc.printStackTrace();
            }


        }

    }

}





