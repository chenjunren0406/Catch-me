package jc82_yw31.Client.MiniModel;

import provided.datapacket.ADataPacket;
import comp310f13.rmiChat.IStatusFail;
/**
 * the status fail datapacket type 
 * when the user cannot process the known datapacket
 * then the fail datapacket will be sent
 * @author Administrator
 *
 */
public class StatusFail implements IStatusFail{

	private static final long serialVersionUID = 8858877109209466294L;
	private String failMsg;
	private ADataPacket dataPkt;
	/**
	 * the constructor of the datapkt. It stores the dataPkg for further processing.
	 * @param dataPkt
	 */
	public StatusFail(ADataPacket dataPkt){
		this.dataPkt = dataPkt;
		this.failMsg = "Failed to process the data";
	}
	/**
	 * get the msg of the fail 
	 */
	public String getMsg() {
		return failMsg;
	}

	/**
	 * get the datapakcet of the fail 
	 */
	public ADataPacket getDataPacket() {
		return dataPkt;
	}

}
