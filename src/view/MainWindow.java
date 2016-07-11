package view;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Event;
import model.*;

public class MainWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	private RoundManager roundmanager;

	// public UI elements
	private Label konto;
	private Label kosten;
	private Label capacity;
	private Label storage;

	// constructor
	public MainWindow(RoundManager roundmanager) {
		this.roundmanager = roundmanager;
	}

	/**
	 * @wbp.parser.entryPoint
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
		;
		Head.setLayout(new FillLayout(SWT.HORIZONTAL));

		Button buttonNextRound = new Button(Head, SWT.CENTER);
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

		final Scale price_scale = new Scale(price, SWT.NONE);

		final Spinner price_spinner = new Spinner(price, SWT.BORDER);
		price.setWeights(new int[] { 4, 1 });

		// synchronise price spinnner and scale
		price_scale.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					price_spinner.setSelection(price_scale.getSelection());
					break;
				}
			}
		});
		price_spinner.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					price_scale.setSelection(price_spinner.getSelection());
					break;
				}
			}
		});

		Label beerAmount = new Label(sashForm_2, SWT.NONE);
		beerAmount.setText("Biermenge");

		SashForm amount = new SashForm(sashForm_2, SWT.NONE);

		final Scale amount_scale = new Scale(amount, SWT.NONE);

		final Spinner amount_spinner = new Spinner(amount, SWT.BORDER);

		// synchronise amount spinnner and scale
		amount_scale.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					amount_spinner.setSelection(amount_scale.getSelection());
					break;
				}
			}
		});
		amount_spinner.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					amount_scale.setSelection(amount_spinner.getSelection());
					break;
				}
			}
		});

		amount.setWeights(new int[] { 4, 1 });
		sashForm_2.setWeights(new int[] { 1, 2, 1, 2 });

		Group TopRight = new Group(Top, SWT.NONE);
		TopRight.setText("B\u00FCro");
		TopRight.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm_1 = new SashForm(TopRight, SWT.VERTICAL);

		konto = new Label(sashForm_1, SWT.NONE);
		konto.setText("Konto: xyz");

		kosten = new Label(sashForm_1, SWT.NONE);
		kosten.setText("Kosten: xyz");

		Group grpAuftrage = new Group(sashForm_1, SWT.NONE);
		grpAuftrage.setText("Events");
		grpAuftrage.setLayout(new FillLayout(SWT.VERTICAL));

		Label eventName = new Label(grpAuftrage, SWT.NONE);
		eventName.setText("Name: xyz");
		
		Label eventDescription = new Label(grpAuftrage, SWT.NONE);
		eventDescription.setText("Beschreibung: ");
		
		Label eventPrice = new Label(grpAuftrage, SWT.NONE);
		eventPrice.setText("Preis: xyz");
		
		Label eventAmount = new Label(grpAuftrage, SWT.NONE);
		eventAmount.setText("Ben\u00F6tigte Menge: xyz");
		
		Label eventRoundsLeft = new Label(grpAuftrage, SWT.NONE);
		eventRoundsLeft.setText("Noch \u00FCbrige Runden: xyz");
		
		Button doEvent = new Button(grpAuftrage, SWT.NONE);
		doEvent.setText("Auftrag erf\u00FCllen");
		sashForm_1.setWeights(new int[] { 1, 1, 5 });

		Composite Bottom = new Composite(sashForm, SWT.NONE);
		Bottom.setLayout(new FillLayout(SWT.HORIZONTAL));

		Group BottomLeft = new Group(Bottom, SWT.NONE);
		BottomLeft.setText("Brauerei");
		BottomLeft.setLayout(new FillLayout(SWT.VERTICAL));

		capacity = new Label(BottomLeft, SWT.NONE);
		capacity.setText("Kapazit\u00E4t");

		storage = new Label(BottomLeft, SWT.NONE);
		storage.setText("Lager");

		Group BottomRight = new Group(Bottom, SWT.NONE);
		BottomRight.setText("Upgrade");
		BottomRight.setLayout(new FillLayout(SWT.HORIZONTAL));

		Button LagerButton = new Button(BottomRight, SWT.NONE);
		LagerButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:

					// Loop through all active shells and check if
					// the shell is already open
					Shell[] shells = Display.getCurrent().getShells();

					for (Shell shell : shells) {
						String data = (String) shell.getData();

						// only activate the shell and return
						if (data != null && data.equals("yourID")) {
							shell.setFocus();
							return;
						}
					}

					// open the shell and the dialog
					Shell shell = new Shell(Display.getCurrent());
					shell.setData("yourID");
					upgradeStorage upgradestorage = new upgradeStorage(shell,
							0, roundmanager);
					upgradestorage.open();
					break;
				}
			}

		});
		LagerButton.setText("Lager");

		Button ProdukteButton = new Button(BottomRight, SWT.NONE);
		ProdukteButton.setText("Produkte");
		sashForm.setWeights(new int[] { 2, 5, 5 });

		ProdukteButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:

					break;
				}
			}
		});

		// next round button event
		buttonNextRound.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.out.println("NextRoundButton");
					roundmanager.placeSellOrder(amount_scale.getSelection(), price_scale.getSelection());
					roundmanager.nextRound();
					fetchUIData();
					
					// reset amount selection
					amount_scale.setSelection(0);
					amount_spinner.setSelection(0);
					break;
				}
			}
		});
		
		
		// initial Data fetch
		fetchUIData();
	}

	
	
	public void fetchUIData() {
		konto.setText("Kontostand: " + roundmanager.getCapital());
		kosten.setText("Kosten: " + roundmanager.getRoundlyCosts());
		capacity.setText("Lager-Kapazität: "
				+ roundmanager.getStorageMaxSpace());
		storage.setText("Lagernutzung: " + roundmanager.getStorage());
	}
}
