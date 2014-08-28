package jc82_yw31.Server.MiniModel;

import comp310f13.rmiChat.IRequestCmd;
/**
 * the request cmd datapacket type 
 * when receive the unknown datapacket 
 * the request cmd datapacket will be sent
 * @author Administrator
 *
 */
public class ArequestCmd implements IRequestCmd {
	private static final long serialVersionUID = 8675407131016413991L;
	private Class<?> id;
	/**
	 * the constructor of the request cmd
	 * @param id the class type
	 */
	public ArequestCmd (Class<?> id){
		this.id = id;
	}

	/**
	 * get the id of the class
	 */
	public Class<?> getID() {
		return id;
	}

}
