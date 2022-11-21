package com.thing.client.exception;

public class ExistIdException extends RuntimeException{

    public ExistIdException(){
        super();
    }

    public ExistIdException(String message){
        super(message);
    }

    public ExistIdException(String message, Throwable th){
        super(message, th);
    }
}
