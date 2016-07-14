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

		SashForm sashForm_3 = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_small = new Button(sashForm_3, SWT.NONE);
		upgrade_small.setToolTipText("Tooltip kleines Upgrade");
		upgrade_small.setText("Klein");

		cost_small = new Label(sashForm_3, SWT.NONE);
		cost_small.setText("xyz");
		sashForm_3.setWeights(new int[] { 5, 1 });

		SashForm sashForm_4 = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_medium = new Button(sashForm_4, SWT.NONE);
		upgrade_medium.setToolTipText("Tooltip mittleres Upgrade");
		upgrade_medium.setText("Mittel");

		cost_medium = new Label(sashForm_4, SWT.NONE);
		cost_medium.setText("xyz");
		sashForm_4.setWeights(new int[] { 5, 1 });

		SashForm sashForm_5 = new SashForm(sashForm_1, SWT.VERTICAL);

		upgrade_big = new Button(sashForm_5, SWT.NONE);
		upgrade_big.setToolTipText("Tooltip groﬂes Upgrade");
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
		upgrade_small
				.setToolTipText("Verbessert die Lagerkapazit‰t um "
						+ roundmanager.getUpgradeOutputEffect(0));
		cost_small.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(0));

		// set medium update text
		upgrade_medium
				.setToolTipText("Verbessert die Lagerkapazit‰t um "
						+ roundmanager.getUpgradeOutputEffect(1));
		cost_medium.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(1));

		// set big update text
		upgrade_big
				.setToolTipText("Verbessert die Lagerkapazit‰t um "
						+ roundmanager.getUpgradeOutputEffect(2));
		cost_big.setText("Kosten: " + roundmanager.getUpgradeOutputPrice(2));

	}

}
