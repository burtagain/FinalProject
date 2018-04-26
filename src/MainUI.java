import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class MainUI extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainUI(Composite parent, int style) {
		super(parent, style);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(23, 38, 75, 25);
		btnNewButton.setText("New Button");
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
