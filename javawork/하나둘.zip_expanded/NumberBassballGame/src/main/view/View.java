package main.view;

import main.util.GameMessage;

public class View {

	// 시작메세지
	public static void printGameIntro() {
		System.out.println(GameMessage.START_MESSAGE);
	}
	// 숫자 입력
	public static void printUserInput() {
		System.out.print(GameMessage.INPUT_MESSAGE);
	}
	// 재시작
	public static void printPlayAgain() {
		System.out.print(GameMessage.RESTART_MESSAGE);
	}

}
