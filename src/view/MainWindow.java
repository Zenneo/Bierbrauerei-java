package view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MainWindow {

	protected Shell shell;
	private Text txtSdf;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);

		txtSdf = new Text(shell, SWT.BORDER);
		txtSdf.setBounds(0, 10, 76, 21);
		txtSdf.setText("Test");

		Scale scale = new Scale(shell, SWT.NONE);
		scale.setBounds(10, 48, 170, 42);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(94, 10, 75, 25);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setText("New Button");

		btnNewButton.setText("Click and check the console");

		final Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(209, 103, 55, 15);
		lblNewLabel.setText("New Label");

		btnNewButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					lblNewLabel.setText("Button pressed");
					break;
				}
			}

		});
	}
}
