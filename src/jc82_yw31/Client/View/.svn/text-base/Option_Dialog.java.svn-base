package jc82_yw31.Client.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comp310f13.rmiChat.IChatRoomInvite;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * this is an Option panel for client to choose chartroom to join
 * @author Junren
 *
 */
public class Option_Dialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6465840129118434549L;
	private final JPanel contentPanel = new JPanel();
	private final JComboBox<String> optionComboBox = new JComboBox<String>();
	private IChatRoomInvite chooseInvite;
	private final HashMap<String, IChatRoomInvite> map = new HashMap<String,IChatRoomInvite>();
	/**
	 * Create the dialog.
	 */
	public Option_Dialog(Iterable<IChatRoomInvite> chatroomInfo) {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			for(IChatRoomInvite temp : chatroomInfo){
				optionComboBox.addItem(temp.getName());
				map.put(temp.getName(), temp);
			}
			contentPanel.add(optionComboBox);
			
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						chooseInvite = map.get(optionComboBox.getItemAt(optionComboBox.getSelectedIndex()));
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public IChatRoomInvite getReturnInvite(){
		return chooseInvite;
	}
}
