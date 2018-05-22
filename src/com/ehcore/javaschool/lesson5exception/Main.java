package com.ehcore.javaschool.lesson5exception;

import com.ehcore.javaschool.lesson5exception.exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TerminalServer server = new TerminalServerImpl();
        Terminal terminal = new TerminalImpl(server);

        while (true) {
            System.out.println("Введите пин-код:");
            Scanner scanner = new Scanner(System.in);

            Integer pin = Integer.valueOf(scanner.nextLine());
            System.out.println(pin);
            try {
                terminal.validatePin(pin);
                break;
            } catch (NullPinException exc) {
                System.out.println(exc.getMessage());
            }
        }


        while (true) {
            System.out.println("Введите сумму, которую собираетесь положить:");
            Scanner scanner = new Scanner(System.in);
            int inSumm = scanner.nextInt();

            try {
                terminal.putMoney(inSumm);
                break;
            } catch (IncorrectNumberException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
