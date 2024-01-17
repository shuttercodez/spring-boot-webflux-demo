package net.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.sample.entity.Result;
import net.sample.entity.User;
import net.sample.entity.UserResponse;
import net.sample.service.UserService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{seed}")
    public Flux<UserResponse> getUsers(@PathVariable("seed") String seed) {
        Flux<Result> result = userService.getUserFromRemote(seed);

        Flux<UserResponse> response = result.map(r -> {
            User user = r.getResults().stream().findFirst().get();

            UserResponse tmp = new UserResponse();
            tmp.setGender(user.getGender());
            tmp.setEmail(user.getEmail());
            tmp.setFirstname(user.getName().getFirst());
            tmp.setLastname(user.getName().getLast());
            return tmp;
        });

        return response;
    }
}