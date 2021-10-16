package com.ignyte.epet.bff.service;

import com.ignyte.epet.bff.dto.ShopDto;
import reactor.core.publisher.Flux;

public interface ShopService {

    /**
     * Get All Shops
     *
     * @return
     */
    Flux<ShopDto> getAllShops();
}
