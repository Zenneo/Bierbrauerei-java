package view;

import org.eclipse.swt.widgets.Decorations;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Table;
import swing2swt.layout.BoxLayout;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;

public class MainWindow {

	protected Shell shell;

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
		shell.setSize(551, 363);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite GameView = new Composite(shell, SWT.NONE);
		GameView.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(GameView, SWT.VERTICAL);
		
		Composite Head = new Composite(sashForm, SWT.NONE);
		RowLayout rl_Head = new RowLayout(SWT.HORIZONTAL);
		rl_Head.center = true;
		Head.setLayout(rl_Head);
		
		Button buttonNextRound = new Button(Head, SWT.NONE);
		buttonNextRound.setText("Zum n\u00E4chster Tag");
		
		Composite Top = new Composite(sashForm, SWT.NONE);
		Top.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite TopLeft = new Composite(Top, SWT.NONE);
		
		Group TopRight = new Group(Top, SWT.NONE);
		TopRight.setText("B\u00FCro");
		TopRight.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		Label konto = new Label(TopRight, SWT.NONE);
		konto.setText("Konto: xyz");
		
		Label kosten = new Label(TopRight, SWT.NONE);
		kosten.setText("Kosten: xyz");
		
		Group grpAuftrage = new Group(TopRight, SWT.NONE);
		grpAuftrage.setText("Auftr\u00E4ge");
		grpAuftrage.setLayout(new FillLayout(SWT.VERTICAL));
		
		Composite Bottom = new Composite(sashForm, SWT.NONE);
		Bottom.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group BottomLeft = new Group(Bottom, SWT.NONE);
		BottomLeft.setText("Brauerei");
		
		Group BottomRight = new Group(Bottom, SWT.NONE);
		BottomRight.setText("Upgrade");
		BottomRight.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button LagerButton = new Button(BottomRight, SWT.NONE);
		LagerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		LagerButton.setText("Lager");
		
		Button btnNewButton_1 = new Button(BottomRight, SWT.NONE);
		btnNewButton_1.setText("Produkte");
		sashForm.setWeights(new int[] {2, 5, 5});
	}
}
