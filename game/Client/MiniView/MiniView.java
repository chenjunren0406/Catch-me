package jc82_yw31.Client.MiniView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * The GUI of the chat room
 * 
 * @author YC_YW
 *
 */
public class MiniView extends JFrame {

	private static final long serialVersionUID = 3696670673513553187L;

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JButton btnJoin = new JButton("Join");
	private final JTextField remoteInfo = new JTextField();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
			true, panel_1, panel_2);
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textArea = new JTextArea();
	private final JPanel panel_3 = new JPanel();
	private final JTextField text_message = new JTextField();
	private final JPanel panel_4 = new JPanel();
	private final JButton btnSendText = new JButton("Send Text");
	/**
	 * the adapter for the minimodel
	 */
	private MiniModelAdapter minimodel;
	private final JPanel panel_5 = new JPanel();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTextArea textArea_connection = new JTextArea();
	private final JComboBox<String> comboBox = new JComboBox<String>();
	private final JLabel lblCurrentUsersIn = new JLabel("User history");
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_7 = new JPanel();


	/**
	 * Constructor of the class
	 * @param ma the ModelAdapter 
	 */
	public MiniView(MiniModelAdapter minimodel) {
		super("ChatRoom GUI");
		this.minimodel = minimodel;
		initGUI();
	}

	/**
	 *  this is init method for view 
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panel.setBackground(Color.GREEN);		
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		panel_6.setBackground(Color.GREEN);

		panel.add(panel_6);
		panel_6.add(lblCurrentUsersIn);
		lblCurrentUsersIn.setLabelFor(comboBox);
		comboBox.setToolTipText("The list of the users");
		panel_6.add(comboBox);
		panel_7.setBackground(Color.GREEN);

		panel.add(panel_7);
		remoteInfo.setToolTipText("Please enter the invitee's IP address");
		panel_7.add(remoteInfo);
		remoteInfo.setColumns(10);
		btnJoin.setToolTipText("Click to invite a remote user");
		panel_7.add(btnJoin);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minimodel.invite(remoteInfo.getText());
			}
		});
		contentPane.add(splitPane, BorderLayout.CENTER);		
		splitPane.setLeftComponent(panel_1);
		splitPane.setResizeWeight(0.8);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		scrollPane.setViewportBorder(new TitledBorder(null, "ChatRoom Message", TitledBorder.LEADING, TitledBorder.TOP, null, null));		
		panel_1.add(scrollPane);		
		textArea.setToolTipText("show the chatroom message ");
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panel_5.setBorder(new TitledBorder(null, "Connection Information", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));	
		scrollPane.setColumnHeaderView(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));		
		panel_5.add(scrollPane_1);		
		panel_5.setPreferredSize(new Dimension(100,100));
		textArea_connection.setToolTipText("show the connection information");
		scrollPane_1.setViewportView(textArea_connection);
		
		textArea_connection.setLineWrap(true);
		textArea_connection.setWrapStyleWord(true);
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel_3.setBorder(new TitledBorder(null, "Please type your message below", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));		
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));		
		text_message.setToolTipText("Please type the text message here");
		panel_3.add(text_message);
		text_message.setColumns(10);
		panel_4.setBackground(Color.GREEN);		
		contentPane.add(panel_4, BorderLayout.SOUTH);		
		btnSendText.setToolTipText("Send a text message");
		panel_4.add(btnSendText);

		/**
		 * add action listeners to the buttons of the miniview
		 */
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			/**
			 * tell the minimodel to quit if the window is closing.
			 */
			public void windowClosing(WindowEvent evt) {
				System.out.println("this.windowClosing, event="+evt);
				minimodel.quit();
			}
		});
		/**
		 * action listener for the sendText button
		 */
		btnSendText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = text_message.getText();
				minimodel.sendText(text);
				text_message.setText("");
			}
		});
	}
	/**
	 * append the connection information on the text_connection textArea
	 * @param s
	 */
	public void appendInfo(String s){
		textArea_connection.append(s + "\n");
	}
	/**
	 * Starts the view by making it visible.
	 */
	public void start() {
		setVisible(true);
	}
	/**
	 * add the new user's name to the comboBox
	 * @param newUser
	 */
	public void addUserName(String newUser){
		comboBox.addItem(newUser);
	}
	/**
	 * append the text message on the textArea
	 * 
	 * @param s
	 */
	public void append(String s) {
		textArea.append(s + "\n" + "\n");	
	}

	/**
	 * add a new component to the GUI when needed
	 * @param name
	 * @param newComp
	 */
	public void addComponent(String name, Component newComp) {
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(newComp);
		frame.setBounds(200, 200, 800, 500);
		frame.setVisible(true);
		
		
	}


}
