package com.ehcore.javaschool.lesson5exception.server;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

public interface TerminalServer {
    void putMoney(int x);
    void getMoney(int x);
    void validatePin(Integer x) throws NoSuchAccountException;
}
