package sportOrganizer;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

    	//run the window in its own thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            		//Creates the login window
                    LoginWindow loginWindow = new LoginWindow();
                    
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
	}
}
