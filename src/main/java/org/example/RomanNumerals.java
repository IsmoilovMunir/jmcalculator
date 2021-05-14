package org.example;


public class RomanNumerals {

    public static String format(int value) {

        String romanNum= "";





        while (value > 0) {
            while (value >= 1000) {
                romanNum = romanNum + "M";
                value -= 1000;
            }
            while (value >= 900) {
                romanNum = romanNum + "CM";
                value -= 900;
            }
            while (value >= 500) {
                romanNum = romanNum + "D";
                value -= 500;
            }
            while (value >= 400) {
                romanNum = romanNum + "CD";
                value -= 400;
            }
            while (value >= 100) {
                romanNum = romanNum + "C";
                value -= 100;
            }
            while (value >= 90) {
                romanNum = romanNum + "XC";
                value -= 90;
            }
            while (value >= 50) {
                romanNum = romanNum + "L";
                value -= 50;
            }
            while (value >= 40) {
                romanNum = romanNum + "XL";
                value -= 40;
            }
            while (value >= 10) {
                romanNum = romanNum + "X";
                value -= 10;
            }
            while (value >= 9) {
                romanNum = romanNum + "IX";
                value -= 9;
            }
            while (value >= 5) {
                romanNum = romanNum + "V";
                value -= 5;
            }
            while (value >= 4) {
                romanNum = romanNum + "IV";
                value -= 4;
            }
            while (value >= 1) {
                romanNum = romanNum + "I";
                value -= 1;
            }

        }
        return romanNum;
    }


    public static int parse(String number) {


        int lengthOfNumber = number.length();
        //int "I" = 1;

        int[] value = new int[lengthOfNumber];



        for (int i = lengthOfNumber; i> 0;i-=1) {
            if (number.charAt(i-1)==('I'))
                value [i-1]= 1;
            else if (number.charAt(i -1)==('V'))
                value [i-1]= 5;
            else if (number.charAt(i -1)==('X'))
                value [i-1]= 10;


            else
                return -1;
        }


        for(int i = 0; i < lengthOfNumber -3; i+=1){
            if(value [i] == value[i+1] && value [i+1] == value[i+2] && value [i+2] == value[i+3]){
                return -1;
            }
        }



        int total = value [lengthOfNumber-1];
        for (int i = lengthOfNumber;i > 1;i-=1) {
            if (value[i -1] <= value[i - 2]){
                total+=value[i-2];
            }
            if (value[i -1 ] > value[i - 2]){
                total-=value[i-2];
            }
            //System.out.println(total);

        }


        return total;
    }

}
