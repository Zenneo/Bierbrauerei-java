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

		SashForm sashForm_3 = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_small = new Button(sashForm_3, SWT.NONE);
		upgrade_small.setToolTipText("xyz");
		upgrade_small.setText("Klein");

		cost_small = new Label(sashForm_3, SWT.NONE);
		cost_small.setText("xyz");
		sashForm_3.setWeights(new int[] { 5, 1 });

		SashForm sashForm_4 = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_medium = new Button(sashForm_4, SWT.NONE);
		upgrade_medium.setToolTipText("xyz");
		upgrade_medium.setText("Mittel");

		cost_medium = new Label(sashForm_4, SWT.NONE);
		cost_medium.setText("xyz");
		sashForm_4.setWeights(new int[] { 5, 1 });

		SashForm sashForm_5 = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_big = new Button(sashForm_5, SWT.NONE);
		upgrade_big.setToolTipText("xyz");
		upgrade_big.setText("Gro\u00DF");

		cost_big = new Label(sashForm_5, SWT.NONE);
		cost_big.setText("xyz");
		sashForm_5.setWeights(new int[] { 5, 1 });
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
		// set capital
		capitalLabel.setText("Aktuelles Kapital: " + roundmanager.getCapital()
				+ "€");

		// set output
		outputLabel.setText("Aktuelle Produktivität: "
				+ roundmanager.getOutput());

		// set small update text
		upgrade_small.setText(roundmanager.getUpgradesOutput()[0]
				.getDescriptions());
		upgrade_small
				.setToolTipText("Verbessert die aktuelle Produktionsmenge um "
						+ roundmanager.getUpgradeOutputEffect(0));
		cost_small.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(0));

		// set medium update text
		upgrade_medium.setText(roundmanager.getUpgradesOutput()[1]
				.getDescriptions());
		upgrade_medium
				.setToolTipText("Verbessert die aktuelle Produktionsmenge um "
						+ roundmanager.getUpgradeOutputEffect(1));
		cost_medium.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(1));

		// set big update text
		upgrade_big.setText(roundmanager.getUpgradesOutput()[2]
				.getDescriptions());
		upgrade_big
				.setToolTipText("Verbessert die aktuelle Produktionsmenge um "
						+ roundmanager.getUpgradeOutputEffect(2));
		cost_big.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(2));
	}

}
