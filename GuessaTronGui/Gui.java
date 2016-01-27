import javax.swing.*;

public class Gui extends JPanel
{
	private JButton firstButton, secondButton, thirdButton, fourthButton;
	private JLabel firstLabel, secondLabel, thirdLabel;
	private JPanel rootPanel, labelPanel, buttonPanel;
	
	public Gui() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Initialize the JPanels.
		labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		
		buttonPanel = new JPanel();
		
		// Initialize the JButtons.
		firstButton = new JButton("Higher");
		secondButton = new JButton("Lower");
		thirdButton = new JButton("yes");
		fourthButton = new JButton("Reset");
		
		// Initialize the JLabels.
		firstLabel = new JLabel("Welcome to GuessaTron I will guess your number ");
		firstLabel.setAlignmentX(firstLabel.CENTER_ALIGNMENT);
		secondLabel = new JLabel("Between 1 - 100");
		secondLabel.setAlignmentX(secondLabel.CENTER_ALIGNMENT);
		thirdLabel = new JLabel("Is your Number Higher Or Lower Than?");
		thirdLabel.setAlignmentX(thirdLabel.CENTER_ALIGNMENT);
		
		
		// Add the JButtons to the buttonPanel.
		buttonPanel.add(firstButton);
		buttonPanel.add(secondButton);
		buttonPanel.add(thirdButton);
		buttonPanel.add(fourthButton);
		
		// Add the JLabels to the labelPanel.
		labelPanel.add(firstLabel);
		labelPanel.add(secondLabel);
		labelPanel.add(thirdLabel);
		
		// Add the panels to the Gui().
		add(labelPanel);
		add(buttonPanel);
	}
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("GuessaTron(TM)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Gui newContentPane = new Gui();
		
		frame.setContentPane(newContentPane);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main( String [] args ) {
		createAndShowGUI();
	}
}
