package com.rhairy.guessatron;

import javax.swing.*;

public class GuessaTronGui extends JPanel
{
	private JPanel panelContent, panelButton, panelText;
	private JButton buttonHigher, buttonLower, buttonYes, buttonReset;
	
	public GuessaTronGui()
	{
		buttonHigher = new JButton("Higher");
		buttonLower = new JButton("Lower");
		buttonYes = new JButton("Yes");
		buttonReset = new JButton("Reset");
		
		add(buttonHigher);
		add(buttonLower);
		add(buttonYes);
		add(buttonReset);
	}
	
	public static void createAndShowGUI()
	{
		JFrame frame = new JFrame("GuessaTronGui(TM)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GuessaTronGui newContentPane = new GuessaTronGui();
		
		frame.setContentPane(newContentPane);
		
		// Display the frame.
		frame.pack();
		frame.setVisible(true);
	}
	public static void main( String [] args )
	{
		createAndShowGUI();
	}
}