package view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class GameOver extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public GameOver(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.SYSTEM_MODAL);
		shell.setMinimumSize(new Point(344, 184));
		shell.setSize(296, 161);
		shell.setText(getText());
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_2 = new SashForm(shell, SWT.VERTICAL);
		
		SashForm sashForm = new SashForm(sashForm_2, SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		
		Label endText = new Label(sashForm, SWT.NONE);
		endText.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		endText.setFont(SWTResourceManager.getFont("Rockwell", 23, SWT.NORMAL));
		endText.setAlignment(SWT.CENTER);
		endText.setText("Du bist pleite !!!");
		sashForm.setWeights(new int[] {1, 1});
		
		SashForm sashForm_1 = new SashForm(sashForm_2, SWT.NONE);
		
		Composite composite_1 = new Composite(sashForm_1, SWT.NONE);
		
		Button finishGame = new Button(sashForm_1, SWT.NONE);
		finishGame.setText("Spiel beenden");
		finishGame.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.exit(0);
					break;
				}
			}
		});
		
		Composite composite_2 = new Composite(sashForm_1, SWT.NONE);
		sashForm_1.setWeights(new int[] {1, 1, 1});
		sashForm_2.setWeights(new int[] {5, 3});

	}
}
