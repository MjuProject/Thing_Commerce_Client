package com.thing.client.advice;

import com.thing.client.dto.APIResponseDTO;
import com.thing.client.exception.ClientExceptionType;
import com.thing.client.exception.ClientNotFoundException;
import com.thing.client.exception.ExistNicknameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ClientExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO unknown(Exception e){
        log.error("unknown exception", e);
        ClientExceptionType exceptionType = ClientExceptionType.UNKNOWN;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO clientNotFoundException(){
        ClientExceptionType exceptionType = ClientExceptionType.CLIENT_NOT_FOUNT;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

    @ExceptionHandler(ExistNicknameException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO existNicknameException(){
        ClientExceptionType exceptionType = ClientExceptionType.EXIST_NICKNAME;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

}
