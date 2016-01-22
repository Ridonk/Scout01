package ui;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsWindow {

	Color background = new Color(255, 255, 255);
	Color foreground = new Color(30, 144, 255);
	private JTextArea resultsBox = new JTextArea(19, 30);
	private JScrollPane scrollPane = new JScrollPane(resultsBox);
	public ResultsWindow(JFrame resultsWindow) {
		resultsWindow.setTitle("Scout Results");
		resultsWindow.setLayout(new FlowLayout());
		resultsWindow.add(scrollPane);
		scrollPane.setBackground(background);
		scrollPane.setForeground(foreground);
		resultsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton closeButton = new JButton("Close");
		closeButton.setBackground(background);
		closeButton.setForeground(foreground);
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
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