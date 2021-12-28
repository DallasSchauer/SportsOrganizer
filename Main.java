package sportOrganizer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

    	//run the window in its own thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            		//Creates the window
                    GUI frame = new GUI();
                    
                    //size window to its components
                    frame.pack();
                    
                    //make window visible
                    frame.setVisible(true);
                    
                    //when program is started, maximize window by default
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    
                    //stop program when the X button is pushed
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
	}
}
