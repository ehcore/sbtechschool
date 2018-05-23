package com.ehcore.javaschool.lesson5exception.client;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

import java.util.*;

public class TerminalImpl implements Terminal {
    private TerminalService service;
    private Integer pinCode;

    @Override
    public void start() {
        init();
        work();
    }

    private void init() {
        service = new TerminalServiceImpl();
    }

    private void work() {
        int count = 0;
        while (true) {
            String pinStr = getPin();
            try {
                Integer pin = Integer.parseInt(pinStr);
                service.checkPin(pin);
                this.pinCode = pin;
                while (true) {
                    int numOper = service.getOperation();
                    switch (numOper) {
                        case 1:
                            putMoney();
                            break;
                        case 2:
                            getMoney();
                            break;
                        case 3:
                            checkMoney();
                            break;
                        case 4:
                            return;
                    }
                }
            } catch (ConnectException exc) {
                count = -1;//**потому как дальше он увеличивается на 1, а нам в данной итерации нужен 0 для текущей ситуации
                this.pinCode = null;
                System.out.println(exc.getMessage());
            } catch (NoSuchPinCodeException exc) {
                this.pinCode = null;
                System.out.println(exc.getMessage());
            }
            count++;
            if (((count % 3) == 0) & (count > 0)) {
                service.lock();
            }
        }
    }

    private void putMoney() throws ConnectException {
        while (true) {
            System.out.println("Введите сумму, которую хотите внести (сумма должна быть кратной 100):");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            try {
                service.putMoney(pinCode, x);
                break;
            } catch (IncorrectNumberException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }

    private void getMoney() throws ConnectException {
        while (true) {
            System.out.println("Введите сумму, которую хотите снять (сумма должна быть кратной 100):");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            try {
                service.getMoney(pinCode, x);
                break;
            } catch (IncorrectNumberException | NotEnoughMoneyException exc) {
                System.out.println(exc.getMessage());
            }
        }

    }

    private void checkMoney() throws ConnectException {
        int x = service.checkMoney(pinCode);
        System.out.println("Наличие денег на счете:" + x);
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
            } catch (NullPinException | IncorrectPinException exc) {
                System.out.println(exc.getMessage());
            }
            count++;
            if (((count % 3) == 0) & (count > 0)) {
                service.lock();
            }
        }
        return pin;
    }

    private void checkCorrectPin(String pin) throws NullPinException, IncorrectPinException {
        if (pin.equals("")) {
            throw new NullPinException();
        }
        try {
            Integer.parseInt(pin);
        } catch (NumberFormatException exc) {
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
