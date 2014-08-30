package jc82_yw31.GameApi;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import jc82_yw31.Server.MiniModel.Map;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

/**
 * This is GameFrame for player to play
 * @author Junren
 *
 */
public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5785926480685877259L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JTextArea textArea = new JTextArea();
	private final JSplitPane splitPane = new JSplitPane();
	private final JRadioButton rdbtnSelection = new JRadioButton("selection 1");
	private final JRadioButton rdbtnSelection_1 = new JRadioButton("selection 2");
	private final JSplitPane splitPane_1 = new JSplitPane();
	private final JRadioButton rdbtnSelection_2 = new JRadioButton("selection 3");
	private final JRadioButton rdbtnSelection_3 = new JRadioButton("selection 4");
	private final JTextArea textArea_1 = new JTextArea();
	private final JButton btnSubmit = new JButton("submit");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JScrollPane questionJScrollPane =  new JScrollPane(textArea);
	private final JScrollPane resultJScrollPane = new  JScrollPane(textArea_1);
	private GameModelAdpt gameModelAdpt;
	private int end = 0;
	private int index = 0;
	private int TeamNO = 0;

	/**
	 * Launch the application.
	 */
	private Map gameMap = new Map();
	private final JLabel TeamLabel = new JLabel("New label");

	/**
	 * Create the frame.
	 */
	public GameFrame(GameModelAdpt gameModelAdpt) {
		this.gameModelAdpt = gameModelAdpt;
		initGUI();
	}
	/**
	 * Initiate GUI for player to play
	 */
	private void initGUI() {
		buttonGroup.add(rdbtnSelection_1);
		buttonGroup.add(rdbtnSelection);
		buttonGroup.add(rdbtnSelection_2);
		buttonGroup.add(rdbtnSelection_3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panel.setBackground(Color.ORANGE);
		
		contentPane.add(panel, BorderLayout.NORTH);
		textArea.setToolTipText("show information of our question");
		textArea.setColumns(10);
		textArea.setRows(6);
		
		questionJScrollPane.setPreferredSize(new Dimension(350, 100));
		resultJScrollPane.setPreferredSize(new Dimension(200, 70));
		panel.add(questionJScrollPane);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		panel.add(splitPane);
		rdbtnSelection.setToolTipText("click this button if you choose selection1");
		
		splitPane.setLeftComponent(rdbtnSelection);
		rdbtnSelection_1.setToolTipText("click this button if you choose selection2");
		
		splitPane.setRightComponent(rdbtnSelection_1);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		panel.add(splitPane_1);
		rdbtnSelection_2.setToolTipText("click this button if you choose selection3");
		
		splitPane_1.setLeftComponent(rdbtnSelection_2);
		rdbtnSelection_3.setToolTipText("click this button if you choose selection4");
		
		splitPane_1.setRightComponent(rdbtnSelection_3);
		textArea_1.setToolTipText("show the answer of your selection");
		textArea_1.setRows(6);
		textArea_1.setColumns(10);
		textArea.setText("");
		textArea.append("Now it's time for playing game!" + "\n" + "Be ready to catch your opponent using your brilliant brain!");
		textArea.append("\n");
		textArea.append("the  " + index + "  question is :" + "\n");
		textArea.append(gameModelAdpt.popNewQuestion(index));
		panel.add(resultJScrollPane);
		end = gameModelAdpt.getEnd();
		btnSubmit.setToolTipText("submit the answer");
		/**
		 * when client submit, it should pop a new question 
		 */
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
					gameModelAdpt.answerOneQuestion();
				    textArea_1.setText("");
					int selection = 0;
					if(rdbtnSelection.isSelected()) selection = 1;
					else if(rdbtnSelection_1.isSelected()) selection = 2;
					else if(rdbtnSelection_2.isSelected()) selection = 3;
					else selection = 4;
					int result = gameModelAdpt.getAnswer(index);
					if(result == selection)
					{
						textArea_1.append("your answer is right!" + "\n" + "You win 1 point for your team!");
						gameModelAdpt.sendAnswerToServer(1);
					}
					else{
						textArea_1.setText("");
						textArea_1.append("Your answer is wrong!");
					}
					index++;
					textArea.setText("");
					rdbtnSelection.setSelected(false);
					rdbtnSelection_1.setSelected(false);
					rdbtnSelection_2.setSelected(false);
					rdbtnSelection_3.setSelected(false);
				if(index == end){
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "you have done all questions! Please wait your teammate...", "message", JOptionPane.PLAIN_MESSAGE);
					jOptionPane.setVisible(true);

					btnSubmit.setEnabled(false);
				}
				else{
					textArea.setText("");
					textArea.append("the question" + index + "is :" + "\n");
					textArea.append(gameModelAdpt.popNewQuestion(index));
				}
				
			}
		});
		TeamLabel.setToolTipText("show your status");
		
		panel.add(TeamLabel);
		
		TeamLabel.setText("please wait for grouping........");
		panel.add(btnSubmit);
		panel_1.setBackground(Color.PINK);
		btnSubmit.setEnabled(false);
		contentPane.add(gameMap, BorderLayout.CENTER);
	}
	
	/**
	 * Use to another to get map
	 * @return gamemap
	 */
	public Map getMap(){
		return gameMap;
	}
	/**
	 * Use to setBounds
	 */
	public void start(){
		setBounds(100, 150, 1000, 700);
		this.setVisible(true);
	}
	/**
	 * Use to show some string on the gameframe
	 * @param s
	 */
	public void append(String s){
		textArea.append(s);
	}
	/**
	 * set teamNo to gameView
	 * @param teamNo
	 */
	public void setTeamNo(int teamNo){
		this.TeamNO = teamNo;
		if(teamNo == 1)
			TeamLabel.setText("You are thief");
		else
			TeamLabel.setText("You are police");
		
		btnSubmit.setEnabled(true);
	}
	
	/**
	 * show which team win the game
	 * @param teamNO
	 */
	@SuppressWarnings("static-access")
	public void ShowWhichTeamWin(int teamNO){
		
		if(this.TeamNO == teamNO){
			JOptionPane winOptionPane = new JOptionPane();
			winOptionPane.showMessageDialog(null, "you team win...Happy Winter!!!!", "Win", JOptionPane.PLAIN_MESSAGE);
			winOptionPane.setVisible(true);
		}
		else{
			JOptionPane loseOptionPane = new JOptionPane();
			loseOptionPane.showMessageDialog(null, "you team lose.....try harder next time...Happy Winter!", "Lose", JOptionPane.PLAIN_MESSAGE);
			loseOptionPane.setVisible(true);
 
		}
		
		btnSubmit.setEnabled(false);
		this.dispose();
	}
}
