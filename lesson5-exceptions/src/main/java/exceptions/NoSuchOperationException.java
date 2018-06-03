package exceptions;

public class NoSuchOperationException extends TerminalException {
    @Override
    public String getMessage() {
        return "Нет такой операции. Повторите ввод.";
    }
}
