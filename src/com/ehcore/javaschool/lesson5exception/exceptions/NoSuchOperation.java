package com.ehcore.javaschool.lesson5exception.exceptions;

public class NoSuchOperation extends TerminalException {
    @Override
    public String getMessage() {
        return "Нет такой операции. Повторите ввод.";
    }
}
