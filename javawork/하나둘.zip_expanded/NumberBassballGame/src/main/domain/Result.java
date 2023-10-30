package main.domain;

import main.util.GameMessage;

public class Result {

	private int balls;
	private int strikes;

	public Result() {

	}

	public Result(int balls, int strikes) {
		super();
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
		return getStrikes() == 3;
	}

	public String getResultMessage() {
		if (getStrikes() > 0 && getBalls() > 0) {
			return getStrikes() + GameMessage.GAME_STRIKE + " " + getBalls() + GameMessage.GAME_BALL;
		}
		if (getStrikes() > 0 && getBalls() == 0) {
			return getStrikes() + GameMessage.GAME_STRIKE;
		}
		if (getStrikes() == 0 && getBalls() > 0) {
			return getBalls() + GameMessage.GAME_BALL;
		}
		return GameMessage.GAME_NOTHING;
	}

}
