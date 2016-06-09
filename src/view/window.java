package view;

import org.eclipse.swt.widgets.Composite;

public class window extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public window(Composite parent, int style) {
		super(parent, style);

	}

	public static void main() {
		
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
