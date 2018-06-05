package server;

import exceptions.*;

public interface TerminalServer {
    void putMoney(Integer pinCode, int x);

    void getMoney(Integer pinCode, int x) throws NotEnoughMoneyException;

    int checkMoney(Integer pinCode);

    void validatePin(Integer x) throws NoSuchPinCodeException;
}
