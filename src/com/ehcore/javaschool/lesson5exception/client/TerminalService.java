package com.ehcore.javaschool.lesson5exception.client;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

public interface TerminalService {
    void putMoney(int x) throws IncorrectNumberException;
    void getMoney(int x) throws IncorrectNumberException,NotEnoughMoneyException;
    void connectServer() throws ConnectException; //or checkConnect();
    void checkPin(Integer pin) throws ConnectException,NoSuchAccountException;
    void lock();
}
