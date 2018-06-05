package loaders;

/**
 * Данный класс загружает классы из пакета *.impl
 */

public class ImplClassloader extends ApiClassloader{
    private final String pack = "impl";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.contains(pack)){
            return findClass(name);
        }else {
            return super.loadClass(name);
        }
    }
}
