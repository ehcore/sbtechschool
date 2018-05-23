package com.ehcore.javaschool.lesson5exception.exceptions;

import java.util.*;

public class AccountIsLockedException extends TerminalException {
    @Override
    public String getMessage() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(Calendar.SECOND, 5);

        String message = "Ошибка ввода пин-кода. Ввод заблокирован на 5 секунд. " +
                "Разблокировка произойдет " + calendar.getTime();
        return message;
    }
}
