package com.ehcore.javaschool.lesson5exception.exceptions;

public class IncorrectPinException extends TerminalException{
    @Override
    public String getMessage() {
        return "Не правильный пин-код. Попробуйте ще раз.";
    }
}
