package lan.training.advanced.mechanics;

import java.util.Date;

/**
 * Game session object
 * Created by nik-lazer on 30.12.14.
 */
public class GameSession {
	public static long DURATION = 60000;
	private int userId1;
	private int clickCount1 = 0;
	private int userId2;
	private int clickCount2 = 0;
	private Date startTime;
	private GameState gameState = GameState.STARTED;

	public GameSession(int userId1, int userId2) {
		this.userId1 = userId1;
		this.userId2 = userId2;
		startTime = new Date();
	}

	public int getUserId1() {
		return userId1;
	}

	public int getUserId2() {
		return userId2;
	}

	public Date getStartTime() {
		return startTime;
	}

	public int getClickCount1() {
		return clickCount1;
	}

	public void incrementClickCount1() {
		clickCount1++;
	}

	public int getClickCount2() {
		return clickCount2;
	}

	public void incrementClickCount2() {
		clickCount2++;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void stop() {
		gameState = GameState.FINISHED;
	}

	public int getWinner() {
		if (!isFinished()) {
			return -1;
		}
		if (getClickCount1() == getClickCount2()) {
			return 0;
		}
		return (clickCount1>clickCount2?userId1:userId2);
	}

	public boolean isFinished() {
		return getGameState().equals(GameState.FINISHED);
	}
}
