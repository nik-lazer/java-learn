package lan.training.swing.dialog;

/**
 * Created by nik-lazer on 04.11.14.
 */
public enum DialogCommand {
	DEFAULT_MESSAGE_COMMAND("default"),

	YES_NO_COMMAND("yesno"),
	YEAH_NAH_COMMAND("yeahnah"),
	YNC_COMMAND("ync"),

	PICK_ONE_COMMAND("pickone"),
	TEXT_ENTERED_COMMAND("textfield"),
	NON_AUTO_COMMAND("nonautooption"),
	CUSTOM_OPTION_COMMAND("customoption"),
	NON_MODAL_COMMAND("nonmodal"),

	PLAIN_COMMAND("plain"),
	INFO_COMMAND("info"),
	QUESTION_COMMAND("question"),
	ERROR_COMMAND("error"),
	WARNING_COMMAND("warning"),
	CUSTOM_COMMAND("custom");

	private String command;

	DialogCommand(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return command;
	}
}
