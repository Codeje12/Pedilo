package com.pedilo.clic.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@ControllerAdvice
public class GlobalExceptionHandler {
 //   @ExceptionHandler(MultipartException.class)
    public String handleMultipart(MultipartException e) {
        System.out.println("message" + e.getCause().getMessage());

        return "redirect:/producto/index";
    }
}
