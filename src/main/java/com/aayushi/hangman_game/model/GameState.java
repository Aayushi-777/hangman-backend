package com.aayushi.hangman_game.model;

import java.util.HashSet;
import java.util.Set;

public class GameState {
    public String word;
    public Set<Character> guessed = new HashSet<>();
    public int attempts;
    public int score;
}
