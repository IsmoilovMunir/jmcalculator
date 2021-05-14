package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Calculator {

    public static void calculate(String leftNumber, String operation, String rightNumber) {

        boolean numValid = true;
        boolean opValid = true;
        int leftInt, rightInt;
        int resultInt = 0;
        boolean modeRoman = false;

        try {
            int leftNumberint = parseInt(leftNumber);
            int rightNumberint = parseInt(rightNumber);
            String leftRomanNumber = RomanNumerals.format(leftNumberint);
            String rightRomanNumber = RomanNumerals.format(rightNumberint);
            leftInt = RomanNumerals.parse(leftRomanNumber.toUpperCase());
            rightInt = RomanNumerals.parse(rightRomanNumber.toUpperCase());

        } catch (NumberFormatException e) {
            modeRoman = true;
            leftInt = RomanNumerals.parse(leftNumber.toUpperCase());
            rightInt = RomanNumerals.parse(rightNumber.toUpperCase());

        }


        if (leftInt == -1) {
            numValid = false;
            System.out.println("неверный номер: " + leftNumber);
        }
        if (rightInt == -1) {
            numValid = false;
            System.out.println("неверный номер: " + rightNumber);
        }

        if (operation.equals("+") || operation.equals("-") || operation.equals("*") ||
                operation.equals("/") || operation.equals("%") || operation.equals("#")) {
            opValid = true;
        } else {
            opValid = false;
            System.out.println("недопустимая операция");

        }


        if (numValid == true && opValid == true) {

            //сложение
            if (operation.equals("+")) {
                resultInt = leftInt + rightInt;
            }

            //Вычитание
            else if (operation.equals("-")) {
                resultInt = leftInt - rightInt;
            }

            //Умножение
            else if (operation.equals("*")) {
                resultInt = leftInt * rightInt;
            }

            //Деление
            else if (operation.equals("/")) {
                resultInt = leftInt / rightInt;
            }
            //**

            if ((leftInt >10 || leftInt<0) || (rightInt>10 || rightInt<0)){
                System.out.println("eror");
                System.exit(1);
            }



            // Форматирует и отображает результат

            if (opValid && numValid) {

                // Если результат находится в диапазоне, форматируется в римскую цифру и отображается на консоли
                if (resultInt <= 0 || resultInt >= 4000) {
                    System.out.println("result out of range");
                } else if (modeRoman) {
                    System.out.println(RomanNumerals.format(resultInt));
                } else {
                    System.out.println(resultInt);
                }
            }



        }


    }


    public static int parseDecimalNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            // Покажите подсказку.
            System.out.print("> ");
            //Прочитает строку ввода.
            final String line = reader.readLine();
            if (line.length() == 0) {
                System.out.println("done");
                break;
            }
            // Отсканируйте строку на три части
            final Scanner scanner = new Scanner(line);
            final String leftNumber, operation, rightNumber;
            try {
                leftNumber = scanner.next();
                operation = scanner.next();
                rightNumber = scanner.next();
            } catch (NoSuchElementException e) {
                System.err.println("syntax error");
                System.out.println();
                continue;
            }


            //Выполните расчет и покажите результат.
            calculate(leftNumber, operation, rightNumber);

            System.out.println();
        }
    }
}
