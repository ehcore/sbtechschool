package com.ehcore.javaschool.lesson5exception.client;

import com.ehcore.javaschool.lesson5exception.exceptions.*;
import com.ehcore.javaschool.lesson5exception.server.*;

public class TerminalServiceImpl implements TerminalService {
    private TerminalServer server;

    public TerminalServiceImpl() {
        server = new TerminalServerImpl();
    }

    @Override
    public void putMoney(Integer pinCode, int x) throws IncorrectNumberException, ConnectException {
        if ((x % 100) != 0) {
            throw new IncorrectNumberException();
        }
        connectServer();
        server.putMoney(pinCode, x);
    }

    @Override
    public void getMoney(Integer pinCode, int x) throws IncorrectNumberException, ConnectException,
            NotEnoughMoneyException {
        if ((x % 100) != 0) {
            throw new IncorrectNumberException();
        }
        connectServer();
        server.getMoney(pinCode, x);
    }

    @Override
    public int checkMoney(Integer pinCode) throws ConnectException {
        connectServer();
        return server.checkMoney(pinCode);
    }

    @Override
    public void connectServer() throws ConnectException {
        long rand = System.currentTimeMillis();
        if ((rand % 9) == 0) {
            throw new ConnectException();
        }
    }

    @Override
    public void checkPin(Integer pin) throws ConnectException, NoSuchPinCodeException {
        connectServer();
        server.validatePin(pin);
    }

    @Override
    public void lock() {
        try {
            throw new AccountIsLockedException();
        } catch (AccountIsLockedException exc) {
            System.out.println(exc.getMessage());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException exc2) {
                System.out.println(exc2.getMessage());
            }
        }
    }
}
