package learn.mvcgamelab.controllers;

import learn.mvcgamelab.domain.GuessTheNumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuessTheNumberController {
    private final GuessTheNumberService service;

    public GuessTheNumberController(GuessTheNumberService service) {
        this.service = service;
    }

    @GetMapping("/api/guessthenumber")
    public void getGame() {
        // TODO what do we want to return?
    }
}
