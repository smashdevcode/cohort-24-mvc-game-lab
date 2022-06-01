package learn.mvcgamelab.controllers;

import learn.mvcgamelab.domain.GuessTheNumberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guessthenumber") // path prefix
public class GuessTheNumberController {
    private final GuessTheNumberService service;

    public GuessTheNumberController(GuessTheNumberService service) {
        this.service = service;
    }

    @GetMapping
    public String getGame() {
        return service.getGameStatus();
    }

    @PutMapping("/{guess}")
    public String makeAGuess(@PathVariable int guess){
        return service.makeAGuess(guess);
    }

    @PostMapping
    public void resetTheGame() {
        service.reset();
    }
}
