package com.ehcore.javaschool.lesson5exception;

import com.ehcore.javaschool.lesson5exception.client.*;
import com.ehcore.javaschool.lesson5exception.exceptions.*;
import com.ehcore.javaschool.lesson5exception.server.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new TerminalImpl();
        terminal.start();
//        TerminalServer server = new TerminalServerImpl();
//        Terminal terminal = new TerminalImpl(server);
//
//        while (true) {
//            System.out.println("Введите пин-код:");
//            Scanner scanner = new Scanner(System.in);
//            //***перенести в TerminalImpl
//            //***получать из сканера строку, а парсить ее уже там
//            //***в случае, если что-то пойдет не так там это и обработать
//            Integer pin = Integer.valueOf(scanner.nextLine());
//            System.out.println(pin);
//            try {
//                terminal.validatePin(pin);
//                break;
//            } catch (NullPinException exc) {
//                System.out.println(exc.getMessage());
//            }
//        }
//
//
//        while (true) {
//            System.out.println("Введите сумму, которую собираетесь положить:");
//            Scanner scanner = new Scanner(System.in);
//            int inSumm = scanner.nextInt();
//
//            try {
//                terminal.putMoney(inSumm);
//                break;
//            } catch (IncorrectNumberException exc) {
//                System.out.println(exc.getMessage());
//            }
//        }
    }
}
