package jc82_yw31.Server.MiniModel;

import comp310f13.rmiChat.IAddUser;
import comp310f13.rmiChat.IUser;
/**
 * add user is used to add new user to the chatroom
 * @author Administrator
 *
 */
public class AaddUser implements IAddUser {
    private IUser user_stub;
	private static final long serialVersionUID = -2826312891191493396L;
	/**
	 * the constructor of the adduser
	 * @param user_stub
	 */
    public AaddUser(IUser user_stub){
    	this.user_stub = user_stub;
    }
	/**
	 * the get the user stub
	 */
	public IUser getUser() {
		return user_stub;
	}

}
