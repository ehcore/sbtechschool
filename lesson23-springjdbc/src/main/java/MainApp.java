import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MainApp {
    public static void main(String[] args){
        Client client = new Client();
        client.start();
    }
}
