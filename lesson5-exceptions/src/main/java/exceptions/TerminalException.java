package exceptions;

public class TerminalException extends Exception {
    @Override
    public String getMessage() {
        return "Общая ошибка";
    }
}
