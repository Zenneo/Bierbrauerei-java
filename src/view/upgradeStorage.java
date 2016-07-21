package view;

import model.*;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.*;
import org.eclipse.swt.custom.SashForm;

public class upgradeStorage extends Dialog {

	protected Object result;
	protected Shell shell;
	public RoundManager roundmanager;

	// dynamic UI labels
	private Label capitalLabel;
	private Label cost_small;
	private Label cost_medium;
	private Label cost_big;
	private Button upgrade_small;
	private Button upgrade_medium;
	private Button upgrade_big;
	private Label maxCapacityLabel;
	private SashForm smallUpgradeGroup;
	private SashForm mediumUpgradeGroup;
	private SashForm largeUpgradeGroup;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public upgradeStorage(final Shell parent, int style,
			RoundManager roundmanager) {
		super(parent, style);
		setText("Lager-Upgrades");
		this.roundmanager = roundmanager;

		parent.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
				parent.dispose();
			}

		});
	}

	/**
	 * Open the dialog.
	 * 
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
		shell.setMinimumSize(new Point(384, 184));
		shell.setSize(384, 184);
		shell.setText("Lager-Upgrades");
		shell.setLayout(new FillLayout(SWT.VERTICAL));

		SashForm sashForm = new SashForm(shell, SWT.VERTICAL);

		SashForm sashForm_2 = new SashForm(sashForm, SWT.VERTICAL);

		Label lblNewLabel = new Label(sashForm_2, SWT.NONE);
		lblNewLabel.setText("W\u00E4hle ein Upgrade!");

		SashForm sashForm_6 = new SashForm(sashForm_2, SWT.NONE);

		maxCapacityLabel = new Label(sashForm_6, SWT.NONE);
		maxCapacityLabel.setText("Aktuelle Lager-Kapazit\u00E4t: 3000");

		capitalLabel = new Label(sashForm_6, SWT.NONE);
		capitalLabel.setText("Kapital: ");
		sashForm_6.setWeights(new int[] { 1, 1 });
		sashForm_2.setWeights(new int[] { 2, 3 });

		Group grpUpgrades = new Group(sashForm, SWT.NONE);
		grpUpgrades.setText("Upgrades");
		grpUpgrades.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm_1 = new SashForm(grpUpgrades, SWT.NONE);

		smallUpgradeGroup = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_small = new Button(smallUpgradeGroup, SWT.NONE);
		upgrade_small.setToolTipText("Tooltip kleines Upgrade");
		upgrade_small.setText("Klein");

		cost_small = new Label(smallUpgradeGroup, SWT.NONE);
		cost_small.setText("xyz");
		smallUpgradeGroup.setWeights(new int[] { 5, 1 });

		mediumUpgradeGroup = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_medium = new Button(mediumUpgradeGroup, SWT.NONE);
		upgrade_medium.setToolTipText("Tooltip mittleres Upgrade");
		upgrade_medium.setText("Mittel");

		cost_medium = new Label(mediumUpgradeGroup, SWT.NONE);
		cost_medium.setText("xyz");
		mediumUpgradeGroup.setWeights(new int[] { 5, 1 });

		largeUpgradeGroup = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_big = new Button(largeUpgradeGroup, SWT.NONE);
		upgrade_big.setToolTipText("Tooltip groﬂes Upgrade");
		upgrade_big.setText("Gro\u00DF");

		cost_big = new Label(largeUpgradeGroup, SWT.NONE);
		cost_big.setText("xyz");
		largeUpgradeGroup.setWeights(new int[] { 5, 1 });
		sashForm_1.setWeights(new int[] { 1, 1, 1 });
		sashForm.setWeights(new int[] { 2, 5 });

		upgrade_small.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					roundmanager.purchaseUpgrade(0, 0);
					fetchUIData();
					break;
				}
			}
		});
		upgrade_medium.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					roundmanager.purchaseUpgrade(0, 1);
					fetchUIData();
					break;
				}
			}
		});
		upgrade_big.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					roundmanager.purchaseUpgrade(0, 2);
					fetchUIData();
					break;
				}
			}
		});

		// initial Data fetch
		fetchUIData();
	}

	private void fetchUIData() {
		// set capital
		capitalLabel.setText("Aktuelles Kapital: " + roundmanager.getCapital()
				+ "Ä");

		// set max storage capacity
		maxCapacityLabel.setText("Aktuelle Lager-Kapazit‰t: "
				+ roundmanager.getStorageMaxSpace());

		// set small update text
		if (roundmanager.getUpgradesStorage()[0].isPossible()) {
			smallUpgradeGroup.setEnabled(true);
			upgrade_small.setEnabled(true);

		} else {
			smallUpgradeGroup.setEnabled(false);
			upgrade_small.setEnabled(false);
		}
		upgrade_small.setText(roundmanager.getUpgradesStorage()[0]
				.getDescriptions());
		upgrade_small.setToolTipText("Verbessert die Lagerkapazit‰t um "
				+ roundmanager.getUpgradeStorageEffect(0)  + ". Pro Tag werden " + roundmanager.getUpgradesStorage()[0].getRoundlyCosts() + "Ä extra gezahlt");
		cost_small.setText("Kosten: " + roundmanager.getUpgradeStoragePrice(0)
				+ "Ä");

		// set medium update text
		if (roundmanager.getUpgradesStorage()[1].isPossible()) {
			mediumUpgradeGroup.setEnabled(true);
			upgrade_medium.setEnabled(true);

		} else {
			mediumUpgradeGroup.setEnabled(false);
			upgrade_medium.setEnabled(false);
		}
		upgrade_medium.setText(roundmanager.getUpgradesStorage()[1]
				.getDescriptions());
		upgrade_medium.setToolTipText("Verbessert die Lagerkapazit‰t um "
				+ roundmanager.getUpgradeStorageEffect(1)  + ". Pro Tag werden " + roundmanager.getUpgradesStorage()[1].getRoundlyCosts() + "Ä extra gezahlt");
		cost_medium.setText("Kosten: " + roundmanager.getUpgradeStoragePrice(1)
				+ "Ä");

		// set big update text
		if (roundmanager.getUpgradesStorage()[2].isPossible()) {
			largeUpgradeGroup.setEnabled(true);
			upgrade_big.setEnabled(true);

		} else {
			largeUpgradeGroup.setEnabled(false);
			upgrade_big.setEnabled(false);
		}
		upgrade_big.setText(roundmanager.getUpgradesStorage()[2]
				.getDescriptions());
		upgrade_big.setToolTipText("Verbessert die Lagerkapazit‰t um "
				+ roundmanager.getUpgradeStorageEffect(2)  + ". Pro Tag werden " + roundmanager.getUpgradesStorage()[2].getRoundlyCosts() + "Ä extra gezahlt");
		cost_big.setText("Kosten: " + roundmanager.getUpgradeStoragePrice(2)
				+ "Ä");

	}

}
