package com.aayushi.hangman_game.service;

import com.aayushi.hangman_game.model.GameState;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {
    private GameState game;

    private Map<String, String[]> categories = Map.of(
        "Animals", new String[]{"elephant", "tiger", "dog"},
        "Fruits", new String[]{"apple", "banana", "mango"},
        "Countries", new String[]{"india", "canada", "france"}
    );

    public GameState startGame(String category, String difficulty) {
        game = new GameState();
    
        String[] words = categories.get(category);
        game.word = words[new Random().nextInt(words.length)];
        game.maxAttempts = difficulty.equals("Hard") ? 5 :
                           difficulty.equals("Medium") ? 7 : 10;
        game.attempts = game.maxAttempts;
        game.score = 0;
        return game;
    }
    

    public GameState guess(char letter) {
        game.guessed.add(letter);
        if (!game.word.contains(String.valueOf(letter))) {
            game.attempts--;
        } else {
            game.score += 10;
        }
        return game;
    }
}
