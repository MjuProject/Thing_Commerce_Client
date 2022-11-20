package com.thing.client.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ClientExceptionType {

    UNKNOWN(-9999, "알 수 없는 오류가 발생하였습니다."),
    CLIENT_NOT_FOUNT(-1000, "해당 사용자가 존재하지 않습니다.");

    private final int code;
    private final String message;

}
