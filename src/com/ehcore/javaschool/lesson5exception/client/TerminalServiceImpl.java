package com.ehcore.javaschool.lesson5exception.client;

import com.ehcore.javaschool.lesson5exception.exceptions.*;
import com.ehcore.javaschool.lesson5exception.server.*;
import java.util.*;

public class TerminalServiceImpl implements TerminalService{
    private TerminalServer server;

    public TerminalServiceImpl() {
        server = new TerminalServerImpl();
    }

    @Override
    public void putMoney(Integer pinCode, int x) throws IncorrectNumberException,ConnectException {
        if((x % 100) != 0 ){
            throw new IncorrectNumberException();
        }
        try{
            connectServer();
            server.putMoney(pinCode,x);
        }catch (ConnectException exc) {
            throw new ConnectException();
        }
    }

    @Override
    public void getMoney(Integer pinCode,int x) throws IncorrectNumberException,ConnectException,
            NotEnoughMoneyException{

        if((x % 100) != 0 ){
            throw new IncorrectNumberException();
        }
        try{
            connectServer();
            server.getMoney(pinCode,x);
        }catch (ConnectException exc) {
            throw new ConnectException();
        }

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
                System.out.println(exc2.getMessage());
            }
        }
    }

    @Override
    public int getOperation() throws ConnectException{
        try{
            while(true) {
                connectServer();
                try {
                    System.out.println("Доступные операции:");
                    System.out.println("1.Внести деньги");
                    System.out.println("2.Снять деньги");
                    System.out.println("3.Выход");
                    System.out.println("Введите номер операции:");
                    Scanner scanner = new Scanner(System.in);
                    int numOper = scanner.nextInt();
                    if ((numOper < 1) || (numOper > 3)) {
                        throw new NoSuchOperation();
                    }

                    return numOper;

                   // break;
                } catch (NoSuchOperation exc) {
                    System.out.println(exc.getMessage());
                }
            }
        }catch (ConnectException exc) {
            throw new ConnectException();
        }

    }
}
