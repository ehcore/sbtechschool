package com.ehcore.javaschool.lesson5exception.exceptions;

public class NotEnoughMoneyException extends TerminalException{
    @Override
    public String getMessage() {
        return "Недостаточно средств на счету. Попробуйте другую сумму.";
    }
}
