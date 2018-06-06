
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        Contract contract = new Contract(1,"АО Ромашка","ул.Королева 1");
        SerializationUtils.serialize(contract,"contr2.ser");

        Contract contract1 = (Contract) SerializationUtils.deserialize("contr2.ser");
        System.out.println(contract1);
    }
}
