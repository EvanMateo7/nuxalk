package com.mysql.mysql.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppErrorController implements ErrorController  {
 
    @RequestMapping("/error")
    public String renderErrorPage(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        model.addAttribute("message", "Error");
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("message", "404 Error");
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("message", "500 Error");
            }
        }
        
        return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}