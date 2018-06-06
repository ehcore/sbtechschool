import java.io.*;

public class SerializationUtils {
    private SerializationUtils(){}
    static void serialize(Object object, String fileName){
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(new File(fileName)))){

            out.writeObject(object);
        }catch (IOException exc){
            exc.printStackTrace();
        }
    }
    static Object deserialize(String fileName) throws ClassNotFoundException{
        Object object = null;
        try(ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(new File(fileName)))){

            object = in.readObject();
        }catch (IOException exc){
            exc.printStackTrace();
        }
        return object;
    }
}
