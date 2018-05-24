package com.ehcore.javaschool.lesson5exception.client;

import com.ehcore.javaschool.lesson5exception.exceptions.*;
import com.ehcore.javaschool.lesson5exception.server.*;

import java.util.*;

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

    @Override
    public int getOperation() throws ConnectException {
        while (true) {
            connectServer();
            try {
                System.out.println("Доступные операции:");
                System.out.println("1.Внести деньги");
                System.out.println("2.Снять деньги");
                System.out.println("3.Проверить состояние счета");
                System.out.println("4.Выход");
                System.out.println("Введите номер операции:");
                Scanner scanner = new Scanner(System.in);
                int numOper = 0;
                try {
                    numOper = scanner.nextInt();
                }catch (InputMismatchException exc){
                    throw new NoSuchOperationException();
                }
                if ((numOper < 1) || (numOper > 4)) {
                    throw new NoSuchOperationException();
                }
                return numOper;
            } catch (NoSuchOperationException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
