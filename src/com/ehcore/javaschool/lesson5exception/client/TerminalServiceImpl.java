package com.ehcore.javaschool.lesson5exception.client;

import com.ehcore.javaschool.lesson5exception.exceptions.*;
import com.ehcore.javaschool.lesson5exception.server.*;

public class TerminalServiceImpl implements TerminalService{
    private TerminalServer server;

    public TerminalServiceImpl() {
        server = new TerminalServerImpl();
    }

    @Override
    public void putMoney(int x) throws IncorrectNumberException {

    }

    @Override
    public void getMoney(int x) throws IncorrectNumberException, NotEnoughMoneyException {

    }

    @Override
    public void connectServer() throws ConnectException {
        long rand = System.currentTimeMillis();
        if((rand % 2) != 0){
            throw new ConnectException();
        }
    }

    @Override
    public void checkPin(Integer pin) throws ConnectException,NoSuchAccountException{
        try{
            connectServer();
            server.validatePin(pin);
        }catch (ConnectException exc) {
            throw new ConnectException();
        }catch (NoSuchAccountException exc){
            throw new NoSuchAccountException();
        }
    }

    @Override
    public void lock() {
        try {
            throw new AccountIsLockedException();
        }catch (AccountIsLockedException exc){
            System.out.println(exc.getMessage());
            try{
                Thread.sleep(5000);
            } catch (InterruptedException exc2) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
