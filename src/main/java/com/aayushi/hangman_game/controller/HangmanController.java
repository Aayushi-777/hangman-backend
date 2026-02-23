package com.aayushi.hangman_game.controller;

import com.aayushi.hangman_game.model.GameState;
import com.aayushi.hangman_game.service.GameService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HangmanController {

    private final GameService service;

    public HangmanController(GameService service) {
        this.service = service;
    }

    // ✅ Root URL will now work
    @GetMapping("/")
    public String home() {
        return "Hangman Backend is Live 🚀";
    }

    // ✅ Start game endpoint
    @PostMapping("/start")
    public GameState start(@RequestParam String category,
                           @RequestParam String difficulty) {
        return service.startGame(category, difficulty);
    }

    // ✅ Guess endpoint
    @PostMapping("/guess/{letter}")
    public GameState guess(@PathVariable char letter) {
        return service.guess(letter);
    }
}
