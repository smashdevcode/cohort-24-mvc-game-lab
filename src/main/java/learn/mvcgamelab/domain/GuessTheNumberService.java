package learn.mvcgamelab.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GuessTheNumberService {
    // constants
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;

    private final int numberToGuess;
    private List<Integer> guesses = new ArrayList<>();

    private boolean isOver = false;

    public GuessTheNumberService() {
        Random random = new Random();
        numberToGuess = random.nextInt(MIN_NUMBER, MAX_NUMBER + 1);
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

    // rules


    // randomly generate the number to guess (hard code the range)

    // track the list of guesses

    // game status (in progress, complete)
    public String getGameStatus(){
        return String.format("Status: %s, guesses: %s", isOver ? "Game over" : "In progress",
                guesses.stream().map(Object::toString).collect(Collectors.joining("-")));
    }











}
