package exceptions;

public class IncorrectPinException extends TerminalException {
    @Override
    public String getMessage() {
        return "Не корректный пин-код. Используйте только цифры. Попробуйте еще раз.";
    }
}
