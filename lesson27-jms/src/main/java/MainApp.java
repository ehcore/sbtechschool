import org.springframework.context.support.GenericXmlApplicationContext;
import javax.jms.*;

public class MainApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring-config.xml");
        ConnectionFactory connectionFactory = ctx.getBean("connectionFactory", ConnectionFactory.class);
        Topic topic = ctx.getBean("topic", Topic.class);
        try {
            Connection connection = connectionFactory.createConnection();
            ClientFront.go(args, connection, topic);
            connection.close();
        } catch (JMSException exc) {
        }
    }
}