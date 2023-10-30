package gptBaseballGame;

public final class View {
    public static void printGameIntro() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printUserPrompt() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public static void printGameResult(String result) {
        System.out.println(result);
    }

    public static void printPlayAgainPrompt() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
    }
}
