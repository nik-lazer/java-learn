package lan.training.advanced.frontend;

/**
 * User data for {@link lan.training.advanced.frontend.FrontendImpl}
 * @author nik-lazer  29.12.2014   12:13
 */
public class UserSession {
	private int sessionId;
	private String userName = "";
	private int userId = 0;

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
}
