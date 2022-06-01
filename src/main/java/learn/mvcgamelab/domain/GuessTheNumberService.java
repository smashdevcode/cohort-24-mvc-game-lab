package learn.mvcgamelab.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GuessTheNumberService {
    // constants
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;

    private final int numberToGuess;
    private List<Integer> guesses = new ArrayList<>();

    public GuessTheNumberService() {
        Random random = new Random();
        numberToGuess = random.nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }




    // rules


    // randomly generate the number to guess (hard code the range)

    // track the list of guesses

    // game status (in progress, complete)


    // make a guess

    // validation... out of range, too low, too high, not a number, duplicate guess









}
