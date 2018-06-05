import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        GetterCounter counter = new GetterCounterImpl();

        GetterCounter counter2 = (GetterCounter) Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{GetterCounter.class},
                new MyGetterCounterInvocationHandler(counter));

        Class<?> clazz = Person.class;

        System.out.println("Количество геттреров в классе " + clazz.getSimpleName() + ": " + counter2.calcGetterCount(clazz));
    }
}
