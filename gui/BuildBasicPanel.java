/*
	Actions are handled directly in the buildButton class.
	To modify the calculations methods one should look in 
	the unit.units package as well as the TroopCalc class.
*/
package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import calc.TroopCalc;

@SuppressWarnings("serial")
public class BuildBasicPanel extends JPanel {
	
	// Theme fonts
	private static Font f = new Font(Font.MONOSPACED, Font.BOLD, 12);
	
	String debug = "";
	int h = 450;
	int w = 400;
	
	private JTextField lordPower;
	private JTextField lordCastleLevel;
	private JTextArea resultsArea;
	
	BuildBasicPanel() {
		setOpaque(false);
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(w, h));
		setFont(f);
		
		lordPower = buildTextField("Lord Power");
		lordCastleLevel = buildTextField("Lord Castle Level");
		resultsArea = buildResultsArea();
		
		add(buildLabel("Enter the Lord's Power          "));
		add(lordPower);
		add(buildLabel("Enter the Lord's Castle Level   "));
		add(lordCastleLevel);
		add(buildButton("Calculate"));
		add(buildScrollPane(resultsArea));
	}
	
	private JTextField buildTextField(String name) {
		JTextField textField = new JTextField();
		textField.setName(name);
		textField.setFont(f);
		textField.setColumns(20);
		textField.setText("");
		return textField;
	}
	
	private JLabel buildLabel(String val) {
		JLabel label = new JLabel(val);
		label.setFont(f);
		return label;
	}
	
	private JButton buildButton(String val) {
		JButton button = new JButton(val);
		button.setFont(f);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Calculating.");
				updateResults();
			}
		});
		
		return button;
	}
	
	private JTextArea buildResultsArea() {
		JTextArea resultsArea = new JTextArea();
		resultsArea.setEditable(false);
		resultsArea.setFont(this.getFont());
		resultsArea.setLineWrap(true);
		resultsArea.setWrapStyleWord(true);
		resultsArea.setText(debug);
		return resultsArea;
	}
	
	private JScrollPane buildScrollPane(JTextArea resultsArea) {
		JScrollPane scrollPane = new JScrollPane(resultsArea);
		scrollPane.setPreferredSize(new Dimension(w - 15, h - 100));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		return scrollPane;
	}
	
	private void updateResults() {
		TroopCalc newCalc = new TroopCalc(Integer.parseInt(lordPower.getText()), Integer.parseInt(lordCastleLevel.getText()));
		String resultsString = "Lord Power: " + lordPower.getText() + "\nLord Castle Level: " + lordCastleLevel.getText() + "\n" + newCalc.resultsString;
		resultsArea.append(resultsString);
		newCalc = null;
		resultsString = null;
	}
}
