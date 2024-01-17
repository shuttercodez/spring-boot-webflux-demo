package net.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sample.entity.*;
import reactor.core.publisher.Flux;

@Service
public class UserService {

    @Autowired
    private ApiService apiService;

    public Flux<Result> getUserFromRemote(String seed) {
        return apiService.callExternalApi(seed);
    }
}
