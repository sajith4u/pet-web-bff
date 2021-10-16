package com.ignyte.epet.bff.client.impl;

import com.ignyte.epet.bff.client.ShopServiceClient;
import com.ignyte.epet.bff.dto.ShopDto;
import com.ignyte.epet.bff.exception.ErrorMessage;
import com.ignyte.epet.bff.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShopServiceClientImpl implements ShopServiceClient {

    @Autowired
    private ReactorLoadBalancerExchangeFilterFunction lbFunction;

    @Bean
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Override
    public Flux<ShopDto> getAllShops() {
        return loadBalancedWebClientBuilder().filter(lbFunction).build().get()
                .uri("http://shopservice/myshops")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve().onStatus(HttpStatus::isError, response -> {
                    Mono<ErrorMessage> errorMessageMono = response.bodyToMono(ErrorMessage.class);
                    return errorMessageMono.flatMap(c -> Mono.error(new GeneralException(c)));
                })
                .bodyToFlux(ShopDto.class);
    }
}
