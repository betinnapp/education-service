package com.betinnapp.educationservice.service;

import com.betinnapp.educationservice.model.Coin;
import com.betinnapp.educationservice.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CoinService {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private UserService userService;

    public void addCoin(UUID userId, int score) {

        Coin coin = coinRepository.findByUserId(userId);

        if (coin != null) {
            coin.setCoin(coin.getCoin() + score);
        } else {
            coin = new Coin();
            coin.setUserId(userId);
            coin.setCoin(score);
        }

        coinRepository.save(coin);
    }

    public Coin getCoinByToken(UUID token){
        UUID userId = userService.findUserIdByToken(token);
        return coinRepository.findByUserId(userId);
    }
}
