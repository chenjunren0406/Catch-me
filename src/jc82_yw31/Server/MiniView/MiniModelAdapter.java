package jc82_yw31.Server.MiniView;

/**
 * the interface the miniview uses to communicate with the minimodel
 */
public interface MiniModelAdapter {

	/**
	 * Quits the chat room and ask other users to remove you from the chat room.
	 */
	public void quit();
	/**
	 * Send a text message to the chat room
	 */
	public void sendText(String text);
	/**
	 * Send an invitation to a remote user, which returns true if the remote user accepts the invitation.
	 * Then send the chat room to the remote user, who will add himself to the chat room and broadcast to other users. 
	 */
	public void invite(String remoteUser);
	public void startGame();

}
