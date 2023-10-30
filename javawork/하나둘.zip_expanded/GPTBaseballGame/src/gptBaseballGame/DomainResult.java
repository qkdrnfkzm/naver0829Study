package gptBaseballGame;

public class DomainResult {
    private int balls;
    private int strikes;

    public DomainResult(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public boolean isGameWon() {
        // Implement logic to check if the game is won
    }

    public String getResultMessage() {
        // Generate and return the result message (e.g., "1볼 1스트라이크" or "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}
