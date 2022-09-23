import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;




public class TimerPopup {


	
	public static void display(String message) {
			
	}
	
	private static Point bottomRightPoint() {
		Rectangle rec = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
		
		int x = (int) rec.getMaxX();
		int y = (int) rec.getMaxY();
		
		return new Point(x, y);
		
	}

}
