package com.pazz.springboot.exception.handler.controller;

import com.pazz.springboot.exception.handler.exception.BusinessException;
import com.pazz.springboot.exception.handler.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/11/22 14:15
 * @description:
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController extends AbstractController {

    @ResponseBody
    @GetMapping("/band")
    public Response band(String str){
        if(str.equals("IllegalArgument")){
            throw new IllegalArgumentException("IllegalArgumentException...");
        }else if(str.equals("Business")){
            throw new BusinessException("BusinessException...", "detailMessage...");
        }
        return returnSuccess(null);
    }

}
