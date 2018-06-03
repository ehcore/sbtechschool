import app.*;
import loaders.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Apps apps = new MyApp();
        System.out.println(Apps.class.getClassLoader());

        ApiClassloader loader = new ApiClassloader();
        Class<?> clazz = Class.forName("api.Calculator", false, loader);
        System.out.println("class " + clazz.getSimpleName() +  " loaded :" + clazz.getClassLoader());

        ApiClassloader loader2 = new AppClassloader();
        Class<?> clazz2 = Class.forName("app.App", true, loader2);
        System.out.println("class " + clazz2.getSimpleName() +  " loaded :" + clazz2.getClassLoader());

        ApiClassloader loader3 = new ImplClassloader();
        Class<?> clazz3 = Class.forName("impl.CalculatorImpl", true, loader3);
        System.out.println("class " + clazz3.getSimpleName() +  " loaded :" + clazz3.getClassLoader());

        Class<?> clazz4 = Class.forName("app.MyApp", true, loader2);
        System.out.println("class " + clazz4.getSimpleName() +  " loaded :" + clazz4.getClassLoader());

//        Apps apps1 = (Apps) clazz4.newInstance();
//
//        System.out.println(apps1.getCalculator());
    }
}
