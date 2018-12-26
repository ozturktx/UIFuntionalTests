package com.utilities;

public class BrowserUtils {

    public static boolean verifyTextMatches(String first,String second){
    if(first.equals(second))
        return true;
    return false;

    }

    public static boolean verifyTextContains(String first,String second){
        if(first.contains(second))
            return true;
        return false;
    }
}
