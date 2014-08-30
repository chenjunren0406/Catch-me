package jc82_yw31.Client.MiniView;

import java.awt.BorderLayout;


import javax.swing.JFrame;


import map.MapLayer;
import map.MapPanel;

/**
 *  This is a test frame, not used in game
 * @author Junren
 *
 */
public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 551984480929192393L;
	private MapPanel mapPanel;
	/**
	 * Create the frame.
	 */
	public GameFrame(MapLayer map) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mapPanel = new MapPanel();
		getContentPane().add(mapPanel, BorderLayout.CENTER);
		mapPanel.setPreferredSize(new java.awt.Dimension(600, 400));
	}

}
