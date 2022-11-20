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

    @GetMapping(value = "/me/id-check")
    public APIResponseDTO<Object> checkId(){
        return null;
    }

    @GetMapping(value = "/me/items/{item-id}/review")
    public APIResponseDTO<Object> showMyItemReview(@PathVariable("item-id") Integer itemId){
        return null;
    }

    @PostMapping(value = "")
    public APIResponseDTO registryClient(@RequestBody SignupRequestDTO signupRequestDTO){
        clientService.registryClient(signupRequestDTO);
        return APIResponseDTO.success();
    }

    @PutMapping(value = "/{client-idx}/nickname")
    public APIResponseDTO<Object> updateClientNickName(@PathVariable("client-idx") Integer clientIdx){
        return null;
    }

    @PutMapping(value = "/me/client-photo")
    public APIResponseDTO<Object> updateClientPhoto(){
        return null;
    }

}
