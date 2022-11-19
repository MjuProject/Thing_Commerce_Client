package com.thing.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponseDTO<T> {
    private final boolean success;
    private final int code;
    private final String message;
    private T data;

    public static <T> APIResponseDTO<T> success(T data){
        return new APIResponseDTO(true, 0, "성공하였습니다.", data);
    }

    public static <T> APIResponseDTO<T> fail(int code, String message){
        return new APIResponseDTO(false, code, message);
    }
}
