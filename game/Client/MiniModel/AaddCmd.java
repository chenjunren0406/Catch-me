package jc82_yw31.Client.MiniModel;

import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import comp310f13.rmiChat.IAddCmd;
/**
 * the addcmd type of datapacket
 * the new cmd is used to get the cmd sent
 * the cmdID is used to set the id of the cmd
 * @author Administrator
 *
 */
public class AaddCmd implements IAddCmd {

	private static final long serialVersionUID = 2906609792670633609L;
	private ADataPacketAlgoCmd<ADataPacket, ?, Void> newCmd;
	private Class<?> cmdID;
    /**
     * the constructor of the addCmd
     * @param cmd is the new cmd to be add
     * @param cmdID is the id(the type) of the cmd
     */

	public AaddCmd(ADataPacketAlgoCmd<ADataPacket, ?, Void> cmd, Class<?> cmdID){
		this.newCmd = cmd;
		this.cmdID = cmdID;
	}
	
	/**
	 * get the id of the cmd
	 */
	public Class<?> getID() {
		return cmdID;
	}

	/**
	 * the get new cmd 
	 */
	public ADataPacketAlgoCmd<ADataPacket, ?, Void> getNewCmd() {
		return newCmd;
	}

}
