
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;

	private static final int DEFAULT_HEIGHT = 200;

	private int numClicks;

	public ButtonFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		

		// create buttons
		JButton changeButton = new JButton("Change");
		JButton resetButton = new JButton("Reset");
		JButton closeButton = new JButton("Close");

		buttonPanel = new JPanel();

		// add buttons to panel
		buttonPanel.add(changeButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(closeButton);

		// add panel to frame
		add(buttonPanel);

		// create button actions
		ColorChange changeAction = new ColorChange();
		ResetColor resetAction = new ResetColor();
		CloseWindow closeAction = new CloseWindow();

		// associate actions with buttons
		changeButton.addActionListener(changeAction);
		resetButton.addActionListener(resetAction);
		closeButton.addActionListener(closeAction);
	}

	private class ColorChange implements ActionListener {
		private Color backgroundColor;

		public ColorChange() {
			numClicks = 0;
		}

		public void actionPerformed(ActionEvent event) {
			numClicks++;
			numClicks = numClicks % 4;

			Color c = Color.WHITE;
			if (numClicks % 4 == 1) {
				c = Color.BLACK;
			} else if (numClicks % 4 == 2) {
				c = Color.GREEN;
			} else if (numClicks % 4 == 3) {
				c = Color.ORANGE;
			} else if (numClicks % 4 == 0) {
				c = Color.PINK;
			}

			backgroundColor = c;

			buttonPanel.setBackground(backgroundColor);
		}

	}

	private class ResetColor implements ActionListener {
		private Color backgroundColor = Color.WHITE;

		public ResetColor() {

		}

		public void actionPerformed(ActionEvent event) {

			numClicks = 0;
			buttonPanel.setBackground(backgroundColor);
		}

	}

	private class CloseWindow implements ActionListener {
		public CloseWindow() {

		}

		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

}