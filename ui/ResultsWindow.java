package ui;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class ResultsWindow extends UserInterface {
	
	JFrame resultsWindow = new JFrame();
	Color background = Color.DARK_GRAY;
	Color foreground = new Color(255, 69, 0);
	Font f = new Font("Tahoma", Font.BOLD, 12);
	JTextArea resultsBox;
	JScrollPane scrollPane;
	Dimension preferredSize = new Dimension(350, 310);
	public ResultsWindow() {
		resultsWindow.setTitle("Scout Results");
		resultsWindow.setBounds(100, 100, 360, 350);
		resultsWindow.setResizable(false);
		resultsWindow.setLocationRelativeTo(null);
		resultsWindow.setLayout(new FlowLayout());
		resultsWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		resultsWindow.setFont(f);
		resultsWindow.getContentPane().setBackground(background);
		resultsWindow.getContentPane().setForeground(foreground);
		resultsBox = new JTextArea();
		resultsBox.setEditable(false);
		resultsBox.setFont(f);
		resultsBox.setBackground(background);
		resultsBox.setForeground(foreground);
		resultsBox.setLineWrap(true);
		resultsBox.setWrapStyleWord(true);
		scrollPane = new JScrollPane(resultsBox);
		scrollPane.setPreferredSize(preferredSize);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setBackground(background);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(background);
		scrollPane.setForeground(foreground);
		resultsWindow.getContentPane().add(scrollPane);
		resultsWindow.setVisible(true);
	}
	
	public void setResultsBox(String value) {
		
		value = (resultsBox.getText() + value);
		this.resultsBox.setText(value);
		
	}
	
	public JTextArea getResultsBox() {
		return this.resultsBox;
	}
}