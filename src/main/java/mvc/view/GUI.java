package mvc.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GUI {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Simple Swing Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JButton button = new JButton("Click Me");
			frame.getContentPane().add(button);
			
			frame.pack();
			frame.setVisible(true);
		});
	}

}
