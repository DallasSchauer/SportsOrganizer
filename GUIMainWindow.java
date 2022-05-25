package sportOrganizer;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUIMainWindow extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//panel declaration
	static JPanel topLeftPanel;
	static JPanel topRightPanel;
	
	//label declaration
	static JLabel peopleLabel;
	static JLabel scheduleLabel;
	static JLabel gamesLabel;
	static JLabel leaguesLabel;
	static JLabel tournamentsLabel;
	
	//button declaration
	static JButton playersButton;
	static JButton coachesButton;
	static JButton officialsButton;
	static JButton staffButton;
	static JButton teamsButton;
	
	//text area creation
	static JTextArea scheduleArea;
	static JTextArea gamesArea;
	static JTextArea leaguesArea;
	static JTextArea tournamentsArea;
	
	//scroll panes
	static JScrollPane scheduleScroll;
	
	//create colors
	static Color panelColor = new Color(148, 148, 148);
	
	GUIMainWindow() {
		
		//window settings
		setTitle("SLAM Sports Organizer");
		setResizable(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//panel creation
		topLeftPanel = new JPanel();
		topLeftPanel.setBackground(panelColor);
		
		topRightPanel = new JPanel();
		topRightPanel.setBackground(panelColor);
		
		//label creation
		peopleLabel = new JLabel("People");
		scheduleLabel = new JLabel("Schedule");
		gamesLabel = new JLabel("Games");
		leaguesLabel = new JLabel("Leagues");
		tournamentsLabel = new JLabel("Tournaments");
		
		//button creation
		playersButton = new JButton("Players");
		playersButton.addActionListener(this);
		
		coachesButton = new JButton("Coaches");
		coachesButton.addActionListener(this);
		
		officialsButton = new JButton("Officials");
		officialsButton.addActionListener(this);
		
		staffButton = new JButton("Staff");
		staffButton.addActionListener(this);
		
		teamsButton = new JButton("Teams");
		teamsButton.addActionListener(this);
		
		//text areas
		scheduleArea = new JTextArea(36, 80);
		scheduleArea.setEditable(false);
		
		gamesArea = new JTextArea(15, 80);
		gamesArea.setEditable(false);
		
		leaguesArea = new JTextArea(15, 80);
		leaguesArea.setEditable(false);
		
		tournamentsArea = new JTextArea(15, 80);
		tournamentsArea.setEditable(false);
		
		//scroll panes
		scheduleScroll = new JScrollPane(scheduleScroll);
		scheduleScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//initialize variable for setting parameters for each element in the window
		GridBagConstraints positionConst = null;
		positionConst = new GridBagConstraints();
		
		/*
		Thinking about adding a private method called posProperties(Insets insets, GridBagConstraints cellPos, 
		int gridwidth, int gridx, int gridy)
		
		It would return the positionConst variable needed for these GUI elements.
		
		This would compact code greatly by reducing much redundant code, but might decrease read/writability. Thoughts?
		 */
		
		try {
			//Layout type
			//Grid bag layout positions elements in/across cells in a grid
			setLayout(new GridBagLayout());
			
			//PANELS
			//topleft panel
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.fill = GridBagConstraints.BOTH;
			positionConst.gridwidth = 2;
			positionConst.gridx = 0;
			positionConst.gridy = 0;
			add(topLeftPanel, positionConst);
			
			//topright panel
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.fill = GridBagConstraints.BOTH;
			positionConst.gridwidth = 2;
			positionConst.gridx = 3;
			positionConst.gridy = 0;
			add(topRightPanel, positionConst);
			
			//LABELS
			//people label
			positionConst.anchor = GridBagConstraints.LINE_START;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 1;
			add(peopleLabel, positionConst);
			
			//schedule label
			positionConst.anchor = GridBagConstraints.LINE_START;
			positionConst.gridwidth = 1;
			positionConst.gridx = 1;
			positionConst.gridy = 1;
			add(scheduleLabel, positionConst);
			
			//games label
			positionConst.anchor = GridBagConstraints.LINE_START;
			positionConst.gridwidth = 1;
			positionConst.gridx = 3;
			positionConst.gridy = 1;
			add(gamesLabel, positionConst);
			
			//leagues label
			positionConst.anchor = GridBagConstraints.LINE_START;
			positionConst.gridwidth = 1;
			positionConst.gridx = 3;
			positionConst.gridy = 3;
			add(leaguesLabel, positionConst);
			
			//tournaments label
			positionConst.anchor = GridBagConstraints.LINE_START;
			positionConst.gridwidth = 1;
			positionConst.gridx = 3;
			positionConst.gridy = 5;
			add(tournamentsLabel, positionConst);
			
			//BUTTONS
			//players button
			positionConst = new GridBagConstraints();
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.NORTH;
			positionConst.fill = GridBagConstraints.HORIZONTAL;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 2;
			add(playersButton, positionConst);
			
			//coaches button
			positionConst = new GridBagConstraints();
			positionConst.insets = new Insets(32, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.NORTH;
			positionConst.fill = GridBagConstraints.HORIZONTAL;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 2;
			add(coachesButton, positionConst);
			
			//officials button
			positionConst = new GridBagConstraints();
			positionConst.insets = new Insets(61, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.NORTH;
			positionConst.fill = GridBagConstraints.HORIZONTAL;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 2;
			add(officialsButton, positionConst);
			
			//staff button
			positionConst = new GridBagConstraints();
			positionConst.insets = new Insets(90, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.NORTH;
			positionConst.fill = GridBagConstraints.HORIZONTAL;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 2;
			add(staffButton, positionConst);
			
			//team button
			positionConst = new GridBagConstraints();
			positionConst.insets = new Insets(119, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.NORTH;
			positionConst.fill = GridBagConstraints.HORIZONTAL;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 2;
			add(teamsButton, positionConst);
			
			//reset insets
			positionConst.insets = new Insets(3, 3, 3, 3);
			
			//text areas/scroll panes
			//Schedule
			positionConst.fill = GridBagConstraints.BOTH;
			positionConst.gridwidth = 2;
			positionConst.gridheight = 10;
			positionConst.gridx = 1;
			positionConst.gridy = 2;
			add(scheduleArea, positionConst);
			
			positionConst.gridwidth = 1;
			positionConst.gridx = 1;
			positionConst.gridy = 2;
			add(scheduleScroll, positionConst);
			
			//Games
			positionConst.fill = GridBagConstraints.BOTH;
			positionConst.gridwidth = 2;
			positionConst.gridheight = 1;
			positionConst.gridx = 3;
			positionConst.gridy = 2;
			add(gamesArea, positionConst);
			
			//Leagues
			positionConst.fill = GridBagConstraints.BOTH;
			positionConst.gridwidth = 2;
			positionConst.gridheight = 1;
			positionConst.gridx = 3;
			positionConst.gridy = 4;
			add(leaguesArea, positionConst);
			
			//Tournaments
			positionConst.fill = GridBagConstraints.BOTH;
			positionConst.gridwidth = 2;
			positionConst.gridheight = 1;
			positionConst.gridx = 3;
			positionConst.gridy = 6;
			add(tournamentsArea, positionConst);
			
		} catch (Exception e) {
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
