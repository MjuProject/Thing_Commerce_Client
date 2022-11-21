package com.thing.client.exception;

public class ExistNicknameException extends RuntimeException{

    public ExistNicknameException(){
        super();
    }

    public ExistNicknameException(String message){
        super(message);
    }

    public ExistNicknameException(String message, Throwable th){
        super(message, th);
    }
}
