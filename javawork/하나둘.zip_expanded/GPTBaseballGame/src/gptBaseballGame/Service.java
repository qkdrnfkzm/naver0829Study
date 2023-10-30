package gptBaseballGame;

import java.util.Random;

public class Service {
    private final String targetNumber;
    private int tries;
    private boolean gameFinished;

    public Service() {
        targetNumber = generateRandomNumber();
        tries = 0;
        gameFinished = false;
    }

    public void startNewGame() {
        targetNumber = generateRandomNumber();
        tries = 0;
        gameFinished = false;
    }

    public String checkGuess(String guess) {
        // Implement the logic to check the guess against the target number
        // Return the result as a string (e.g., "1볼 1스트라이크" or "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        // Update gameFinished accordingly
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    private String generateRandomNumber() {
        // Implement logic to generate a random 3-digit number as a string
    }
}

