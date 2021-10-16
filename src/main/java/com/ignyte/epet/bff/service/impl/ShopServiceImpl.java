package com.ignyte.epet.bff.service.impl;

import com.ignyte.epet.bff.client.ShopServiceClient;
import com.ignyte.epet.bff.dto.ShopDto;
import com.ignyte.epet.bff.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopServiceClient shopServiceClient;

    @Autowired
    public ShopServiceImpl(ShopServiceClient shopServiceClient) {
        this.shopServiceClient = shopServiceClient;
    }

    @Override
    public Flux<ShopDto> getAllShops() {
        return shopServiceClient.getAllShops();
    }
}
