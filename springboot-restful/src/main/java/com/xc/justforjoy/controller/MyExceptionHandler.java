package com.xc.justforjoy.controller;

import com.xc.justforjoy.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
@ControllerAdvice
public class MyExceptionHandler {
    //浏览器客户端返回的都是json数据，没有自适应效果
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handlerException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
        map.put("message","用户出错啦");
        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }
}
