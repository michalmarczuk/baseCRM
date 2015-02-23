package baseCRM.page;

public class SalesPage extends DashboardPage {

	@Override
	protected void isLoaded() throws Error {
		urlEndsWith("(.*)/sales");
	}
}
