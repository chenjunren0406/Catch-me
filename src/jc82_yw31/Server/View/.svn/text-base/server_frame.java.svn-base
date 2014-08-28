package jc82_yw31.Server.View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * this is main frame of server
 * @author Junren
 *
 */
public class server_frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7904197903066499886L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JButton btnLobby = new JButton("Create Lobby");
	private final JTextArea textArea = new JTextArea();
	private ModelAdapter modeladapter;



	/**
	 * Create the frame.
	 */
	public server_frame(ModelAdapter modeladapter) {
		this.modeladapter = modeladapter;
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel, BorderLayout.CENTER);
		btnLobby.setToolTipText("create a game lobby");
		btnLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeladapter.createLobby();
			}
		});
		
		panel.add(btnLobby);
		textArea.setToolTipText("show the connection information");
		textArea.setColumns(50);
		textArea.setRows(10);
		
		panel.add(textArea);
	}
	public void append(String s){
		textArea.append(s);
	}
	public void start(){
		setVisible(true);
	}

}
