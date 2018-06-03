package server;

import exceptions.*;
import java.util.*;

public class TerminalServerImpl implements TerminalServer {
    private Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(1234, 100);
        map.put(1111, 300);
        map.put(6207, 5000);
        map.put(909322, 23000);
    }

    @Override
    public void putMoney(Integer pinCode, int x) {
        map.put(pinCode, map.get(pinCode) + x);
    }

    @Override
    public void getMoney(Integer pinCode, int x) throws NotEnoughMoneyException {
        if (map.get(pinCode) < x) {
            throw new NotEnoughMoneyException();
        }
        map.put(pinCode, map.get(pinCode) - x);
    }

    @Override
    public int checkMoney(Integer pinCode) {
        return map.get(pinCode);
    }

    @Override
    public void validatePin(Integer x) throws NoSuchPinCodeException {
        if (!map.containsKey(x)) {
            throw new NoSuchPinCodeException();
        }
    }
}
