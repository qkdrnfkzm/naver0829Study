package gptBaseballGame;

import java.util.Scanner;

public class Controller {
    private final Service gameService;
    private final Scanner scanner;

    public Controller() {
        gameService = new Service();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            playGame();
            if (!playAgain()) {
                break;
            }
        }
    }

    private void playGame() {
        gameService.startNewGame();
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = scanner.next();
            String result = gameService.checkGuess(input);
            System.out.println(result);

            if (gameService.isGameFinished()) {
                break;
            }
        }
    }

    private boolean playAgain() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        int choice = scanner.nextInt();
        return choice == 1;
    }
}

