package com.thing.client.service;

import com.thing.client.domain.Client;
import com.thing.client.dto.ClientInfoDTO;
import com.thing.client.dto.LoginInfoDTO;
import com.thing.client.dto.ReviewResponseDTO;
import com.thing.client.dto.SignupRequestDTO;
import com.thing.client.exception.*;
import com.thing.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    @Value("${image.path.client}")
    private String IMAGE_ROOT_PATH;

    @Override
    public void checkId(String clientId) {
        if(clientId == null || clientId.isEmpty() || clientId.isBlank())
            throw new InputNullException();
        if(clientRepository.findByClientId(clientId).isPresent())
            throw new ExistIdException();
    }

    @Override
    public void checkNickname(String nickname) {
        if(nickname == null || nickname.isEmpty() || nickname.isBlank())
            throw new InputNullException();
        if(clientRepository.findByNickname(nickname).isPresent())
            throw new ExistNicknameException();
    }

    @Transactional
    @Override
    public void modifyClientNickname(int clientIndex, String nickName) {
        Client client = clientRepository.findById(clientIndex).orElseThrow(ClientNotFoundException::new);
        if(clientRepository.findByNickname(nickName).isPresent())
            throw new ExistNicknameException();
        client.setNickname(nickName);
    }

    @Override
    public Slice<ReviewResponseDTO> getReviewByOwnerIndex(Integer itemId, Integer page) {
        return null;
    }

    @Override
    public ClientInfoDTO findById(Integer clientIndex) {
        Client client = clientRepository.findById(clientIndex).orElseThrow(ClientNotFoundException::new);
        ClientInfoDTO clientInfoDTO = ClientInfoDTO.from(client);
        // ???????????? ?????? ?????? ??????
        return clientInfoDTO;
    }

    @Override
    public LoginInfoDTO findByClientId(String clientId) {
        Client client = clientRepository.findByClientId(clientId).orElseThrow(ClientNotFoundException::new);
        return LoginInfoDTO.from(client);
    }

    @Transactional
    @Override
    public Client registryClient(SignupRequestDTO signupRequestDTO) {
        return clientRepository.save(signupRequestDTO.toEntity());
    }

    @Transactional
    @Override
    public void modifyClientPhoto(Integer clientIndex, MultipartFile clientPhoto) {
        deletePhotos(clientIndex);
        savePhotos(clientIndex, clientPhoto);
    }

    @Override
    public String getClientPhotoPath(Integer clientIdx) {
        return clientRepository.findById(clientIdx).orElseThrow(ClientNotFoundException::new)
                .getClientPhoto();
    }

    private void savePhotos(Integer clientIndex, MultipartFile imageFile) {
        Client client = clientRepository.findById(clientIndex).orElseThrow(ClientNotFoundException::new);

        // ???????????? ??? ????????? ????????? ??????
        if (!imageFile.isEmpty()) {
            // ???????????? ???????????? ?????? ????????? ?????? ?????? ?????? ??????
            // ?????? ????????? File.separator ??????
            // ????????? ????????? ?????? ?????? ??????
            String path = File.separator + clientIndex;
            File file = new File(IMAGE_ROOT_PATH + path);

            // ??????????????? ???????????? ?????? ??????
            if (!file.exists()) {
                boolean wasSuccessful = file.mkdirs();

                // ???????????? ????????? ???????????? ??????
                if (!wasSuccessful){
                    log.error("???????????? ?????? ??????");
                    throw new PhotoSaveFailException();
                }
            }

            try{
                int position = imageFile.getOriginalFilename().lastIndexOf(".");
                String originalFileExtension = imageFile.getOriginalFilename().substring(position);

                // ??????????????? ???????????? ?????? ?????? ?????? x
                if (ObjectUtils.isEmpty(originalFileExtension)) {
                    throw new PhotoSaveFailException();
                }

                String fileName = UUID.randomUUID() + originalFileExtension;
                client.setClientPhoto(IMAGE_ROOT_PATH + path + File.separator + fileName);

                // ????????? ??? ?????? ???????????? ????????? ????????? ??????
                file = new File(client.getClientPhoto());
                imageFile.transferTo(file);

                // ?????? ?????? ??????(??????, ??????)
                file.setWritable(true);
                file.setReadable(true);
            }catch (IOException e){
                e.printStackTrace();
                throw new PhotoSaveFailException();
            }
        }
    }

    private void deletePhotos(Integer clientIndex){
        String path = IMAGE_ROOT_PATH + File.separator + clientIndex;
        File dir = new File(path);
        if(dir.exists()){
            File[] deleteList = dir.listFiles();

            for (int j = 0; j < deleteList.length; j++) {
                deleteList[j].delete();
            }

            if(deleteList.length == 0 && dir.isDirectory()){
                dir.delete();
            }
        }
    }
}
