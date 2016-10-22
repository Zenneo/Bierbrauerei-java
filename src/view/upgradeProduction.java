package view;

import model.*;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.*;

public class upgradeProduction extends Dialog {

	protected Object result;
	protected Shell shell;
	public RoundManager roundmanager;

	// dynamic UI labels
	private Label capitalLabel;
	private Button upgrade_small;
	private Label cost_small;
	private Button upgrade_medium;
	private Label cost_medium;
	private Button upgrade_big;
	private Label cost_big;
	private SashForm sashForm_6;
	private Label outputLabel;
	private SashForm smallUpgradeGroup;
	private SashForm mediumUpgradeGroup;
	private SashForm largeUpgradeGroup;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public upgradeProduction(Shell parent, int style, RoundManager roundmanager) {
		super(parent, style);
		setText("SWT Dialog");
		this.roundmanager = roundmanager;
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
		shell.setMinimumSize(new Point(344, 184));
		shell.setSize(344, 184);
		shell.setText("Produktions-Upgrades");
		shell.setLayout(new FillLayout(SWT.VERTICAL));

		SashForm sashForm = new SashForm(shell, SWT.VERTICAL);

		SashForm sashForm_2 = new SashForm(sashForm, SWT.VERTICAL);

		Label lblNewLabel = new Label(sashForm_2, SWT.NONE);
		lblNewLabel.setText("W\u00E4hle ein Upgrade!");

		sashForm_6 = new SashForm(sashForm_2, SWT.NONE);

		outputLabel = new Label(sashForm_6, SWT.NONE);
		outputLabel.setText("Aktuelle Produktivit\u00E4t");

		capitalLabel = new Label(sashForm_6, SWT.NONE);
		capitalLabel.setText("Aktuelles Kapital: 1002\u20AC");
		sashForm_6.setWeights(new int[] { 1, 1 });
		sashForm_2.setWeights(new int[] { 2, 3 });

		Group grpUpgrades = new Group(sashForm, SWT.NONE);
		grpUpgrades.setText("Upgrades");
		grpUpgrades.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm_1 = new SashForm(grpUpgrades, SWT.NONE);

		smallUpgradeGroup = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_small = new Button(smallUpgradeGroup, SWT.NONE);
		upgrade_small.setToolTipText("xyz");
		upgrade_small.setText("Klein");

		cost_small = new Label(smallUpgradeGroup, SWT.NONE);
		cost_small.setText("xyz");
		smallUpgradeGroup.setWeights(new int[] { 5, 1 });

		mediumUpgradeGroup = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_medium = new Button(mediumUpgradeGroup, SWT.NONE);
		upgrade_medium.setToolTipText("xyz");
		upgrade_medium.setText("Mittel");

		cost_medium = new Label(mediumUpgradeGroup, SWT.NONE);
		cost_medium.setText("xyz");
		mediumUpgradeGroup.setWeights(new int[] { 5, 1 });

		largeUpgradeGroup = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_big = new Button(largeUpgradeGroup, SWT.NONE);
		upgrade_big.setToolTipText("xyz");
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
					roundmanager.purchaseUpgrade(1, 0);
					fetchUIData();
					break;
				}
			}
		});
		upgrade_medium.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					roundmanager.purchaseUpgrade(1, 1);
					fetchUIData();
					break;
				}
			}
		});
		upgrade_big.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					roundmanager.purchaseUpgrade(1, 2);
					fetchUIData();
					break;
				}
			}
		});

		// initial Data fetch
		fetchUIData();
	}

	private void fetchUIData() {
		// set capital label
		capitalLabel.setText("Aktuelles Kapital: " + roundmanager.getCapital()
				+ "€");

		// set output label
		outputLabel.setText("Aktuelle Produktivität: "
				+ roundmanager.getOutput());

		// set small update button and labels
		if (roundmanager.getUpgradesOutput()[0].isPossible()) {
			smallUpgradeGroup.setEnabled(true);
			upgrade_small.setEnabled(true);

		} else {
			smallUpgradeGroup.setEnabled(false);
			upgrade_small.setEnabled(false);
		}
		upgrade_small.setText(roundmanager.getUpgradesOutput()[0]
				.getDescriptions());
		upgrade_small
				.setToolTipText("Verbessert die aktuelle Produktionsmenge um "
						+ roundmanager.getUpgradeOutputEffect(0) + ". Pro Runde werden " + roundmanager.getUpgradesOutput()[0].getRoundlyCosts() + "€ extra gezahlt");
		cost_small.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(0));

		// set medium update button and labels
		if (roundmanager.getUpgradesOutput()[1].isPossible()) {
			mediumUpgradeGroup.setEnabled(true);
			upgrade_medium.setEnabled(true);
		} else {
			mediumUpgradeGroup.setEnabled(false);
			upgrade_medium.setEnabled(false);
		}
		upgrade_medium.setText(roundmanager.getUpgradesOutput()[1]
				.getDescriptions());
		upgrade_medium
				.setToolTipText("Verbessert die aktuelle Produktionsmenge um "
						+ roundmanager.getUpgradeOutputEffect(1)  + ". Pro Runde werden " + roundmanager.getUpgradesOutput()[1].getRoundlyCosts() + "€ extra gezahlt");
		cost_medium.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(1));

		// set big update button and labels
		if (roundmanager.getUpgradesOutput()[2].isPossible()) {
			largeUpgradeGroup.setEnabled(true);
			upgrade_big.setEnabled(true);

		} else {
			largeUpgradeGroup.setEnabled(false);
			upgrade_big.setEnabled(false);
		}
		upgrade_big.setText(roundmanager.getUpgradesOutput()[2]
				.getDescriptions());
		upgrade_big
				.setToolTipText("Verbessert die aktuelle Produktionsmenge um "
						+ roundmanager.getUpgradeOutputEffect(2)  + ". Pro Runde werden " + roundmanager.getUpgradesOutput()[2].getRoundlyCosts() + "€ extra gezahlt");
		cost_big.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(2));

	}

}
