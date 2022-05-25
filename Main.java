package sportOrganizer;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Toolkit;

public class Main {

	public static void main(String[] args) {
		
		// Used for debugging purposes
		boolean bypassAccountCreating = false;
		
		if(bypassAccountCreating == false) {
	        //opens login window upon startup
	    	//run the window in its own thread
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	
	            		//Creates the login window
	                    GUILoginWindow loginWindow = new GUILoginWindow();
	                    
	                    //make window visible
	                    loginWindow.setVisible(true);

	                    //when program is started, set the size of the window to a fraction of the screen size
	                    Dimension bounds = Toolkit.getDefaultToolkit().getScreenSize();
	                    loginWindow.setSize(bounds.width / 3, bounds.height / 3);
	                    
	                    //sizes window to the edge of elements in the window
	                    //loginWindow.pack();
	                    
	                    //stop program when the X button is pushed
	                    loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            }
	        });
		} else {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	
	            		//Creates the "create account" window
	                    GUIMainWindow mainWindow = new GUIMainWindow();
	                    
	                    mainWindow.setVisible(true);
	                    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            }
	        });
		}
	}
}
