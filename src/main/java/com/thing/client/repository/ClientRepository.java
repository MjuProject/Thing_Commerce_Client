package com.thing.client.repository;

import com.thing.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    public Optional<Client> findByClientId(@Param("clientId") String clientId);
    public Client findByPhoneNumber(String phone_number);
    public Optional<Client> findByNickname(String nickname);

}
