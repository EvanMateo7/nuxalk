package com.mysql.mysql.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class RedirectOnResourceNotFoundException {

    @ExceptionHandler(NoHandlerFoundException.class)
    public Object handleStaticResourceNotFound(NoHandlerFoundException ex, HttpServletRequest req, RedirectAttributes redirectAttributes) {
        if (req.getRequestURI().startsWith("/api")) {
          return this.getApiResourceNotFoundBody(ex, req);
        }
        else {
          redirectAttributes.addFlashAttribute("errorMessage", "My Custom error message");
          return "redirect:/main";
        }
    }

    private ResponseEntity<String> getApiResourceNotFoundBody(NoHandlerFoundException ex, HttpServletRequest req) {
        return new ResponseEntity<>("API not found!", HttpStatus.NOT_FOUND);
    }
}