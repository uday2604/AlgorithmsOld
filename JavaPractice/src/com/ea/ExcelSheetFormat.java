package com.ea;

import java.util.IllegalFormatException;

/**
 * Created by uthota on 7/30/16.
 */
public class ExcelSheetFormat {

    public int convertLettersToInt(String inputString) {

        int result =0;

        if(inputString==null || inputString.length()==0)
            return 0;

        else {
            int i = inputString.length()-1;
            while (i>=0) {

                result+=Math.pow(26, i) * (inputString.charAt(i)-'A'+1);
                i--;

            }

        }
        return result;

    }


    public String convertIntToString(int inputNumber) {

        StringBuilder outputString = new StringBuilder();

        if(inputNumber<=0)
            return null;

        else {

            while (inputNumber>0) {
                inputNumber--;
                outputString.append((char)(inputNumber%26 +'A'));
                inputNumber=inputNumber/26;
            }


        }

        // This step is important (String has to be reversed)
        outputString.reverse();

        return outputString.toString();
    }


    public static void main (String[] args) {

        ExcelSheetFormat excelSheetFormat = new ExcelSheetFormat();
        int finalResult=excelSheetFormat.convertLettersToInt("AAA");
        System.out.println("The integer equivalent fro the given string in excel format is "+finalResult);

        String finalString = excelSheetFormat.convertIntToString(28);
        System.out.println("The string equivalent in excel format is "+finalString);
    }

}
