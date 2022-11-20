package com.thing.client.dto;

import com.thing.client.domain.Client;
import com.thing.client.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignupRequestDTO {

    private String clientId;
    private String clientName;
    private String password;
    private String nickname;
    private String email;
    private Date birthdate;
    private String phoneNumber;

    public Client toEntity() {
        return Client.builder()
                .clientId(clientId)
                .clientName(clientName)
                .password(password)
                .nickname(nickname)
                .email(email)
                .birthdate(birthdate)
                .role(Role.USER)
                .phoneNumber(phoneNumber)
                .build();
    }
}
