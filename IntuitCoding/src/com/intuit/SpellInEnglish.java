package com.intuit;

import java.util.Scanner;

/**
 * Created by Uday on 2016-05-23.
 */
public class SpellInEnglish {

    public String displayInEnglish(int number) {

        String convertedOutput="";

        String[] oneDigit={"","one", "two", "three", "four", "five", "six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen", "eighteen","nineteen" };
        String[] tensDigit={"","ten", "twenty", "thirty","fourty","fifty","sixty","seventy","eighty","ninety"};


        if(number%100<20) {
            convertedOutput=oneDigit[number%100];
        }

        else {

            convertedOutput=oneDigit[number%10];
            number=number/10;

            convertedOutput=tensDigit[number%10]+convertedOutput;
            number=number/10;
        }

        if(number==0)
            return convertedOutput;

        return oneDigit[number]+"hundred"+convertedOutput;

        }



    public static void main(String[] args) {

        SpellInEnglish spellInEnglish = new SpellInEnglish();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an input number between 0 and 100");
        int inputNumber=scanner.nextInt();

        if(inputNumber<0 || inputNumber>100)
            System.out.println("Enter a valid number between 0 and 100");

        else {

            String finalOutput=spellInEnglish.displayInEnglish(inputNumber);
            System.out.println(finalOutput);
        }


    }
}
