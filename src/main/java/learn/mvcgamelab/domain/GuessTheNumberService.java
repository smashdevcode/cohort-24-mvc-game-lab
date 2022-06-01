package learn.mvcgamelab.domain;

import org.springframework.stereotype.Service;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GuessTheNumberService {
    // constants
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;

    private int numberToGuess;
    private List<Integer> guesses = new ArrayList<>();
    private boolean isOver = false;

    public GuessTheNumberService() {
        generateNumberToGuess();
    }

    private void generateNumberToGuess() {
        Random random = new Random();
        numberToGuess = random.nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    // resets the game
    public void reset() {
        generateNumberToGuess();
        guesses.clear();
        isOver = false;
    }

    // make a guess
    public String makeAGuess(int guess) {
        // validation... out of range, too low, too high, not a number, duplicate guess
        if(isOver){
            return "Game is over";
        }else if (guess < MIN_NUMBER || guess > MAX_NUMBER){
            //Out of bounds
            return "Guess is out of range";
        }else if(guesses.contains(guess)){
            // Guess was already made
            return "Duplicate guess";
        }else if (guess < numberToGuess){
            guesses.add(guess);
            return "Guess is too low";
        }else if (guess > numberToGuess) {
            guesses.add(guess);
            return "Guess is too high";
        }
        //If the other conditions were not meet the guess is correct
        isOver = true;
        return "Correct!";
    }

    // game status (in progress, complete)
    public String getGameStatus(){
        String gameStatus = isOver ? "Game over" : "In progress";
        String previousGuesses = guesses.stream().map(Object::toString).collect(Collectors.joining("-"));
        return String.format("Status: %s, guesses: %s", gameStatus,
                previousGuesses.isEmpty() ? "No guesses were made yet" : previousGuesses);
    }
}
