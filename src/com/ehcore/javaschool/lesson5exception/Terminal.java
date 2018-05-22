package com.ehcore.javaschool.lesson5exception;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

public interface Terminal {
    void putMoney(int x) throws IncorrectNumberException;
    void getMoney(int x) throws IncorrectNumberException;
    void connectServer() throws ConnectException;
    void validatePin(Integer pin) throws NullPinException;
}
