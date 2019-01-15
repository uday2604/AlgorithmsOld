package com.company;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Uday on 2016-04-11.
 */
public class QuickSortTest {

    @BeforeClass
    public void setUp() {


        int[] inputArray1 = new int[6];
        Random generator = new Random();

        for(int i=0;i<inputArray1.length;i++) {
            inputArray1[i]=generator.nextInt(20);
        }
    }

    @Test
    public void testSimpleArray() {

        QuickSort quickSort = new QuickSort();
        int[] inputArray={5,9,3,7,2,6};
        int[] expectedArray={2,3,5,6,7,9};
        Assert.assertEquals(quickSort.quickSortAndPartition(inputArray, 0, (inputArray.length-1)), expectedArray);

    }


}
