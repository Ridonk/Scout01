package gui;

import javax.swing.SwingUtilities;

public class Main {
	
	private static void init() {
		final BaseFrame wnd = new BaseFrame();
		wnd.setVisible(true);
	}
	
	public static void main(String[] args) {
		
//		final String text = args[0];
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				init();
			}
		});

	}

}
