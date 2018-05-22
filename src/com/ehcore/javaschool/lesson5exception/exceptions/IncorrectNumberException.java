package com.ehcore.javaschool.lesson5exception.exceptions;

public class IncorrectNumberException extends TerminalException{
    @Override
    public String getMessage() {
        return "Введена не корректная сумма. Введите сумму, кратную 100.";
    }


}
