package com.thing.client.repository;

import com.thing.client.domain.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    Client client;

    @BeforeEach
    public void setUp(){
        client = Client.builder()
                .email("test@test")
                .nickname("test")
                .build();
    }

    @Test
    public void findById_test(){
        // given
        Integer clientIndex = clientRepository.save(client).getClientIndex();
        String email = client.getEmail();

        // when
        Client findClient = clientRepository.findById(clientIndex).get();

        // then
        assertThat(findClient.getClientIndex()).isEqualTo(clientIndex);
        assertThat(findClient.getEmail()).isEqualTo(email);
    }

    @Test
    public void save_test(){
        // given
        String email = client.getEmail();

        // when
        Client saveClient = clientRepository.save(client);

        // then
        assertThat(email).isEqualTo(saveClient.getEmail());
    }

    @Test
    public void findByNickname_test(){
        // given
        String nickname = client.getNickname();
        Integer clientIndex = clientRepository.save(client).getClientIndex();

        // when
        Client findClient = clientRepository.findByNickname(nickname).get();

        // then
        assertThat(findClient.getClientIndex()).isEqualTo(clientIndex);
    }

    @Test
    public void dirty_checking_test(){
        // given
        String updateEmail = "test2@test";
        client = clientRepository.save(client);
        client.setEmail(updateEmail);

        // when
        Client updateClient = clientRepository.findById(client.getClientIndex()).get();

        // then
        assertThat(updateEmail).isEqualTo(updateClient.getEmail());
    }
}
