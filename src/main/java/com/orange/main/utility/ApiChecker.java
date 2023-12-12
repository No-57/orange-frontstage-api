package com.orange.main.utility;

public class ApiChecker {
    public static String PageableChecker(int page, int size){
        String error = "";
        if(page < 1){
            error = error+"page number must >= 1 !!!; ";
        }

        if(size == 0){
            error = error+"page size must > 0 !!!; ";
        }

        return error;
    }
}
