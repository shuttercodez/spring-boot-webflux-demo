package net.sample.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import net.sample.entity.Result;
import reactor.core.publisher.Flux;

@Service
public class ApiService {
    private final WebClient webClient;

    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://randomuser.me").build();
    }

    public Flux<Result> callExternalApi(String seed) {
      return webClient
                .get()
                .uri(builder -> builder.path("/api/1.0/").queryParam("seed", seed).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Result.class);
    }
}


