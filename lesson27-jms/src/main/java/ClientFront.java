import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javax.jms.*;

public class ClientFront extends Application {

    Label lbl1;
    TextField txtF1;
    Button btn1;
    TextArea txtA1;
    Label lbl2;
    TextField txtF2;
    Button btn2;

    String userName;

    static Topic topic;
    static Connection connection;

    static void go(String[] args, Connection _connecton, Topic _topic) {
        connection = _connecton;
        topic = _topic;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);

        lbl1 = new Label("Логин:");

        txtF1 = new TextField();

        btn1 = new Button("Войти в чат");
        btn1.setOnAction((event -> {
            if ("Войти в чат".equals(btn1.getText())) {
                new Thread(new IncomingReader()).start();
                userName = txtF1.getText();
                txtF1.setDisable(true);
                btn1.setText("Покинуть чат");
                btn2.setDisable(false);
                sendMessage("+++ Пользователь " + userName + " вошел в чат +++");
            } else if ("Покинуть чат".equals(btn1.getText())) {
                txtF1.setDisable(false);
                btn1.setText("Войти в чат");
                btn2.setDisable(true);
                sendServiceMessage();
            }
        }));

        txtA1 = new TextArea();
        txtA1.setMaxSize(380, 300);

        lbl2 = new Label("Сообщение:");

        txtF2 = new TextField();

        btn2 = new Button("Отправить");
        btn2.setDisable(true);
        btn2.setOnAction((event -> {
            String textMessage = txtF2.getText();
            sendMessage(userName + ":>" + textMessage);
            txtF2.clear();
        }));

        root.getChildren().addAll(lbl1, txtF1, btn1, txtA1, lbl2, txtF2, btn2);
        Scene scene;
        scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Клиент для чата");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void sendMessage(String textMessage) {
        try {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(topic);
            TextMessage message = session.createTextMessage(textMessage);
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void sendServiceMessage() {
        try {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(topic);
            TextMessage message = session.createTextMessage("--- Пользователь " + userName + " покинул чат ---");
            message.setStringProperty("exit", userName);
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private class IncomingReader implements Runnable {

        @Override
        public void run() {
            try {
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageConsumer consumer = session.createConsumer(topic);
                connection.start();
                while (true) {
                    TextMessage message = (TextMessage) consumer.receive();
                    String str = message.getText();
                    String user = message.getStringProperty("exit");
                    if (user != null && user.equals(userName)) break;
                    txtA1.appendText(str + "\n");
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}