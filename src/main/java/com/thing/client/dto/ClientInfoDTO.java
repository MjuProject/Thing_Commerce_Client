package com.thing.client.dto;

import com.thing.client.domain.Client;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClientInfoDTO {

    private Integer clientIndex;
    private String clientId;
    private String email;
    private String phoneNumber;
    private Date birthdate;
    private String clientName;
    private String nickname;
    private String clientPhoto;
    private Float trustPoint;

    public static ClientInfoDTO from(Client client){
        return ClientInfoDTO.builder()
                .clientIndex(client.getClientIndex())
                .clientId(client.getClientId())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .birthdate(client.getBirthdate())
                .clientName(client.getClientName())
                .nickname(client.getNickname())
                .clientPhoto("/clients/photos/" + client.getClientIndex())
                .build();
    }

    public void calcTrustPoint(){
        
    }

}
