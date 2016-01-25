package com.rhairy.guessatron;

import javax.swing.*;

public class GuessaTronGui
{
	public static void main( String [] args )
	{
		// Build frame.
		JFrame mainFrame = new JFrame( "GuessaTron(TM)" );
		mainFrame.setSize( 450, 200 );
		mainFrame.setLocation( 100, 100 );
		mainFrame.setVisible( true );
		
		// Set up a JPanel component and add it to the mainFrame.
		JPanel buttonPanel = new JPanel();
		mainFrame.add( buttonPanel );
		
		// Text probably needs to be added to its own JPanel with different layout manager.
		// Add a text label to display the introduction and instructions.
		//JLabel introLabel1 = new JLabel("Welcome to GuessaTron I will guess your number");
		//JLabel introLabel2 = new JLabel( "Between 1 - 100" );
		//JLabel introLabel3 = new JLabel( "Is your Number Higher Or Lower Than?" );
		//buttonPanel.add( introLabel1 );
		//buttonPanel.add( introLabel2 );
		//buttonPanel.add( introLabel3 );
		
		// Add buttons to the contentPane.
		JButton higherButton = new JButton( "Higher" );
		JButton lowerButton = new JButton( "Lower" );
		JButton yesButton = new JButton( "Yes" );
		JButton resetButton = new JButton( "Reset" );
		
		buttonPanel.add( higherButton );
		buttonPanel.add( lowerButton );
		buttonPanel.add( yesButton );
		buttonPanel.add( resetButton );
	}
}