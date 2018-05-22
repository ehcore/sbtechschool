package com.ehcore.javaschool.lesson5exception;

import com.ehcore.javaschool.lesson5exception.exceptions.ConnectException;
import com.ehcore.javaschool.lesson5exception.exceptions.IncorrectNumberException;
import com.ehcore.javaschool.lesson5exception.exceptions.NullPinException;

public class TerminalImpl implements Terminal{
    private final TerminalServer server;

    public TerminalImpl(TerminalServer server) {
        this.server = server;
    }

    @Override
    public void validatePin(Integer pin) throws NullPinException{
        if(pin == null){
            throw new NullPinException();
        }
    }

    @Override
    public void putMoney(int x) throws IncorrectNumberException {
        while(true) {
            try {
                this.connectServer();
                break;
            } catch (ConnectException exc) {
                System.out.println(exc.getMessage());
            }
        }

        if((x % 100) != 0 ){
            throw new IncorrectNumberException();
        }
    }

    @Override
    public void getMoney(int x) throws IncorrectNumberException {

    }

    @Override
    public void connectServer() throws ConnectException {
        long rand = System.currentTimeMillis();
        if((rand % 2) != 0){
            throw new ConnectException();
        }
    }
}
