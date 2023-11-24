package com.orange.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BaseController {
/* Transfer Object to ReponseObj, make Object to JSON correctly. */
    protected static ResponseObj transResponseObj(Object obj){
        ResponseObj rtnObj = new ResponseObj();
        rtnObj.setCode("200");
        rtnObj.setData(obj);

        return rtnObj;
    }
}
