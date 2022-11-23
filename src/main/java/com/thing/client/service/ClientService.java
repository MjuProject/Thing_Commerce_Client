package com.thing.client.service;

import com.thing.client.domain.Client;
import com.thing.client.dto.ClientInfoDTO;
import com.thing.client.dto.LoginInfoDTO;
import com.thing.client.dto.ReviewResponseDTO;
import com.thing.client.dto.SignupRequestDTO;
import org.springframework.data.domain.Slice;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ClientService {

    public void checkId(String clientId);
    public void modifyClientNickname(int clientIndex, String nickName);
    public Slice<ReviewResponseDTO> getReviewByOwnerIndex(Integer itemId, Integer page);
    public ClientInfoDTO findById(Integer clientIndex);
    public LoginInfoDTO findByClientId(String clientId);
    public Client registryClient(SignupRequestDTO signupRequestDTO);
    public void modifyClientPhoto(Integer clientIndex, MultipartFile clientPhoto) throws IOException;

}
