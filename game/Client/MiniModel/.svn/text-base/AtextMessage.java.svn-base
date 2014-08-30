package jc82_yw31.Client.MiniModel;

import java.util.Date;

import comp310f13.rmiChat.ITextMessage;
/**
 * the textMessage datapacket type 
 * @author Administrator
 *
 */
public class AtextMessage implements ITextMessage {
	
	private static final long serialVersionUID = 1688733186938461279L;
	private String senderName; 
    private String message;
    private Date time;
    /**
     * the constructor of the textMessage
     * @param senderName is the sender name
     * @param message is the message to be sent
     */
    public AtextMessage(String senderName, String message){
    	this.senderName = senderName;
    	this.message = message;
    	this.time = new Date();
    }
    /**
     * get the name of the sender
     */
	public String getName() {
        return senderName;
	}
	/**
	 * get the time of the message sent
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * get the message to be sent
	 */
	public String getMsg() {
		return message;
	}

}
