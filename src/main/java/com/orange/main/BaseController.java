package com.orange.main;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BaseController {
/* Transfer Object to ReponseObj, make Object to JSON correctly. */
    protected static ResponseEntity<ResponseObj> transResponseObj(Object obj){
        ResponseObj rtnObj = new ResponseObj();
        rtnObj.setCode(0000);
        rtnObj.setData(obj);

        return ResponseEntity.ok(rtnObj);
    }

    protected static ResponseEntity<ResponseObj> checkError(int code, String message, String extra){
        ResponseObj rtnObj = new ResponseObj();
        rtnObj.setCode(code);
        rtnObj.setExtra(extra);
        rtnObj.setMessage(message);

        return ResponseEntity.badRequest().body(rtnObj);
    }
}
