package com.thing.client.service;

import com.thing.client.domain.Client;
import com.thing.client.dto.ClientInfoDTO;
import com.thing.client.dto.SignupRequestDTO;
import com.thing.client.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    private Client client;

    @BeforeEach
    public void setUp(){
        client = Client.builder()
                .clientIndex(1)
                .clientId("test")
                .email("test@test")
                .nickname("test")
                .build();
    }

    @Test
    public void modifyClientNickname_test(){
        // given
        Integer clientIndex = client.getClientIndex();
        String updateNickName = "test2";

        given(clientRepository.findById(any())).willReturn(Optional.ofNullable(client));

        // when
        clientService.modifyClientNickname(clientIndex, updateNickName);

        // then
        assertThat(updateNickName).isEqualTo(client.getNickname());
    }

    @Test
    public void findById_test(){
        // given
        Integer clientIndex = client.getClientIndex();
        String email = client.getEmail();

        given(clientRepository.findById(any())).willReturn(Optional.ofNullable(client));

        // when
        ClientInfoDTO clientInfoDTO = clientService.findById(clientIndex);

        // then
        assertThat(clientIndex).isEqualTo(clientInfoDTO.getClientIndex());
        assertThat(email).isEqualTo(clientInfoDTO.getEmail());
    }

    @Test
    public void registryClient_test(){
        // given
        SignupRequestDTO signupRequestDTO = SignupRequestDTO
                .builder()
                .clientId(client.getClientId())
                .email(client.getEmail())
                .build();

        String clientId = signupRequestDTO.getClientId();
        String email = signupRequestDTO.getEmail();

        given(clientRepository.save(any())).willReturn(client);

        // when
        Client saveClient = clientService.registryClient(signupRequestDTO);

        // then
        assertThat(clientId).isEqualTo(saveClient.getClientId());
        assertThat(email).isEqualTo(saveClient.getEmail());
    }

}
