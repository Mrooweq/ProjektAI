package com.projekt.ai.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Lenovo on 2017-11-13.
 */

@ControllerAdvice
@Slf4j
public class RuntimeExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public void handleConflict(RuntimeException runtimeException) {
        log.error(runtimeException.toString());

        for (StackTraceElement stackTraceElement : runtimeException.getStackTrace()) {
            log.error(stackTraceElement.toString());

            runtimeException.printStackTrace();
        }

        throw runtimeException;
    }
}
