package com.ehcore.javaschool.lesson5exception.exceptions;

public class ConnectException extends TerminalException {
    @Override
    public String getMessage() {
        return "Потеряна связь с сервером, попробуйте позже.";
    }
}
