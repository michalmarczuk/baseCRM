package baseCRM.page;

public class SettingsProfilePage extends SettingsPage {

	@Override
	protected void isLoaded() throws Error {
		urlEndsWith("(.*)/settings/profile");
	}
}
