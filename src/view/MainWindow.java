package view;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

import swing2swt.layout.FlowLayout;

public class MainWindow {

	protected Shell shell;
	private Text txtAdfasdfAsdfAsdf;
	private Text eventDescription;

	// constructor
	public MainWindow() {
		
	}
	
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
		shell.setMinimumSize(new Point(600, 400));
		shell.setSize(509, 401);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite GameView = new Composite(shell, SWT.NONE);
		GameView.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(GameView, SWT.VERTICAL);

		Composite Head = new Composite(sashForm, SWT.NONE);
		Head.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Button buttonNextRound = new Button(Head, SWT.CENTER);
		buttonNextRound.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		buttonNextRound.setText("Zum n\u00E4chster Tag");

		Composite Top = new Composite(sashForm, SWT.NONE);
		Top.setLayout(new FillLayout(SWT.HORIZONTAL));

		Group TopLeft = new Group(Top, SWT.NONE);
		TopLeft.setText("Markt");
		TopLeft.setLayout(new FillLayout(SWT.VERTICAL));

		SashForm sashForm_2 = new SashForm(TopLeft, SWT.VERTICAL);

		Label beerPrice = new Label(sashForm_2, SWT.NONE);
		beerPrice.setText("Bierpreis");

		SashForm price = new SashForm(sashForm_2, SWT.NONE);

		Scale price_scale = new Scale(price, SWT.NONE);

		Spinner price_spinner = new Spinner(price, SWT.BORDER);
		price.setWeights(new int[] { 1, 1 });

		Label beerAmount = new Label(sashForm_2, SWT.NONE);
		beerAmount.setText("Biermenge");

		SashForm amount = new SashForm(sashForm_2, SWT.NONE);

		Scale amount_scale = new Scale(amount, SWT.NONE);

		Spinner amount_spinner = new Spinner(amount, SWT.BORDER);
		sashForm_2.setWeights(new int[] { 1, 2, 1, 2 });

		Group TopRight = new Group(Top, SWT.NONE);
		TopRight.setText("B\u00FCro");
		TopRight.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm_1 = new SashForm(TopRight, SWT.VERTICAL);

		Label konto = new Label(sashForm_1, SWT.NONE);
		konto.setText("Konto: xyz");

		Label kosten = new Label(sashForm_1, SWT.NONE);
		kosten.setText("Kosten: xyz");

		Group grpAuftrage = new Group(sashForm_1, SWT.NONE);
		grpAuftrage.setText("Auftr\u00E4ge");
		grpAuftrage.setLayout(new FillLayout(SWT.VERTICAL));

		SashForm sashForm_3 = new SashForm(grpAuftrage, SWT.VERTICAL);

		Label eventTitle = new Label(sashForm_3, SWT.NONE);
		eventTitle.setText("eventTitle");

		eventDescription = new Text(sashForm_3, SWT.BORDER | SWT.READ_ONLY
				| SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		eventDescription
				.setText("afadf  asdf asdff asddaf aa sdf sdf sadf sdaf asdf asdjkfjskldj l klsjf lksjfkl jkl\u00F6jfkl\u00F6j\u00F6jiojao fjopij opjp oiaetuiop hz uioh opiuo  a");
		sashForm_3.setWeights(new int[] { 1, 5 });
		sashForm_1.setWeights(new int[] { 1, 1, 7 });

		Composite Bottom = new Composite(sashForm, SWT.NONE);
		Bottom.setLayout(new FillLayout(SWT.HORIZONTAL));

		Group BottomLeft = new Group(Bottom, SWT.NONE);
		BottomLeft.setText("Brauerei");

		Label capacity = new Label(BottomLeft, SWT.NONE);
		capacity.setBounds(10, 25, 55, 15);
		capacity.setText("Kapazit\u00E4t");

		Label storage = new Label(BottomLeft, SWT.NONE);
		storage.setBounds(10, 46, 55, 15);
		storage.setText("Lager");

		Group BottomRight = new Group(Bottom, SWT.NONE);
		BottomRight.setText("Upgrade");
		BottomRight.setLayout(new FillLayout(SWT.HORIZONTAL));

		Button storageButton = new Button(BottomRight, SWT.NONE);
		storageButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		storageButton.setText("Lager");

		Button upgradeProduction = new Button(BottomRight, SWT.NONE);
		upgradeProduction.setText("Produktion");
		sashForm.setWeights(new int[] { 2, 5, 5 });

		upgradeProduction.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					
					// Loop through all active shells and check if 
			        // the shell is already open
			        Shell[] shells = Display.getCurrent().getShells();

			        for(Shell shell : shells) {
			            String data = (String) shell.getData();

			            // only activate the shell and return
			            if(data != null && data.equals("yourID")) {
			                shell.setFocus();
			                return;
			            }
			        }

			        // open the shell and the dialog
			        Shell shell = new Shell(Display.getCurrent());
			        shell.setData("yourID");
			        upgradeStorage upgradestorage = new upgradeStorage(shell, 0);
			        upgradestorage.open();
				}
			}

		});

	}
}
