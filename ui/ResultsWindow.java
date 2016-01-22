package ui;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class ResultsWindow {
	
	private JTextArea resultsBox = new JTextArea(19, 30);
	private JScrollPane scrollPane = new JScrollPane(resultsBox);
	public ResultsWindow(JFrame resultsWindow) {
		resultsWindow.setTitle("Scout Results");
		resultsWindow.setLayout(new FlowLayout());
		resultsWindow.add(scrollPane);
		resultsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		resultsWindow.add(closeButton);
	}
	public void setResultsBox(String value) {
		
		value = (resultsBox.getText() + value);
		this.resultsBox.setText(value);
		
	}
	public JTextArea getResultsBox() {
		return this.resultsBox;
	}
}