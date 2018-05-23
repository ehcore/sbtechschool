package com.ehcore.javaschool.lesson5exception.server;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

import java.util.*;

public class TerminalServerImpl implements TerminalServer {
    Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(1234, 100);
        map.put(1111, 300);
        map.put(6207, 5000);
        map.put(909322, 23000);
    }

    @Override
    public void putMoney(Integer pinCode, int x) {
        map.put(pinCode, map.get(pinCode) + x);
        System.out.println(map);
    }

    @Override
    public void getMoney(Integer pinCode, int x) throws NotEnoughMoneyException {
        if (map.get(pinCode) < x) {
            throw new NotEnoughMoneyException();
        }
        map.put(pinCode, map.get(pinCode) - x);
        System.out.println(map);
    }

    @Override
    public void validatePin(Integer x) throws NoSuchPinCodeException {
        if (!map.containsKey(x)) {
            throw new NoSuchPinCodeException();
        }
    }
}
