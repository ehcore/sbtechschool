package client;

import exceptions.*;
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
                    int numOper = getOperation();
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
                count = -1;
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
            int x = 0;
            try {
                try {
                    x = scanner.nextInt();
                }catch (InputMismatchException exc){
                    throw new IncorrectNumberException();
                }
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
            int x = 0;
            try {
                try {
                    x = scanner.nextInt();
                }catch (InputMismatchException exc){
                    throw new IncorrectNumberException();
                }
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

    public int getOperation() {
        while (true) {
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
