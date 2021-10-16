package com.ignyte.epet.bff.client;

import com.ignyte.epet.bff.dto.ShopDto;
import reactor.core.publisher.Flux;

public interface ShopServiceClient {

    Flux<ShopDto> getAllShops();
}
