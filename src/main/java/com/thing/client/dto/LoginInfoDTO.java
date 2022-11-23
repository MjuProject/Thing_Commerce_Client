package com.thing.client.dto;

import com.thing.client.domain.Client;
import com.thing.client.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginInfoDTO {
    private Integer clientIndex;
    private String clientId;
    private String password;
    private Role role;

    public static LoginInfoDTO from(Client client){
        return new LoginInfoDTO(
                client.getClientIndex(),
                client.getClientId(),
                client.getPassword(),
                client.getRole()
        );
    }
}
