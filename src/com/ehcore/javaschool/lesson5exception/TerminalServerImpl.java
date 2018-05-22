package com.ehcore.javaschool.lesson5exception;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

public class TerminalServerImpl implements TerminalServer{
    @Override
    public void putMoney(int x) {

    }

    @Override
    public void getMoney(int x) {

    }

    @Override
    public void validatePin() {

    }

    @Override
    public void connect() throws  ConnectException{
        long rand = System.currentTimeMillis();
        if((rand % 2) != 0){
            throw new ConnectException();
        }
    }
}
