package com.thing.client.controller;

import com.thing.client.dto.APIResponseDTO;
import com.thing.client.dto.SignupRequestDTO;
import com.thing.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping(value = "/{client-idx}")
    public APIResponseDTO showClient(@PathVariable("client-idx") Integer clientIdx){
        return APIResponseDTO.success(clientService.findById(clientIdx));
    }

    @GetMapping(value = "/id/{client-id}")
    public APIResponseDTO showClientById(@PathVariable("client-id") String clientId){
        return APIResponseDTO.success(clientService.findByClientId(clientId));
    }

    @GetMapping(value = "/id-check")
    public APIResponseDTO checkId(@RequestParam String clientId){
        clientService.checkId(clientId);
        return APIResponseDTO.success();
    }

    @GetMapping(value = "/nickname-check")
    public APIResponseDTO checkNickname(@RequestParam String nickname){
        clientService.checkNickname(nickname);
        return APIResponseDTO.success();
    }

    @GetMapping(value = "/me/items/{item-id}/review")
    public APIResponseDTO showMyItemReview(@PathVariable("item-id") Integer itemId){
        return null;
    }

    @PostMapping(value = "")
    public APIResponseDTO registryClient(@RequestBody SignupRequestDTO signupRequestDTO){
        clientService.registryClient(signupRequestDTO);
        return APIResponseDTO.success();
    }

    @PutMapping(value = "/{client-idx}/nickname")
    public APIResponseDTO updateClientNickName(@PathVariable("client-idx") Integer clientIdx, @RequestParam("nickname") String nickname){
        clientService.modifyClientNickname(clientIdx, nickname);
        return APIResponseDTO.success();
    }

    @PutMapping(value = "/me/client-photo")
    public APIResponseDTO updateClientPhoto(){
        return null;
    }

}
