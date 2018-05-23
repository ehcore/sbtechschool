package com.ehcore.javaschool.lesson5exception.server;

import com.ehcore.javaschool.lesson5exception.exceptions.*;
import java.util.*;

public class TerminalServerImpl implements TerminalServer{
    Map<Integer,Integer> map = new HashMap<>();
    {
        map.put(1234,100);
        map.put(1111,300);
        map.put(6207,5000);
        map.put(909322,23000);
    }

    @Override
    public void putMoney(int x) {

    }

    @Override
    public void getMoney(int x) {

    }

    @Override
    public void validatePin(Integer x) throws NoSuchAccountException{
        if(!map.containsKey(x)){
            throw new NoSuchAccountException();
        }
    }
}
