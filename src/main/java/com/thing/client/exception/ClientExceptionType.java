package com.thing.client.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ClientExceptionType {

    UNKNOWN(-9999, "알 수 없는 오류가 발생하였습니다."),
    CLIENT_NOT_FOUNT(-1000, "해당 사용자가 존재하지 않습니다."),
    EXIST_NICKNAME(-1001, "현재 존재하는 닉네임입니다."),
    EXIST_ID(-1002, "이미 존재하는 아이디입니다."),
    INPUT_NULL(-1003, "입력하지 않은 값이 있습니다."),
    PHOTO_SAVE_FAIL(-1004, "사진 저장에 실패하였습니다.");

    private final int code;
    private final String message;

}
