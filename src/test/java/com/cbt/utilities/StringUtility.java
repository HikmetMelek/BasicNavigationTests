package com.cbt.utilities;

public class StringUtility {

    public static void verifyEquals(String expected, String actual){
        System.out.println("expectedResult = " + expected);
        System.out.println("actualResult = " + actual);

        if(expected.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}
