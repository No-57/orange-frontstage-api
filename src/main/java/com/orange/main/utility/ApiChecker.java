package com.orange.main.utility;

import org.springframework.data.domain.Pageable;

import io.micrometer.common.util.StringUtils;

public class ApiChecker {
    public static String PageableChecker(Pageable page){
        String error = "";
        if(StringUtils.isNotBlank(error) && page.getPageNumber() < 1){
            error = "page number must >= 1 !!!";
        }

        if(StringUtils.isNotBlank(error) && page.getPageSize() == 0){
            error = "page size must > 0 !!!";
        }

        return error;
    }
}
