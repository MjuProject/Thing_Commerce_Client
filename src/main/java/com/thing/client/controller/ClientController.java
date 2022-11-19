package com.thing.client.controller;

import com.thing.client.dto.APIResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clients")
public class ClientController {

    @GetMapping(value = "/{client-idx}")
    public APIResponseDTO<Object> showClient(@PathVariable("client-idx") Integer clientIdx){
        return null;
    }

    @GetMapping(value = "/me/id-check")
    public APIResponseDTO<Object> checkId(){
        return null;
    }

    @GetMapping(value = "/me/items/{item-id}/review")
    public APIResponseDTO<Object> showMyItemReview(@PathVariable("item-id") Integer itemId){
        return null;
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