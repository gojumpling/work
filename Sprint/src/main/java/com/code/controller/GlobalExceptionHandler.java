package com.code.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandler(Exception exception) {
        Map<String,Object> map = new HashMap<>();
        map.put("state",500);
        map.put("msg","出错!!");
        return map;
    }

}
