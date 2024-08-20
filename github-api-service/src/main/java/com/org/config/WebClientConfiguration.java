package com.org.config;

import com.org.data.Repository_Info_Data;

import com.org.exceptions.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class WebClientConfiguration {

    private static final  String user_url="https://api.github.com/search/repositories?q=user:raju0510";
    WebClient webClient = WebClient.create(user_url);
    public Mono<Repository_Info_Data> webClientConsumer() {
        Mono<Repository_Info_Data> monoData = webClient
                .get()
                .uri(user_url)
                .retrieve()
                .bodyToMono(Repository_Info_Data.class)
                .onErrorMap(
                        CustomException.class , ex ->
                        new CustomException("Exception occured while calling github api"));
        return monoData;
    }
}
