package jc82_yw31.Client.View;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is a client Frame 
 * @author Junren
 *
 */
public class client_frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7414248734115395076L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JTextField ipTextField = new JTextField();
	private final JButton btnConnect = new JButton("Connect");
	private final JTextArea textArea = new JTextArea();
	
	private ModelAdapter modeladapter;
	private final JButton JoinButton = new JButton("Join");

	/**
	 * Create the frame.
	 */
	public client_frame(ModelAdapter modeladapter) {
		this.modeladapter = modeladapter;
		ipTextField.setToolTipText("input the ip address of the server you want to connect");
		ipTextField.setColumns(30);
		initGUI();
		
	}
	private void initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.add(ipTextField);
		btnConnect.setToolTipText("connect the server");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread thread = new Thread(new Runnable() {
					public void run() {
						modeladapter.ConnectAndMakeChooseOption(ipTextField.getText());
						
					}
				});
				thread.start();
				
			//	modeladapter.ConnectAndMakeChooseOption(ipTextField.getText());
			}
		});
		
		panel.add(btnConnect);
		JoinButton.setToolTipText("join the chat room ");
		JoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread thread = new Thread(new Runnable() {
					public void run() {
						modeladapter.join();
						
					}
				});
				thread.start();
			}
		});
		
		panel.add(JoinButton);
		textArea.setToolTipText("information of the connecting process");
		textArea.setForeground(Color.RED);
		textArea.setBackground(Color.WHITE);
		textArea.setRows(10);
		textArea.setColumns(40);
		
		panel.add(textArea);
	}
	/**
	 * show string on the client side
	 * @param s
	 */
	public void append(String s){
		textArea.append(s);
	}
	/**
	 * start the client view
	 */
	public void start() {
		setVisible(true);
		
	}
}
