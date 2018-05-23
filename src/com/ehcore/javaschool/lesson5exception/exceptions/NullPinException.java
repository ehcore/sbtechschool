package com.ehcore.javaschool.lesson5exception.exceptions;

public class NullPinException extends TerminalException {
    @Override
    public String getMessage() {
        return "Попытка входа с пустым пин-кодом. Попробуйте еще раз.";
    }
}
