package exceptions;

public class NoSuchPinCodeException extends TerminalException {
    @Override
    public String getMessage() {
        return "Нет такого пин кода.";
    }
}
