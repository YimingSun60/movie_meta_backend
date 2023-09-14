package com.ysun60.moviemeta.subpackages.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Error error = (Error) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Integer statusCode = null;
        String exceptionMessage = null;
        String errorMessage = null;
        if (status != null) {
             statusCode = Integer.valueOf(status.toString());
            // You can return a custom response based on the status code
        }
        if (exception != null) {
            exceptionMessage = exception.getMessage();
        }
        if (error != null) {
            errorMessage = error.getMessage();
        }

        return new ResponseEntity<>("status: " + statusCode.toString() + " exception: " + exceptionMessage + " error: " + errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
