package com.ehcore.javaschool.lesson5exception.exceptions;


public class NoSuchPinCodeException extends TerminalException {
    @Override
    public String getMessage() {
        return "Нет такого пин кода.";
    }
}
