import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class TimerPopup {


	
	public static void display(String message) {
		
		JFrame frame = new JFrame();
		frame.setLocation(bottomRightPoint());
		frame.setVisible(true);
		
		JOptionPane.showMessageDialog(frame, message);
		
		frame.dispose();		
	}
	
	private static Point bottomRightPoint() {
		Rectangle rec = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
		
		int x = (int) rec.getMaxX();
		int y = (int) rec.getMaxY();
		
		return new Point(x, y);
		
	}

}
