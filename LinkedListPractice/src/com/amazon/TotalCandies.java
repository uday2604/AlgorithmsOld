package com.amazon;

/**
 * Created by udaypersonal on 9/2/16.
 */
public class TotalCandies {


    // Paypal - Telephonic
    public int totalNumberOfCandies (int inputCandies, int wrapperCount) {

        int outputCandies =0;

        if(inputCandies<wrapperCount)
            return inputCandies;

        else {


            while(inputCandies>1) {

                inputCandies=inputCandies-wrapperCount;
                outputCandies+=wrapperCount;
                inputCandies++;

            }

            if(inputCandies==1)
                outputCandies++;


        }

        return outputCandies;

    }


    public static void main(String[] args) {

        TotalCandies totalCandies = new TotalCandies();
        int outputCandies = totalCandies.totalNumberOfCandies(7, 2);
        System.out.println("The total number of candies is "+outputCandies);




    }

}
