package loaders;

/**
 * Данный класс загружает классы из пакета *.app
 */

public class AppClassloader extends ApiClassloader{
    private final String pack = "app";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.contains(pack)){
            return findClass(name);
        }else {
            return super.loadClass(name);
        }
    }
}
