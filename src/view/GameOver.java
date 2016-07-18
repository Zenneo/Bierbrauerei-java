package view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
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
		
		SashForm sashForm_3 = new SashForm(sashForm, SWT.NONE);
		sashForm_3.setWeights(new int[] {});
		
		SashForm sashForm_4 = new SashForm(sashForm, SWT.NONE);
		
		Label lblNewLabel = new Label(sashForm_4, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Rockwell", 23, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("Du bist pleite !!!");
		sashForm_4.setWeights(new int[] {1});
		sashForm.setWeights(new int[] {1, 1});
		
		SashForm sashForm_1 = new SashForm(sashForm_2, SWT.NONE);
		
		SashForm sashForm_5 = new SashForm(sashForm_1, SWT.NONE);
		sashForm_5.setWeights(new int[] {});
		
		SashForm sashForm_6 = new SashForm(sashForm_1, SWT.NONE);
		
		Button btnNewButton_1 = new Button(sashForm_6, SWT.NONE);
		btnNewButton_1.setText("Spiel beenden");
		sashForm_6.setWeights(new int[] {1});
		
		SashForm sashForm_7 = new SashForm(sashForm_1, SWT.NONE);
		sashForm_1.setWeights(new int[] {1, 1, 1});
		sashForm_2.setWeights(new int[] {5, 3});

	}
}
