package lan.training.advanced.frontend;

/**
 * User data for {@link lan.training.advanced.frontend.FrontendImpl}
 * @author nik-lazer  29.12.2014   12:13
 */
public class UserSession {
	private int sessionId;
	private String userName = "";
	private int userId = 0;
	private boolean isTakePart;
	private long timeToFinish;
	private int clickedByUser;
	private String enemyName;
	private int getClickedByEnemy;
	private int winner;

	public boolean isGameFinished() {
		return isGameFinished;
	}

	public void setGameFinished(boolean isGameFinished) {
		this.isGameFinished = isGameFinished;
	}

	private boolean isGameFinished;

	public UserSession(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getTimeToFinish() {
		return timeToFinish;
	}

	public void setTimeToFinish(long timeToFinish) {
		this.timeToFinish = timeToFinish;
	}

	public int getClickedByUser() {
		return clickedByUser;
	}

	public void setClickedByUser(int clickedByUser) {
		this.clickedByUser = clickedByUser;
	}

	public String getEnemyName() {
		return enemyName;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}

	public int getGetClickedByEnemy() {
		return getClickedByEnemy;
	}

	public void setGetClickedByEnemy(int getClickedByEnemy) {
		this.getClickedByEnemy = getClickedByEnemy;
	}

	public boolean isTakePart() {
		return isTakePart;
	}

	public void setTakePart(boolean isTakePart) {
		this.isTakePart = isTakePart;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public String getWinner() {
		if (winner == 0) {
			return "Friendship";
		}
		if (winner == userId) {
			return userName;
		}
		return enemyName;
	}
}
