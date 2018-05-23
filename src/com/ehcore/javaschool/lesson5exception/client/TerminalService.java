package com.ehcore.javaschool.lesson5exception.client;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

public interface TerminalService {
    void putMoney(Integer pinCode, int x) throws IncorrectNumberException, ConnectException;

    void getMoney(Integer pinCode, int x) throws IncorrectNumberException, ConnectException, NotEnoughMoneyException;

    int checkMoney(Integer pinCode) throws ConnectException;

    void connectServer() throws ConnectException;

    void checkPin(Integer pin) throws ConnectException, NoSuchPinCodeException;

    int getOperation() throws ConnectException;

    void lock();
}
