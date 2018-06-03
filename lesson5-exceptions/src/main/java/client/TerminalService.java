package client;

import exceptions.*;

public interface TerminalService {
    void putMoney(Integer pinCode, int x) throws IncorrectNumberException, ConnectException;

    void getMoney(Integer pinCode, int x) throws IncorrectNumberException, ConnectException, NotEnoughMoneyException;

    int checkMoney(Integer pinCode) throws ConnectException;

    void connectServer() throws ConnectException;

    void checkPin(Integer pin) throws ConnectException, NoSuchPinCodeException;

    void lock();
}
