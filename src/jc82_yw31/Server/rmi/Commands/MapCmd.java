package jc82_yw31.Server.rmi.Commands;




import java.rmi.RemoteException;


import jc82_yw31.GameApi.GameController;
import jc82_yw31.Server.MiniModel.Amap;

import jc82_yw31.Server.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import provided.mixedData.IMixedDataDictionary;
import provided.mixedData.MixedDataKey;
import comp310f13.rmiChat.IStatusOk;

public class MapCmd extends ADataPacketAlgoCmd<ADataPacket, Amap, Void>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2455107210424040306L;
	private transient ICmd2ModelAdapter cmd2ModelAdapter;
    /**
     * the constructor of the default Command
     */
	public MapCmd(){
		
	}
	 /**
     * the set the command to model adapter
     */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter =  cmd2ModelAdpt;				
	}
	/**
	 * return a IRequest dataPacket to ask the sender for the command to process the data
	 */

	public ADataPacket apply(Class<?> index, DataPacket<Amap> host,
			Void... params) {
		
		GameController game = new GameController(host.getSender(),cmd2ModelAdapter.getLocalUserStub());
		MixedDataKey<GameController> gamecontrol = null;
		try {
			gamecontrol = new MixedDataKey<GameController>(
				host.getSender().getUUID(), "gameController", GameController.class);
		} catch (RemoteException e) {
			System.err.println("can not generate mixdatakey: gamecontrol in mapcmd");
			e.printStackTrace();
		}
		IMixedDataDictionary dict = cmd2ModelAdapter.getDataDict();
		dict.put(gamecontrol, game);
		game.start();
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
	}
	

}
