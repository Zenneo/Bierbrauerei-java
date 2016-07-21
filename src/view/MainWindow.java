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

	private Shell mainShell;

	// dynamic UI elements
	private Label konto;
	private Label kosten;
	private Label capacity;
	private Label storage;
	private Spinner amount_spinner;
	private Scale amount_scale;
	private Label output;
	private Group TopRight;
	private Label eventName;
	private Text eventDescription;
	private Label eventPrice;
	private Label eventAmount;
	private Label eventRoundsLeft;
	private Button doEvent;

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
		mainShell.open();
		mainShell.layout();
		while (!mainShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

	protected void createContents() {
		mainShell = new Shell();
		mainShell.setMinimumSize(new Point(529, 363));
		mainShell.setSize(503, 322);
		mainShell.setText("Bier-Simulator");
		mainShell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite GameView = new Composite(mainShell, SWT.NONE);
		GameView.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(GameView, SWT.VERTICAL);

		Composite Head = new Composite(sashForm, SWT.NONE);
		;
		Head.setLayout(new FillLayout(SWT.HORIZONTAL));

		Button buttonNextRound = new Button(Head, SWT.CENTER);
		buttonNextRound.setText("Zum n\u00E4chster Tag");

		SashForm Top = new SashForm(sashForm, SWT.NONE);

		Group TopLeft = new Group(Top, SWT.NONE);
		TopLeft.setText("Markt");
		TopLeft.setLayout(new FillLayout(SWT.VERTICAL));

		SashForm sashForm_2 = new SashForm(TopLeft, SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm_2, SWT.NONE);
				composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
				Label beerPrice = new Label(composite, SWT.NONE);
				beerPrice.setText("Preis pro Bier");
				
				Label summe = new Label(composite, SWT.NONE);
				summe.setAlignment(SWT.RIGHT);
				summe.setText("Summe: ");

		SashForm price = new SashForm(sashForm_2, SWT.NONE);

		final Scale price_scale = new Scale(price, SWT.NONE);
		price_scale.setIncrement(5);
		price_scale.setMaximum(50);

		final Spinner price_spinner = new Spinner(price, SWT.BORDER);
		price_spinner.setIncrement(5);
		price_spinner.setMaximum(50);
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

		amount_scale = new Scale(amount, SWT.NONE);
		amount_scale.setIncrement(5);
		amount_scale.setPageIncrement(25);

		amount_spinner = new Spinner(amount, SWT.BORDER);
		amount_spinner.setIncrement(5);

		// synchronise amount spinner and scale
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

		Group büroGroup = new Group(sashForm_2, SWT.NONE);
		büroGroup.setText("B\u00FCro");
		büroGroup.setLayout(new FillLayout(SWT.HORIZONTAL));

		konto = new Label(büroGroup, SWT.NONE);
		konto.setText("Konto: xyz");

		kosten = new Label(büroGroup, SWT.NONE);
		kosten.setText("Kosten: xyz");
		sashForm_2.setWeights(new int[] { 1, 2, 1, 2, 2 });

		TopRight = new Group(Top, SWT.NONE);
		TopRight.setText("Events");
		TopRight.setLayout(new FillLayout(SWT.VERTICAL));

		SashForm eventGroup = new SashForm(TopRight, SWT.VERTICAL);

		eventName = new Label(eventGroup, SWT.NONE);
		eventName.setText("Name: xyz");

		eventDescription = new Text(eventGroup, SWT.BORDER | SWT.READ_ONLY
				| SWT.WRAP | SWT.V_SCROLL);
		eventDescription.setEditable(false);
		eventDescription
				.setText("eventDes dafdlfkj fajdlfj  lkfaj dj\u00F6 lkjaf ljl\u00F6kf asd adfa dsf lkj adf af");

		eventPrice = new Label(eventGroup, SWT.NONE);
		eventPrice.setText("Preis: xyz");

		eventAmount = new Label(eventGroup, SWT.NONE);
		eventAmount.setText("Ben\u00F6tigte Menge: xyz");

		eventRoundsLeft = new Label(eventGroup, SWT.NONE);
		eventRoundsLeft.setText("Noch \u00FCbrige Runden: xyz");

		doEvent = new Button(eventGroup, SWT.NONE);
		doEvent.setText("Auftrag liefern");

		doEvent.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					roundmanager.executeEvent();
					fetchUIData();
					break;
				}
			}
		});
		eventGroup.setWeights(new int[] { 1, 3, 1, 1, 1, 2 });
		Top.setWeights(new int[] { 4, 4 });

		Composite Bottom = new Composite(sashForm, SWT.NONE);
		Bottom.setLayout(new FillLayout(SWT.HORIZONTAL));

		Group BottomLeft = new Group(Bottom, SWT.NONE);
		BottomLeft.setText("Brauerei");
		BottomLeft.setLayout(new FillLayout(SWT.VERTICAL));

		output = new Label(BottomLeft, SWT.NONE);
		output.setText("Produktionsmenge: 0");

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
					// open the shell and the dialog
					Shell shell = new Shell(Display.getCurrent());
					shell.setData("lagerDiag");
					shell.setLocation(mainShell.getLocation());

					upgradeStorage upgradestorage = new upgradeStorage(shell,
							0, roundmanager);
					upgradestorage.open();
					break;
				}
			}

		});
		LagerButton.setText("Lager");

		Button ProduktionButton = new Button(BottomRight, SWT.NONE);
		ProduktionButton.setText("Produktion");
		sashForm.setWeights(new int[] { 2, 6, 3 });

		ProduktionButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					// open the shell and the dialog
					Shell shell = new Shell(Display.getCurrent());
					shell.setData("produkDiag");
					shell.setLocation(mainShell.getLocation());

					upgradeProduction upgradeproduction = new upgradeProduction(
							shell, 0, roundmanager);
					upgradeproduction.open();
					break;
				}
			}
		});

		// next round button event
		buttonNextRound.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					try {
						
						System.out
						.println("UI - MainWindow: NextRoundButton pressed");
						roundmanager.placeSellOrder(amount_scale.getSelection(),
								price_scale.getSelection());
						roundmanager.nextRound();
						fetchUIData();
						
						// reset amount selection
						amount_scale.setSelection(0);
						amount_spinner.setSelection(0);
					}
					catch (IllegalArgumentException ex) {
						// open the shell and the dialog
						Shell shell = new Shell(Display.getCurrent());
						shell.setData("gameOver");
						shell.setLocation(mainShell.getLocation());

						GameOver gameover = new GameOver(
								shell, 0);
						gameover.open();
					}
					break;
				}
			}
		});

		// initial Data fetch
		fetchUIData();
	}

	private void fetchUIData() {
		// update labels
		konto.setText("Kontostand: " + roundmanager.getCapital() + "€");
		kosten.setText("Kosten: " + roundmanager.getRoundlyCosts() + "€");
		capacity.setText("Lager-Kapazität: "
				+ roundmanager.getStorageMaxSpace());
		storage.setText("Lagernutzung: " + roundmanager.getStorage());
		output.setText("Produktionsmenge: " + roundmanager.getOutput());

		// set amount scale bounds
		if (roundmanager.getStorage() > 0) {
			amount_scale.setEnabled(true);
			amount_scale.setMaximum(roundmanager.getStorage());

			amount_spinner.setEnabled(true);
			amount_spinner.setMaximum(roundmanager.getStorage());
		} else {
			amount_scale.setEnabled(false);
			amount_spinner.setEnabled(false);
		}

		// update UI window
		if (roundmanager.checkEventAvailability()) {
			// event is active
			TopRight.setEnabled(true);
			eventDescription.setEnabled(true);
			eventName.setText(roundmanager.getEventName());
			eventDescription.setText(roundmanager.getEventDescription());
			eventPrice.setText("Belohnung: " + roundmanager.getEventPrice() + "€");
			eventAmount.setText("Erwartete Biermenge: "
					+ roundmanager.getEventAmount());
			eventRoundsLeft.setText("Noch " + roundmanager.getEventDurability()
					+ " Runden übrig");

			// check if event can be completed
			doEvent.setEnabled(roundmanager.checkEventPossibility());

		} else {
			// no event active
			TopRight.setEnabled(false);
			eventDescription.setEnabled(false);
			eventName.setText("Kein Event aktiv");
			eventDescription.setText("");
			eventPrice.setText("");
			eventAmount.setText("");
			eventRoundsLeft.setText("");
			doEvent.setEnabled(false);
		}
	}
}
