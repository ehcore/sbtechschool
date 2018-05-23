package com.ehcore.javaschool.lesson5exception.exceptions;

public class TerminalException extends Exception {
    @Override
    public String getMessage() {
        return "Общая ошибка";
    }
}
