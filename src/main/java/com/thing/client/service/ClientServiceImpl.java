package com.thing.client.service;

import com.thing.client.domain.Client;
import com.thing.client.dto.ClientInfoDTO;
import com.thing.client.dto.ReviewResponseDTO;
import com.thing.client.dto.SignupRequestDTO;
import com.thing.client.exception.ClientNotFoundException;
import com.thing.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;


    @Override
    public void modifyClientNickname(int clientIndex, String nickName) {

    }

    @Override
    public Slice<ReviewResponseDTO> getReviewByOwnerIndex(Integer itemId, Integer page) {
        return null;
    }

    @Override
    public ClientInfoDTO findById(Integer clientIndex) {
        Client client = clientRepository.findById(clientIndex).orElseThrow(ClientNotFoundException::new);
        ClientInfoDTO clientInfoDTO = ClientInfoDTO.from(client);
        // 신뢰점수 계산 로직 필요
        return clientInfoDTO;
    }

    @Override
    public Client registryClient(SignupRequestDTO signupRequestDTO) {
        return clientRepository.save(signupRequestDTO.toEntity());
    }

    @Override
    public void modifyClientPhoto(Integer clientIndex, MultipartFile clientPhoto) throws IOException {

    }
}
