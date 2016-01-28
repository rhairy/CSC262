import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JPanel
				 implements ActionListener {
					 
	private int high, low, offer;
	private JButton higherButton, lowerButton, yesButton, resetButton;
	private JLabel firstLabel, secondLabel, thirdLabel, offerLabel, bragLabel;
	private JPanel labelPanel, buttonPanel, bragPanel;
	
	public Gui() {
		high = 100;
		low = 1;
		offer = 50;
		
		// Set BoxLayout for root JPanel.
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Initialize the JPanels.
		labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		
		buttonPanel = new JPanel();
		
		bragPanel = new JPanel();
		
		// Initialize the JButtons.
		higherButton = new JButton("Higher");
		lowerButton = new JButton("Lower");
		yesButton = new JButton("yes");
		resetButton = new JButton("Reset");
		
		// Set the JButton ActionCommands.
		higherButton.setActionCommand("Higher");
		lowerButton.setActionCommand("Lower");
		yesButton.setActionCommand("Yes");
		resetButton.setActionCommand("Reset");
		
		// Set their EventListeners.
		higherButton.addActionListener(this);
		lowerButton.addActionListener(this);
		yesButton.addActionListener(this);
		resetButton.addActionListener(this);
		
		// Initialize the JLabels.
		firstLabel = new JLabel("Welcome to GuessaTron I will guess your number ");
		firstLabel.setAlignmentX(firstLabel.CENTER_ALIGNMENT);
		
		secondLabel = new JLabel("Between 1 - 100");
		secondLabel.setAlignmentX(secondLabel.CENTER_ALIGNMENT);
		
		thirdLabel = new JLabel("Is your Number Higher Or Lower Than?");
		thirdLabel.setAlignmentX(thirdLabel.CENTER_ALIGNMENT);
		
		offerLabel = new JLabel("> " + Integer.toString(offer) + " <");
		offerLabel.setForeground(Color.RED);
		offerLabel.setAlignmentX(offerLabel.CENTER_ALIGNMENT);
		// Increase the font size and make bold.
		offerLabel.setFont(new Font("Serif", Font.BOLD, 16));

		bragLabel = new JLabel("");
		bragLabel.setAlignmentX(bragLabel.CENTER_ALIGNMENT);
		// Make the color red.
		bragLabel.setForeground(Color.RED);
	

		
		
		// Add the JButtons to the buttonPanel.
		buttonPanel.add(higherButton);
		buttonPanel.add(lowerButton);
		buttonPanel.add(yesButton);
		buttonPanel.add(resetButton);
		
		// Add the JLabels to the labelPanel.
		labelPanel.add(firstLabel);
		labelPanel.add(secondLabel);
		labelPanel.add(thirdLabel);
		labelPanel.add(offerLabel);
		
		// Add the JLables to the bragPanel.
		bragPanel.add(bragLabel);
		
		// Add the panels to the Gui().
		add(labelPanel);
		add(buttonPanel);
		
		// Add the bragLabel to the end.
		add(bragPanel);
	}
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("GuessaTron Final Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 200);
		
		// Disable resizing.
		frame.setResizable(false);
		
		Gui newContentPane = new Gui();
		
		newContentPane.validate();
		frame.setContentPane(newContentPane);
		
		frame.setVisible(true);
	}
	
	public static void main( String [] args ) {
		createAndShowGUI();
	}

	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();  
		if( command.equals( "Higher" ))  {
			low = offer;
			offer = (low + high) / 2;
			offerLabel.setText("> " + Integer.toString(offer) + " <");
		} else if( command.equals( "Lower" ) )  {
			high = offer;
			offer = (low + high) / 2;
			offerLabel.setText("> " + Integer.toString(offer) + " <");
		} else if ( command.equals("Yes") ) {
			// Brag that you have guessed their answer.
			bragLabel.setText("I told you I would get the answer Ha Ha!");
			
			// Disable buttons.
			yesButton.setEnabled(false);
			higherButton.setEnabled(false);
			lowerButton.setEnabled(false);
		} else  {
			// Reset buttons and variables to their defaults.
			offer = 50;
			low = 1;
			high = 100;
			offerLabel.setText("> " + Integer.toString(offer) + " <");
			
			// Hide the bragLabel.
			bragLabel.setText("");
			
			// Enable the input buttons if they are disabled.
			yesButton.setEnabled(true);
			higherButton.setEnabled(true);
			lowerButton.setEnabled(true);
		}  	
	}		

}