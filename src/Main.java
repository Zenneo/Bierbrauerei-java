import model.*;
import view.*;

public class Main {
	public static void main(String args[]) {
		RoundManager roundmanager = new RoundManager();

		// create main window
		MainWindow mainWindow = new MainWindow(roundmanager);
		mainWindow.open();

	}
}
