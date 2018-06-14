package streamsapi;

public interface Process<T> {
    void doWork(T t);
}
