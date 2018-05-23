package com.ehcore.javaschool.lesson5exception.server;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

public interface TerminalServer {
    void putMoney(Integer pinCode, int x);

    void getMoney(Integer pinCode, int x) throws NotEnoughMoneyException;

    void validatePin(Integer x) throws NoSuchPinCodeException;
}
