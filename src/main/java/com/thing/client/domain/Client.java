package com.thing.client.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="client")
public class Client {

    @Id
    @Column(name = "client_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientIndex;
    @Column(name = "client_id")
    private String clientId;
    @Column
    private String password;
    @Column
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column
    private Date birthdate;
    @Column(name = "client_name")
    private String clientName;
    @Column
    private String nickname;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    @Column(name = "client_photo")
    private String clientPhoto;

}
