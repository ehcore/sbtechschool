package com.ehcore.javaschool.lesson5exception.exceptions;

public class AccountIsLockedException extends TerminalException{
    @Override
    public String getMessage() {
        return "Ошибка ввода пин-кода. Аккаунт заблокирован. Попробуйте позже.";
    }
}
