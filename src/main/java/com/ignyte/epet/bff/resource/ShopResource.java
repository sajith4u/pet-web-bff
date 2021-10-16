package com.ignyte.epet.bff.resource;

import com.ignyte.epet.bff.dto.ShopDto;
import com.ignyte.epet.bff.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ShopResource {

    private final ShopService shopService;

    @Autowired
    public ShopResource(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping(value = "/shop", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ShopDto> getAllShops() {
        return shopService.getAllShops();
    }
}
