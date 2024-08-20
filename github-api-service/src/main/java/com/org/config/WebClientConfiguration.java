package com.org.config;

import com.org.data.Repository_Info_Data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class WebClientConfiguration {

    private static final  String user_url="https://api.github.com/search/repositories?q=user:raju0510";
    public Mono<Repository_Info_Data> webClientConsumer() {
        Mono<Repository_Info_Data> monoData = WebClient.create()
                .get()
                .uri(user_url)
                .retrieve()
                .bodyToMono(Repository_Info_Data.class);
        //log.info("Response from the api " + monoData.block());
        return monoData;
    }
}
