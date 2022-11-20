package com.thing.client.exception;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(){
        super();
    }

    public ClientNotFoundException(String message){
        super(message);
    }

    public ClientNotFoundException(String message, Throwable th){
        super(message, th);
    }

}
