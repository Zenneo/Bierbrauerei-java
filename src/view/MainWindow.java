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
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.CLabel;

public class MainWindow {

	protected Shell shell;
	private Text txtAdfasdfAsdfAsdf;
	private Text eventDescription;

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
		price.setWeights(new int[] {1, 1});
		
		Label beerAmount = new Label(sashForm_2, SWT.NONE);
		beerAmount.setText("Biermenge");
		
		SashForm amount = new SashForm(sashForm_2, SWT.NONE);
		
		Scale amount_scale = new Scale(amount, SWT.NONE);
		
		Spinner amount_spinner = new Spinner(amount, SWT.BORDER);
		amount.setWeights(new int[] {2, 2, 4, 1});
		sashForm_2.setWeights(new int[] {1, 2, 1, 2});
		
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
		eventTitle.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		eventTitle.setText("eventTitle");
		
		eventDescription = new Text(sashForm_3, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		eventDescription.setText("afadf  asdf asdff asddaf aa sdf sdf sadf sdaf asdf asdjkfjskldj l klsjf lksjfkl jkl\u00F6jfkl\u00F6j\u00F6jiojao fjopij opjp oiaetuiop hz uioh opiuo  a");
		sashForm_3.setWeights(new int[] {1, 5});
		sashForm_1.setWeights(new int[] {1, 1, 7});
		
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
		
		Button LagerButton = new Button(BottomRight, SWT.NONE);
		LagerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		LagerButton.setText("Lager");
		
		Button btnNewButton_1 = new Button(BottomRight, SWT.NONE);
		btnNewButton_1.setText("Produktion");
		sashForm.setWeights(new int[] {2, 5, 5});
	}
}
