package com.ehcore.javaschool.lesson5exception.client;

import com.ehcore.javaschool.lesson5exception.exceptions.*;
import java.util.*;

public class TerminalImpl implements Terminal{
    private TerminalService service;

    @Override
    public void start() {
        init();
        work();
    }

    private void init() {
        service = new TerminalServiceImpl();
    }

    private void work() {
        while(true) {
            String pinStr = getPin();
            try {
                service.checkPin(Integer.parseInt(pinStr));
                break;
            } catch (ConnectException | NoSuchAccountException exc) {
                System.out.println(exc.getMessage());
            }
        }

    }


    private String getPin() {
        String pin = null;
        int count = 0;
        while (true) {

            System.out.println("Введите пин-код:");
            Scanner scanner = new Scanner(System.in);
            pin = scanner.nextLine().trim();

            try {
                checkCorrectPin(pin);
                break;
            }catch (NullPinException | IncorrectPinException exc) {
                System.out.println(exc.getMessage());
            }

            count++;

            if((count % 3) == 0){
                service.lock();
            }

        }
        return pin;
    }

    private void checkCorrectPin(String pin) throws NullPinException, IncorrectPinException{
        if(pin.equals("")){
            throw new NullPinException();
        }
        try {
            Integer.parseInt(pin);
        }catch(NumberFormatException exc){
            throw new IncorrectPinException();
        }
    }






    /*

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
//        while(true) {
//            try {
                this.connectServer();
//                break;
//            } catch (ConnectException exc) {
//                System.err.println(exc.getMessage());
//            }
//        }

        if((x % 100) != 0 ){
            throw new IncorrectNumberException();
        }
    }

    @Override
    public void getMoney(int x) throws IncorrectNumberException {

    }

    @Override
    public void connectServer() throws ConnectException {
        try {
            server.connect();
        } catch (ConnectException exc) {
            System.err.println(exc.getMessage());
        }
//        long rand = System.currentTimeMillis();
//        if((rand % 2) != 0){
//            throw new ConnectException();
//        }
    }
    */
}
