package lan.training.advanced.frontend;

import lan.training.advanced.base.Frontend;
import lan.training.advanced.mechanics.GameSession;
import lan.training.advanced.message.Address;

/**
 * Created by nik-lazer on 02.01.15.
 */
public class MsgReplicateGameSession extends MsgToFrontend {
	private GameSession gameSession;
	public MsgReplicateGameSession(Address from, Address to, GameSession gameSession) {
		super(from, to);
		this.gameSession = gameSession;
	}

	@Override
	public void exec(Frontend abonent) {
		abonent.replicateGameSession(gameSession);
	}
}
