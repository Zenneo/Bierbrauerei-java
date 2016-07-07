package view;
import model.*;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.*;

public class upgradeProduction extends Dialog {

	protected Object result;
	protected Shell shlLagerupgrades;
	public RoundManager roundmanager;

	/**
	 * Create the dialog.
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
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlLagerupgrades.open();
		shlLagerupgrades.layout();
		Display display = getParent().getDisplay();
		while (!shlLagerupgrades.isDisposed()) {
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
		int upgradesmallEffect = roundmanager.getUpgradeOutputEffect(0);
		int upgrademediumEffect = roundmanager.getUpgradeOutputEffect(1);
		int upgradebigEffect = roundmanager.getUpgradeOutputEffect(2);
		int upgradesmallPrice = roundmanager.getUpgradeOutputPrice(0);
		int upgrademediumPrice = roundmanager.getUpgradeOutputPrice(1);
		int upgradebigPrice = roundmanager.getUpgradeOutputPrice(2);
		
		String smallEffect = "" + upgradesmallEffect;
		String mediumEffect = "" + upgrademediumEffect;
		String bigEffect = "" + upgradebigEffect;
		
		String smallPrice = "" + upgradesmallPrice;
		String mediumPrice = "" + upgrademediumPrice;
		String bigPrice = "" + upgradebigPrice;
		
		
		shlLagerupgrades = new Shell(getParent(), getStyle());
		shlLagerupgrades.setMinimumSize(new Point(100, 100));
		shlLagerupgrades.setSize(344, 182);
		shlLagerupgrades.setText("Produktions-Upgrades");
		shlLagerupgrades.setLayout(new FillLayout(SWT.VERTICAL));
		
		SashForm sashForm = new SashForm(shlLagerupgrades, SWT.VERTICAL);
		
		SashForm sashForm_2 = new SashForm(sashForm, SWT.NONE);
		
		Label lblNewLabel = new Label(sashForm_2, SWT.NONE);
		lblNewLabel.setText("W\u00E4hle ein Upgrade!");
		
		Label lblNewLabel_1 = new Label(sashForm_2, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.RIGHT);
		lblNewLabel_1.setText("Aktuelles Kapital: 1002\u20AC");
		sashForm_2.setWeights(new int[] {1, 1});
		
		Group grpUpgrades = new Group(sashForm, SWT.NONE);
		grpUpgrades.setText("Upgrades");
		grpUpgrades.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_1 = new SashForm(grpUpgrades, SWT.NONE);
		
		SashForm sashForm_3 = new SashForm(sashForm_1, SWT.VERTICAL);
		
		Button upgrade_small = new Button(sashForm_3, SWT.NONE);
		upgrade_small.setToolTipText(smallEffect);
		upgrade_small.setText("Klein");
		
		Label cost_small = new Label(sashForm_3, SWT.NONE);
		cost_small.setText(smallPrice);
		sashForm_3.setWeights(new int[] {5, 1});
		
		SashForm sashForm_4 = new SashForm(sashForm_1, SWT.VERTICAL);
		
		Button upgrade_medium = new Button(sashForm_4, SWT.NONE);
		upgrade_medium.setToolTipText(mediumEffect);
		upgrade_medium.setText("Medium");
		
		Label cost_medium = new Label(sashForm_4, SWT.NONE);
		cost_medium.setText(mediumPrice);
		sashForm_4.setWeights(new int[] {5, 1});
		
		SashForm sashForm_5 = new SashForm(sashForm_1, SWT.VERTICAL);
		
		Button upgrade_big = new Button(sashForm_5, SWT.NONE);
		upgrade_big.setToolTipText(bigEffect);
		upgrade_big.setText("Gro\u00DF");
		
		Label cost_big = new Label(sashForm_5, SWT.NONE);
		cost_big.setText(bigPrice);
		sashForm_5.setWeights(new int[] {5, 1});
		sashForm_1.setWeights(new int[] {1, 1, 1});
		sashForm.setWeights(new int[] {2, 5});
		
		upgrade_small.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		        roundmanager.purchaseUpgrade(1, 0);
		          break;
		        }
		      }
		    });
		upgrade_medium.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		        roundmanager.purchaseUpgrade(1, 1);
		          break;
		        }
		      }
		    });
		upgrade_big.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		        roundmanager.purchaseUpgrade(1, 2);
		          break;
		        }
		      }
		    });

	}

}
